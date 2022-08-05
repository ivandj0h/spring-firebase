package ivandjoh.online.springfirestore.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import ivandjoh.online.springfirestore.http.request.FirebaseUserRequest;
import ivandjoh.online.springfirestore.http.request.chatdetails.DataItem;
import ivandjoh.online.springfirestore.http.response.FirebaseResponse;
import ivandjoh.online.springfirestore.service.FirestoreService;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class FirestoreServiceImpl implements FirestoreService {

    @Value("${firebase.collection-name}")
    private String collectionUser;

    @Value("${firebase.collection-name-chat}")
    private String collectionChat;

    @Override
    public ResponseEntity<?> getAllUsers()
            throws JsonParseException, JsonMappingException, IOException
    {
        String data = "{\"statusCode\": 200, \"status\": \"success\", \"statusMessage\": \"Hello World\"}";
        FirestoreServiceImpl json = new FirestoreServiceImpl();
        return ResponseEntity.ok(json.converter(data));
    }

    public String saveUser(FirebaseUserRequest userRequest)
            throws JsonParseException, JsonMappingException, ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        String userId = "userId-" + userRequest.getUserId();
        String chatId = userRequest.getChatId();

        DocumentReference documentReference = db.collection(collectionUser).document(userId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();


        if (document.exists()) {

            Map<String, Object> data = new HashMap<>();
            ArrayList<Object> ch = new ArrayList<>();
            Collections.addAll(ch, document.getData(), chatId);
            data.put(getSaltString(), chatId);
            ApiFuture<WriteResult> saveChat = db.collection(collectionUser).document(userId).set(data, SetOptions.merge());

            return saveChat.get().getUpdateTime().toString();
        } else {
            Map<String, Object> data = new HashMap<>();
            data.put(getSaltString(), chatId);
            ApiFuture<WriteResult> future1 = db.collection(collectionUser).document(userId).set(data);

            return future1.get().getUpdateTime().toString();
        }

    }

    public String saveChat(DataItem dataItem)
            throws JsonParseException, JsonMappingException, ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        String chatId = "chatId-" + dataItem.getId();
        String title = dataItem.getTitle();

        DocumentReference documentReference = db.collection(collectionChat).document(chatId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {

            Map<String, Object> data = new HashMap<>();
            ArrayList<Object> ch = new ArrayList<>();
            Collections.addAll(ch, document.getData(), chatId);
            data.put(getSaltStringChat(), chatId);
            ApiFuture<WriteResult> saveChat = db.collection(collectionChat).document(chatId).set(data, SetOptions.merge());

            return saveChat.get().getUpdateTime().toString();
        } else {
            Map<String, Object> data = new HashMap<>();
            data.put(getSaltStringChat(), chatId);
            ApiFuture<WriteResult> future1 = db.collection(collectionChat).document(chatId).set(data);
            return future1.get().getUpdateTime().toString();
        }
    }

    private Object converter(String data) throws IOException {
        return new ObjectMapper().readValue(data, FirebaseResponse.class);
    }

    protected String getSaltString() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = "chatId-" + salt.toString();
        return saltStr;

    }

    protected String getSaltStringChat() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = "chatId-" + salt.toString();
        return saltStr;

    }
}

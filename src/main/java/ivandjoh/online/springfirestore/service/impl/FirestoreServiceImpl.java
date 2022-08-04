package ivandjoh.online.springfirestore.service.impl;

import ivandjoh.online.springfirestore.http.response.FirebaseResponse;
import ivandjoh.online.springfirestore.service.FirestoreService;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FirestoreServiceImpl implements FirestoreService {

    @Override
    public ResponseEntity<?> getAllUsers()
            throws JsonParseException, JsonMappingException, IOException
    {
        String data = "{\"statusCode\": 200, \"status\": \"success\", \"statusMessage\": \"Hello World\"}";
        FirestoreServiceImpl json = new FirestoreServiceImpl();
        return ResponseEntity.ok(json.converter(data));
    }



    private Object converter(String data) throws IOException {
        return new ObjectMapper().readValue(data, FirebaseResponse.class);
    }
}

package ivandjoh.online.springfirestore.controller;

import ivandjoh.online.springfirestore.http.request.FirebaseUserRequest;
import ivandjoh.online.springfirestore.http.request.chatdetails.DataItem;
import ivandjoh.online.springfirestore.service.FirestoreService;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class FirestoreController {

    @Autowired
    FirestoreService firestoreService;


    @GetMapping("/firestore")
    public ResponseEntity<?> getAllUsers() throws JsonParseException, JsonMappingException, IOException {
        log.info("--- Get all users ---");

        return firestoreService.getAllUsers();
    }

    @PostMapping("/firestore/save")
    public String saveProduct(@RequestBody FirebaseUserRequest userRequest) throws ExecutionException, InterruptedException, IOException {

        return firestoreService.saveUser(userRequest);
    }

    @PostMapping("/firestore/save-chat")
    public String saveChat(@RequestBody DataItem dataItem) throws ExecutionException, InterruptedException, IOException {

        return firestoreService.saveChat(dataItem);
    }
}

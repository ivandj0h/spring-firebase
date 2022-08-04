package ivandjoh.online.springfirestore.controller;

import ivandjoh.online.springfirestore.service.FirestoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class FirestoreController {

    @Autowired
    FirestoreService firestoreService;

    @GetMapping("/firestore")
    public ResponseEntity<?> getAllUsers() {
        log.info("--- Get all users ---");
        try {
            return firestoreService.getAllUsers();
        } catch (org.codehaus.jackson.JsonParseException e) {
            throw new RuntimeException(e);
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package ivandjoh.online.springfirestore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class FirestoreController {

    @GetMapping("/firestore")
    public String hello() {

        log.info("Hello from Firestore");
        String message = "{\"messages\": \"Hello from Firestore\"}";
        return message;
    }
}

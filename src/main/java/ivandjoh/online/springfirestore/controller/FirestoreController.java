package ivandjoh.online.springfirestore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class FirestoreController {

    @GetMapping("/firestore")
    public String hello() {
        return "Hello World";
    }
}

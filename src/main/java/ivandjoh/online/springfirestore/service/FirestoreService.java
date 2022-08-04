package ivandjoh.online.springfirestore.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.codehaus.jackson.JsonParseException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FirestoreService {

    ResponseEntity<?> getAllUsers() throws JsonParseException, JsonMappingException, IOException;
}

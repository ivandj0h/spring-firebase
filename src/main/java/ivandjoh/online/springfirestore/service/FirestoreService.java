package ivandjoh.online.springfirestore.service;

import ivandjoh.online.springfirestore.http.request.FirebaseUserRequest;
import ivandjoh.online.springfirestore.http.request.HttpFirstQuestionRequest;
import ivandjoh.online.springfirestore.http.request.chatdetails.DataItem;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface FirestoreService {

    ResponseEntity<?> getAllUsers() throws JsonParseException, JsonMappingException, IOException;

    String saveUser(FirebaseUserRequest userRequest) throws JsonParseException, JsonMappingException, IOException, ExecutionException, InterruptedException;

    String saveChat(DataItem dataItem) throws JsonParseException, JsonMappingException, IOException, ExecutionException, InterruptedException;

    String saveFirstQuestion(HttpFirstQuestionRequest firstQuestion) throws JsonParseException, JsonMappingException, IOException, ExecutionException, InterruptedException;
}

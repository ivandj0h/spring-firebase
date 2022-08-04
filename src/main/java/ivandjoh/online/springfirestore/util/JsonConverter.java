package ivandjoh.online.springfirestore.util;

import ivandjoh.online.springfirestore.http.response.FirebaseUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class JsonConverter {

    public Object fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
        FirebaseUserResponse converterResult = new ObjectMapper().readValue(json, FirebaseUserResponse.class);

        return converterResult;
    }
}

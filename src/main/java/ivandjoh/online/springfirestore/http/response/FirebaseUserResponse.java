package ivandjoh.online.springfirestore.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"user_id", "chat_id"})
public class FirebaseUserResponse {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("chat_id")
    private String chatId;

}

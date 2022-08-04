package ivandjoh.online.springfirestore.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"chat_id", "message", "created_at", "updated_at"})
public class FirebaseChatResponse {

        @JsonProperty("chat_id")
        private String chatId;
        @JsonProperty("message")
        private String message;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;

}

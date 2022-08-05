package ivandjoh.online.springfirestore.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;

@Data
public class HttpFirstQuestionRequest {
    @DocumentId
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("doctor_id")
    private String doctorId;
    @JsonProperty("content")
    private String content;
    @JsonProperty("chat_id")
    private String chatId;
}

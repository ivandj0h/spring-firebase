package ivandjoh.online.springfirestore.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"status_code", "status", "message"})
public class FirebaseResponse {

    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_message")
    private String statusMessage;

}

package ivandjoh.online.springfirestore.http.request;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;

@Data
public class FirebaseUserRequest {
    @DocumentId
    public String userId;
    public String chatId;

}

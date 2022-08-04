package ivandjoh.online.springfirestore.http.request;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

@Data
public class FirebaseChatRequest {
    private String chatId;
    private String message;
    @CreationTimestamp
    private String createdAt;
    @LastModifiedDate
    private String updatedAt;
}

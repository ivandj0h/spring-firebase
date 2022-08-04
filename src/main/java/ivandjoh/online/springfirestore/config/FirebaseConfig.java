package ivandjoh.online.springfirestore.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import org.springframework.stereotype.Service;
import com.google.firebase.FirebaseOptions;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseConfig {

    @PostConstruct
    public void initialization() {
        FileInputStream serviceAccount =null;

        try {
            serviceAccount = new FileInputStream("./serviceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

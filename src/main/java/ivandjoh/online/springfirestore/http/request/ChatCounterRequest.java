package ivandjoh.online.springfirestore.http.request;

import lombok.Data;

@Data
public class ChatCounterRequest {
    int myCount;
    public ChatCounterRequest() {
        myCount = 0;
    }
    public int increment() {
        return myCount++;
    }
    public void reset() {
        myCount = 0;
    }
    public int value() {
        return myCount;
    }
}

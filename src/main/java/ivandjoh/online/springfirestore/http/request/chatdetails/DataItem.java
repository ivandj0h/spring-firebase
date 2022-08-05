package ivandjoh.online.springfirestore.http.request.chatdetails;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;

import java.util.List;

@Data
public class DataItem {
	@DocumentId
	private String id;
	private String createdAt;
	private boolean isSaidThanks;
	private String title;
	private String timePickedUp;
	private String content;
	private Doctor doctor;
	private boolean isDoctorOnline;
	private List<AnswerItem> answer;
	private String updatedAt;
	private String noticeAnonymous;
	private String shortContent;
	private int userUnreadCount;
	private User user;
	private boolean isClosed;
}
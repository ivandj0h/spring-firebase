package ivandjoh.online.springfirestore.http.request.chatdetails;

import lombok.Data;

@Data
public class AnswerItem{
	private String firstname;
	private String createdAt;
	private String content;
	private String lastname;
	private Object referralName;
	private String updatedAt;
	private String answerType;
	private String userId;
	private String userPicture;
	private Object referralId;
	private Object referralData;
	private String id;
	private String dataUrl;
}
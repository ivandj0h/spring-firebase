package ivandjoh.online.springfirestore.http.request.chatdetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
		"id",
		"content",
		"firstname",
		"lastname",
		"referralData",
		"data_url",
		"created_at",
		"updated_at",
		"user_id",
		"user_picture",
		"referral_name",
		"answer_type",
		"referral_id"
})
public class AnswerItem{
	@JsonProperty("id")
	private String id;
	@JsonProperty("content")
	private String content;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("referralData")
	private Object referralData;
	@JsonProperty("data_url")
	private String dataUrl;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("user_picture")
	private String userPicture;
	@JsonProperty("referral_name")
	private Object referralName;
	@JsonProperty("answer_type")
	private String answerType;
	@JsonProperty("referral_id")
	private Object referralId;
}
package ivandjoh.online.springfirestore.http.request.chatdetails;

import lombok.Data;

@Data
public class Response{
	private Result result;
	private String statusMessage;
	private int statusCode;
	private String status;
}
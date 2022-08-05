package ivandjoh.online.springfirestore.http.request.chatdetails;

import lombok.Data;

@Data
public class Doctor{
	private String firstname;
	private DoctorSpeciality doctorSpeciality;
	private String userPicture;
	private String id;
	private String lastname;
}
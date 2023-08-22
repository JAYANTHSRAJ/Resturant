package dto;

import java.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;



@Entity
@Data
public class CoustomerSignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Fullname;
	private String Email;
	private long Mobile;
	private String Password;
	private String Gender;
	private LocalDate Dob;
	private int age;
	@Lob
	private byte[]picture;
	
	

}

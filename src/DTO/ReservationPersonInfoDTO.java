package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationPersonInfoDTO {

	private String username;
	private String password;
	private String phoneNum;
	private String address;
	private String email;
	private String licenseGrade;

}

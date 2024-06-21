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
	
	private int personId;
	private String name;
	private String licenseNum;
	private String licenseGreade;
	private String phoneNum;
	
}

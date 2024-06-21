package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarInfoDTO {
	
	//private int id; // 아이디
	private String carname; // 차량이름
	private String carid;
	private String cartype; // 분류
	private String brand; // 회사
	private String puel; // 유종  
	private String needlicence; 
	private int priceperday; 

}

package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SelectDTO {
	
	private String carname;
	private String cartype;
	private String brand;
	private String puel;
	private String needlicence;
	private int priceperday;

}

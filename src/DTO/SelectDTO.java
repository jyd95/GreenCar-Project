package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class SelectDTO {
	private String carname;
	private String cartype;
	private String brand;
	private String puel;
	private String needlicence;
	private int priceperday;
	
	public SelectDTO(String carname, String cartype, String brand, String puel, String needlicence, int priceperday) {
		super();
		this.carname = carname;
		this.cartype = cartype;
		this.brand = brand;
		this.puel = puel;
		this.needlicence = needlicence;
		this.priceperday = priceperday;
	}
	public SelectDTO() {
		super();
	}

	
	
}

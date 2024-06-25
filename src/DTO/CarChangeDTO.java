package DTO;



public class CarChangeDTO {
	private String carname;


	@Override
	public String toString() {
		return carname;
	}


	public CarChangeDTO(String carname) {
		this.carname = carname;
	}
	
}


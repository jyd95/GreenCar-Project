package DTO;


public class ReservationPersonInfoDTO {
	
	private int personId;
	private String name;
	private String licenseNum;
	private String licenseGreade;
	private String phoneNum;
	
	public ReservationPersonInfoDTO(int personId, String name, String licenseNum, String licenseGreade,
			String phoneNum) {
		this.personId = personId;
		this.name = name;
		this.licenseNum = licenseNum;
		this.licenseGreade = licenseGreade;
		this.phoneNum = phoneNum;
	}

	public ReservationPersonInfoDTO() {
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getLicenseGreade() {
		return licenseGreade;
	}

	public void setLicenseGreade(String licenseGreade) {
		this.licenseGreade = licenseGreade;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	
}

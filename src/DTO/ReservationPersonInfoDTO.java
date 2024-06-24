package DTO;

public class ReservationPersonInfoDTO {

	private int personId;
	private String name;
	private String password;
	private String address;
	private String email;
	private String licenseGrade;
	private String licenseNum;
	private String licenseGreade;
	private String phoneNum;

	public ReservationPersonInfoDTO(String username, String password, String phoeNum, String address, String email,
			String licenseGrade) {
		this.name = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.licenseGrade = licenseGrade;
		this.phoneNum = phoeNum;
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

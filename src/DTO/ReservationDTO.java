package DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ReservationDTO {
	private int id; // 사용자 id ,예약번호
	private String name; // 예약자 이음
	private String carname; // 예약자 차
	private String cartype; // 차 브랜
	private String brand; // 차종
	private String puel; // 유
	private String Phonenum;
	private Date rentdate; // 렌트일
	private Date returndate; // 종료일
	private int totalprice; // 금액
	private int paymentornot; // 결제 여부
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPuel() {
		return puel;
	}
	public void setPuel(String puel) {
		this.puel = puel;
	}
	public String getPhonenum() {
		return Phonenum;
	}
	public void setPhonenum(String phonenum) {
		Phonenum = phonenum;
	}
	public Date getRentdate() {
		return rentdate;
	}
	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getPaymentornot() {
		return paymentornot;
	}
	public void setPaymentornot(int paymentornot) {
		this.paymentornot = paymentornot;
	}
	
	
}

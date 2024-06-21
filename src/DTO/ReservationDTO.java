package DTO;

import java.sql.Date;

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

}

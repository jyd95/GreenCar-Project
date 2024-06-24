package DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ReservationDTO {
	private int reservation_id; // 사용자 id ,예약번호
	private String username; // 예약자 이음
	private String carname; // 예약자 차
	private String carid;
	private String cartype; // 차 브랜
	private String brand; // 차종
	private String puel; // 유
	private String phonenum;
	private Date start_date; // 렌트일
	private Date end_date; // 종료일
	private int priceperday; // 금액
	private String licenseGrade;
	
}

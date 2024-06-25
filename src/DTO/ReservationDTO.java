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

//select r.reservation_id,r.username,ci.carname,cm.carid,ci.cartype,ci.brand,
//ci.puel,r.start_date,r.end_date,ci.priceperday,u.licenseGrade 
//from reservation as r 
//join users as u on r.username= u.username 
//join carmanagement as cm on cm.carid= r.carid 
//join carinfo as ci on cm.carname= ci.carname 
//where carname=? and u.username=?; ";

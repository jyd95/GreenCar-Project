package DAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import DTO.CarInfoDTO;
import DTO.ReservationDTO;
import DTO.ReservationInfoDTO;
import DTO.ReservationPersonInfoDTO;
import DTO.SelectDTO;

public interface reservationImploy {

	// 예약 번호로 조회하는 쿼리
	public ReservationDTO reservationNumSelec(int id) throws SQLException;

	// 예약자 이름으로 조회하는 쿼리
	public List<ReservationDTO> reservationNameSelec(String name) throws SQLException;

	// 차량을 유종별로 조회
	public List<CarInfoDTO> selecPuel(String puel) throws SQLException;

	// 차량을 차종으로 조회
	public List<SelectDTO> viewCarType(String cartype) throws SQLException;

	// 차량을 이름으로 조회
	public List<SelectDTO> viewNameType(String name) throws SQLException;

	// 차량을 브랜드로 조회
	public List<SelectDTO> viewBrandType(String brand) throws SQLException;

	// 차량을 요구면허로 조회하는 쿼리
	public List<SelectDTO> viewneedLicenceType(String needlicence) throws SQLException;

	// 차량을 1일당 가격 순으로 오름차순 정렬하는 쿼리(최저가 정렬)
	public List<SelectDTO> orderAscPriceType() throws SQLException;

	// 차량을 1일당 가격 순으로 오름차순 정렬하는 쿼리(최고가 정렬)
	public List<SelectDTO> orderDescPriceType() throws SQLException;
	
	// 차량 변경
	public void changeCat(String carid, int id) throws SQLException;
	
	// 렌트일 변경
	public void changeRent(Date rentDate, int id) throws SQLException;
	
	// 반납일 변경 
	public void changeReturn(Date returnDate, int id) throws SQLException;
	
	// 예약 1단계
	public void insertPerson(String name,String licenseNum, String licenseGreade, String phoneNum) throws SQLException;

	
	
}

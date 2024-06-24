package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.CarInfoDTO;
import DTO.ReservationCarDTO;
import DTO.ReservationDTO;
import DTO.ReservationPersonInfoDTO;
import DTO.SelectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class CarDAO {

	static int state;
	CarDAO carDAO = getCarDAO();

	// 오버라이드 삭제 -> 스태틱 넣음
	public static ReservationDTO DeleteReservation(int id) {
		ReservationDTO reservationDTO = null;

		String query = " DELETE from reservation WHERE reservation_id = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservationDTO;
	}

	public static void changeDate(Date rentDate, Date returnDate, int id) throws SQLException {

		String query = " UPDATE reservation SET start_date = ? , end_date = ? WHERE reservation_id = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, rentDate);
			pstmt.setDate(2, returnDate);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// select u.username, r.start_date, r.end_date from carinfo as ci join
	// carmanagement as cm on ci.carname = cm.carname join reservation as r on
	// r.carid = cm.carid join users as u on u.username = r.username where
	// ci.carname = ?;

	// select u.username, r.start_date, r.end_date from carinfo as ci join
	// carmanagement as cm on ci.carname = cm.carname join reservation as r on
	// r.carid = cm.carid join users as u on u.username = r.username where
	// ci.carname = ?;

	public static boolean isDateRangeAvailable(String carname, Date startDate, Date endDate) {
		String query = " SELECT * FROM reservation as r join carmanagement as cm on r.carid = cm.carid WHERE cm.carname = ? AND ((start_date <= ? AND end_date >= ?) OR (start_date <= ? AND end_date >= ?) OR (start_date >= ? AND end_date <= ?)) ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, carname);
			pstmt.setDate(2, new java.sql.Date(startDate.getTime()));
			pstmt.setDate(3, new java.sql.Date(startDate.getTime()));
			pstmt.setDate(4, new java.sql.Date(endDate.getTime()));
			pstmt.setDate(5, new java.sql.Date(endDate.getTime()));
			pstmt.setDate(6, new java.sql.Date(startDate.getTime()));
			pstmt.setDate(7, new java.sql.Date(endDate.getTime()));

			ResultSet rs = pstmt.executeQuery();
			return !rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ReservationDTO reservationNumSelec(int id, String name) {

		ReservationDTO reservationDTO = null;

		String query = " select r.reservation_id, r.username, ci.carname, cm.carid,ci.cartype,ci.brand,ci.puel,u.phonenum,r.start_date,r.end_date,ci.priceperday, u.licenseGrade from reservation as r join users as u on r.username = u.username join carmanagement as cm on cm.carid = r.carid join carinfo as ci on cm.carname = ci.carname where reservation_id = ? and u.username = ?;";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int reservation_id = rs.getInt("reservation_id");
				String username = rs.getString("username");
				String carname = rs.getString("carname");
				String carid = rs.getString("carid");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel = rs.getString("puel");
				String phonenum = rs.getString("phonenum");
				Date start_date = rs.getDate("start_date");
				Date end_date = rs.getDate("end_date");
				int priceperday = rs.getInt("priceperday");
				String licenseGrade = rs.getString("licenseGrade");

				reservationDTO = new ReservationDTO(reservation_id, username, carname, carid, cartype, brand, puel,
						phonenum, start_date, end_date, priceperday, licenseGrade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservationDTO;
	}

	public static void changeCar(String carid, int id) throws SQLException {
		String query = " Update reservation set carid = ? where reservation_id = ? ";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, carid);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {

		}

	}

	public static List<ReservationDTO> reservationNameSelec(String name) throws SQLException {
		List<ReservationDTO> list = new ArrayList<>();
		String query = " SELECT ri.id, rp.name, cm.carname, ci.cartype, ci.brand, ci.puel , rp.PhoneNum, re.rentDate, re.returnDate, datediff(re.returnDate,re.rentDate)*ci.priceperday as totalprice, ri.pay as paymentOrNot from reservationInfo as ri join reservationPersonInfo as rp on ri.personid = rp.personid join recruittable as re on re.id = ri.id join carmanagement as cm on cm.carid = re.carid join carinfo as ci on ci.carname = cm.carname where rp.name = ? order by re.rentDate desc; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int reservation_id = rs.getInt("reservation_id");
				String username = rs.getString("username");
				String carname = rs.getString("carname");
				String carid = rs.getString("carid");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel = rs.getString("puel");
				String phonenum = rs.getString("phonenum");
				Date start_date = rs.getDate("start_date");
				Date end_date = rs.getDate("end_date");
				int priceperday = rs.getInt("priceperday");
				String licenseGrade = rs.getString("paymentornot");
				list.add(new ReservationDTO(reservation_id, username, carname, carid, cartype, brand, puel, phonenum,
						start_date, end_date, priceperday, licenseGrade));
			}

		}
		return list;
	}

	public static List<CarInfoDTO> selecPuel(String puel) throws SQLException {
		List<CarInfoDTO> list = new ArrayList<>();

		String query = " select cm.carname, cm.carid, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where ci.puel = ?; ";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, puel);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String carname = rs.getString("carname");
				String carid = rs.getString("carid");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				CarInfoDTO dto = new CarInfoDTO(carname, carid, cartype, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}

		return list;
	}

	public static List<SelectDTO> viewCarType(String cartype) throws SQLException {
		List<SelectDTO> list = new ArrayList<>();

		String query = " select cm.carname, cm.carid, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where ci.cartype = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cartype);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype1 = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				SelectDTO dto = new SelectDTO(carname, cartype1, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	public static List<SelectDTO> viewBrandType(String brand) throws SQLException {
		List<SelectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where ci.brand = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, brand);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand1 = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				SelectDTO dto = new SelectDTO(carname, cartype, brand1, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	public static List<ReservationCarDTO> viewNameType(String carname) throws SQLException {
		List<ReservationCarDTO> list = new ArrayList<>();

		String query = " select r.reservation_id,u.username, r.start_date, r.end_date from carinfo as ci join carmanagement as cm on ci.carname = cm.carname join reservation as r on r.carid = cm.carid join users as u on u.username = r.username where ci.carname = ?;  ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, carname);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int reservationid = rs.getInt("reservation_id");
				String username = rs.getString("username");
				Date startdate = Date.valueOf(rs.getString("start_date"));
				Date enddate = Date.valueOf(rs.getString("end_date"));
				ReservationCarDTO dto = new ReservationCarDTO(reservationid, username, startdate, enddate);
				list.add(dto);
			}
		}
		return list;
	}

	public static List<SelectDTO> viewneedLicenceType(String needlicence) throws SQLException {
		List<SelectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where ci.needlicence = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, needlicence);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand1 = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence1 = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				SelectDTO dto = new SelectDTO(carname, cartype, brand1, puel1, needlicence1, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	public static List<SelectDTO> orderAscPriceType() throws SQLException {
		List<SelectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname order by ci.priceperday; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				SelectDTO dto = new SelectDTO(carname, cartype, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	public static List<SelectDTO> orderDescPriceType() throws SQLException {
		List<SelectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname order by ci.priceperday desc; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				SelectDTO dto = new SelectDTO(carname, cartype, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	public static void changeCat(String carid, int id) throws SQLException {
		String query = " Update recruittable set carid = ? where id = ? ";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, carid);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {

		}

	}

	public static void changeRent(Date rentDate, int id) throws SQLException {

		String query = " UPDATE recruittable SET rentDate = ? WHERE id = ? ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, rentDate);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void changeReturn(Date returnDate, int id) throws SQLException {
		String query = " UPDATE recruittable SET returnDate = ? WHERE id = ? ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, returnDate);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 인설트펄슨에서 인풋레저베이션 넥스트에 리턴값을 줘야 할거 같음
	// void -> int 월요일 수정 상의
	public static ReservationPersonInfoDTO insertPerson(String name, String password, String phoneNum, String address,
			String email, String licenseGrade) throws SQLException {

		ReservationPersonInfoDTO dto = null;

		String query = " INSERT INTO users(username, password, phonenum, address, email, licenseGrade) values(?, ?, ?, ?, ?, ?); ";
		// String select = " select * from users where phonenum = ? ";
		// String selectPay = " INSERT INTO users(personId, pay) values( ?, ?); ";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, phoneNum);
			pstmt.setString(4, address);
			pstmt.setString(5, email);
			pstmt.setString(6, licenseGrade);

			// PreparedStatement pstmt2 = conn.prepareStatement(select);
			// ResultSet rs = pstmt2.executeQuery();
//			while (rs.next()) {
//				String name2 = rs.getString("username");
//				String password2 = rs.getString("password");
//				String phoneNum2 = rs.getString("phonenum");
//				String address2 = rs.getString("address");
//				String email2 = rs.getString("email");
//				String licenseGrade2 = rs.getString("licenseGrade");
//				dto = new ReservationPersonInfoDTO(name2, password2, phoneNum2, address2, email2, licenseGrade2);
//
//			}
			pstmt.executeUpdate();
			System.out.println("업데이트");

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return dto;

	}

	public static void truePerson(String phone, int pay) throws SQLException {
		String query = "INSERT INTO reservationinfo(personId, pay) values( ? , ?) ";
		String selectPerson = "select * from reservationpersoninfo where phoneNum = ? ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt2 = conn.prepareStatement(selectPerson);
			pstmt2.setString(1, phone);
			ResultSet rs = pstmt2.executeQuery();
			int personId = 0;
			while (rs.next()) {
				personId = rs.getInt("personId");
				System.out.println(personId);
			}
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, personId);
			pstmt.setInt(2, pay);
			pstmt.executeUpdate();
			System.out.println("옴?");
		} catch (Exception e) {
			System.out.println("truePerson 오류");
			e.printStackTrace();
		}

	}

	public static void falsePerson(int pay) throws SQLException {
		String query = " INSERT INTO reservationinfo(personId, pay) values( (select max(personId) from reservationpersoninfo) , ?)  ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pay);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("falsePerson 오류");
			e.printStackTrace();
		}

	}

	public CarDAO getCarDAO() {
		return carDAO;
	}

	public void setCarDAO(CarDAO carDAO) {
		this.carDAO = carDAO;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
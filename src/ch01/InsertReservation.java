package ch01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.CarDAO;
import DAO.DBCarConnectionManager;

public class InsertReservation {
	private static int receivedid;
	private static String receivedname;
	private static String receivedCarname;
	private static String receivedStartDate;
	private static String receivedEndDate;

	public InsertReservation(String receivedCarname, String receivedStartDate, String receivedEndDate) {
		this.receivedCarname = receivedCarname;
		this.receivedStartDate = receivedStartDate;
		this.receivedEndDate = receivedEndDate;
	}

	public static int role(String carname, String username, String rentDate, String endDate) {
		Date rentDate2 = Date.valueOf(receivedStartDate);
		Date returnDate2 = Date.valueOf(receivedEndDate);
		String query2 = " select * from carmanagement where carname = ? ";
		String query = " insert reservation(username, carid, start_date, end_date) values ( ?, ? , ? , ? ) ";
		String carid = null;
		int rr = 0;
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, carname);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				carid = rs.getString("carid");
			}

			PreparedStatement pstmt2 = conn.prepareStatement(query);
			pstmt2.setString(1, username);
			pstmt2.setString(2, carid);
			pstmt2.setDate(3, rentDate2);
			pstmt2.setDate(4, returnDate2);
			rr = pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rr;

	}

}
//		ReservationDTO dto = CarDAO.reservationToCarAndDate(HomePagePanel.username, receivedCarname);
//		CarDAO.check(HomePagePanel.username, dto.getCarid(), rentDate2, returnDate2);
//		id.setText(Integer.toString(dto.getReservation_id()));
//		name.setText((dto.getUsername()));
//		phoneNumber.setText((dto.getPhonenum()));
//		carName.setText(dto.getCarname());
//		carNumber.setText(dto.getCarid());
//		cartype.setText((dto.getCartype()));
//		carbrand.setText((dto.getBrand()));
//		carpuel.setText((dto.getPuel()));
//		licenseGrade.setText(dto.getLicenseGrade());
//		rentdate.setText((dto.getStart_date().toString()));
//		returndate.setText((dto.getEnd_date().toString()));
//		// 차량 이미지
//		imgLabel = new JLabel(new ImageIcon(setCarPicture(dto.getCarname())));
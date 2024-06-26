package ch01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

	public static int role(String carname, String username, Date rentDate, Date endDate) {
		String query2 = " select carid from carmanagement where carname = ? ";
		String query = " insert reservation(username, carid, start_date, end_date) values ( ?, ? , ? , ? ) ";
		String query3 = "select * from reservation where username = ? and carid = ? and start_date = ? and end_date = ?";
		String carid = null;
		int reservationNum = 0;
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
			pstmt2.setDate(3, rentDate);
			pstmt2.setDate(4, endDate);
			rr = pstmt2.executeUpdate();
			
			PreparedStatement pstmt3 = conn.prepareStatement(query3);
			pstmt3.setString(1, username);
			pstmt3.setString(2, carid);
			pstmt3.setDate(3, rentDate);
			pstmt3.setDate(4, endDate);
			ResultSet rs2 = pstmt3.executeQuery();
			while(rs2.next()) {
				reservationNum = rs2.getInt("reservation_id");
			}
			
			JOptionPane.showConfirmDialog(null, "예약 완료\n" + "예약번호 : " + reservationNum, "알림", JOptionPane.DEFAULT_OPTION);
			
			
			

			
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
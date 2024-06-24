package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import DTO.CarInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarInfoDAO {

	CarInfoDTO carInfoDTO = null;
	int daoSize = 0;
	ResultSet rs = null;
	ResultSetMetaData ramd;
	String[] cName;
	String obj[][];

	// 차량 전체조회
	public void RECarInfoDAO() throws SQLException {

		String query = " select cm.carname as 차이름 ,cm.carid as 차번호, ci.cartype as 차종, ci.brand as 브랜드 , ci.puel as 유종, ci.needlicence as 필요면허, ci.priceperday as 일일가격 from carmanagement as cm join carinfo as ci on cm.carname = ci.carname; ";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = pstmt.executeQuery();

			ramd = rs.getMetaData(); // 메타데이터 추출

			int cols = ramd.getColumnCount(); // 컬럼의 갯수

			cName = new String[cols];
			System.out.println(cName.length);

			for (int i = 0; i < cName.length; i++) {
				cName[i] = ramd.getColumnName(i + 1);
				System.out.println(ramd.getColumnName(i + 1));
			}

			rs.last();
			int rowCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("===" + rowCount + "====");

			obj = new String[rowCount][cName.length];

			int index = 0;
			while (rs.next()) {
				for (int a = 0; a < cName.length; a++) {
					obj[index][a] = rs.getString(a + 1);
				}
				index++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 차량 삭제
	public boolean deleteCar(String carId) throws SQLException {
		String query = "DELETE FROM carmanagement WHERE carid = ?;";
		try (Connection conn = DBCarConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, carId);
			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// 차량등록
	public void addCar(String carName, String carId, String carType, String brand, String puel, String needLicence,
			int priceperday) throws SQLException {
		String query1 = "INSERT INTO carmanagement (carname, carid) VALUES (?, ?);";
		String query2 = "INSERT INTO carinfo (carname, cartype, brand, puel, needlicence, priceperday) VALUES (?, ?, ?, ?, ?, ?);";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			conn.setAutoCommit(false); // 트랜잭션 시작

			try (PreparedStatement pstmt1 = conn.prepareStatement(query1);
					PreparedStatement pstmt2 = conn.prepareStatement(query2)) {

				pstmt2.setString(1, carName);
				pstmt2.setString(2, carType);
				pstmt2.setString(3, brand);
				pstmt2.setString(4, puel);
				pstmt2.setString(5, needLicence);
				pstmt2.setInt(6, priceperday);
				pstmt2.executeUpdate();

				pstmt1.setString(1, carName);
				pstmt1.setString(2, carId);
				pstmt1.executeUpdate();

				conn.commit(); // 트랜잭션 커밋
			} catch (SQLException e) {
				conn.rollback(); // 트랜잭션 롤백
				throw e;
			} finally {
				conn.setAutoCommit(true); // 자동 커밋 복구
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 차량 가격 수정
	public boolean updateCarPrice(String carId, int newPrice) throws SQLException {
		String query = " update carinfo join carmanagement  on carinfo.carname = carmanagement.carname set carinfo.priceperday = ? where carmanagement.carid = ? ";

		try (Connection conn = DBCarConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, newPrice);
			pstmt.setString(2, carId);

			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	 // 차량 검색 
	public void searchCar(String criteria, String keyword) throws SQLException {
	    String query = "SELECT cm.carname , cm.carid , ci.cartype , ci.brand , ci.puel , ci.needlicence , ci.priceperday  " +
	                   "FROM carmanagement cm " +
	                   "JOIN carinfo ci ON cm.carname = ci.carname " +
	                   "WHERE " + criteria + " LIKE ?";
	    try (Connection conn = DBCarConnectionManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
	        pstmt.setString(1, "%" + keyword + "%");
	        rs = pstmt.executeQuery();
	        ramd = rs.getMetaData();
	        int cols = ramd.getColumnCount();
	        cName = new String[cols];
	        for (int i = 0; i < cols; i++) {
	            cName[i] = ramd.getColumnName(i + 1);
	        }
	        rs.last();
	        int rowCount = rs.getRow();
	        rs.beforeFirst();
	        obj = new String[rowCount][cols];
	        int index = 0;
	        while (rs.next()) {
	            for (int i = 0; i < cols; i++) {
	                obj[index][i] = rs.getString(i + 1);
	            }
	            index++;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


   
    
	public String[][] getObj() {
		return obj;
	}

	public String[] getCName() {
		return cName;
	}

	public void loadData() throws SQLException {
		RECarInfoDAO();
	}
}
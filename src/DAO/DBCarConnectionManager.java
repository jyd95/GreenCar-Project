package DAO;


import java.sql.Connection;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;


@Data
public class DBCarConnectionManager {

	private static final String URL = "jdbc:mysql://192.168.0.140:3306/greencar?serverTimezone=Asia/Seoul";
	private static final String USER = "tenco4";
	private static final String PASSWORD = "1q2w3e4r5t!";

	// 자기 자신의 참조 주소값을 담을 변수 생성 단. private
	private static DBCarConnectionManager instance;
	private static HikariDataSource dataSource;

	// static {} 블록 - 정적 초기화 블록
		// 클래스가 처음 로드 될 떄 한번 실행 됩니다.
		// 정적 변수의 초기화나 복잡한 초기화 작업을 수행 할 떄 사용
		// static {} 안에 예외를 던질 수도 있다.
		static {
			// HikariCP 를 사용 하기 위한 설정이 필요하다.
			// HikariConfig --> 제공해줘서 이클래스를 활용해서 설정을 상세히 할 수 있다.
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(URL);
			config.setUsername(USER);
			config.setPassword(PASSWORD);
			
			config.setMaximumPoolSize(10); // 최대 연결 수 설정 10
			
			dataSource = new HikariDataSource(config);
		}
		
		public static Connection getConnection() throws SQLException {
			return dataSource.getConnection();
		}
		
		// 테스트 코드 확인
		public static void main(String[] args) {
			
			try {
				Connection conn = DBCarConnectionManager.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}// end of main

}

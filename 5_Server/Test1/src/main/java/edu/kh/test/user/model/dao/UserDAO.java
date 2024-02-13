package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {
	Connection conn = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	public UserDTO selectUser(int userNo) {

		UserDTO user = null; // 결과저장용 변수
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String userName = "jhs_member";

			String password = "member1234";

			Class.forName(driver);

			conn = DriverManager.getConnection(url, userName, password);

			String sql = "SELECT * FROM TB_USER WHERE USER_NO = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				user = new UserDTO();

				user.setUserNo(rs.getInt("USER_NO"));

				user.setUserId(rs.getString("USER_ID"));

				user.setUserName(rs.getString("USER_NAME"));

				user.setUserAge(rs.getInt("USER_AGE"));

			}


		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return user;

	}

}

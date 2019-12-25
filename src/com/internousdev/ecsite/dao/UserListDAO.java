package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	public ArrayList<UserListDTO> getAllUserInfo() throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();

		String sql =
				"SELECT * FROM login_user_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserListDTO dto=new UserListDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				userListDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return userListDTO;
	}

	public static int userListHistoryDelete() throws SQLException{
//		↑エラー文でstaticをつけるように指示
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM login_user_transaction";

		PreparedStatement ps;
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;

	}
}

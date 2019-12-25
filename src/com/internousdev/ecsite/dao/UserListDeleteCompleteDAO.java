package com.internousdev.ecsite.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	public static int userListHistoryDelete() throws SQLException{
//		↑エラー文でstaticをつけるように指示
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM login_user_transaction where admin_flg is NULL";

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

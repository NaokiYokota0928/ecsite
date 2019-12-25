package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	public void createUser(String itemName, int intPrice, int intStock) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date) VALUES(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setInt(2, intPrice);
			ps.setInt(3, intStock);
			ps.setString(4, dateUtil.getDate());

			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				con.close();
		}
	}
}

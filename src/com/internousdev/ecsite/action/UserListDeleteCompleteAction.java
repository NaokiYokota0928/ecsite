package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport {

	private String message;

	public String execute() throws SQLException{


		int res = UserListDeleteCompleteDAO.userListHistoryDelete();

		if (res > 0) {

			setMessage("ユーザー情報を正しく削除しました。");
		} else if (res == 0) {
			setMessage("ユーザー情報の削除に失敗しました。");
		}

		return SUCCESS;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

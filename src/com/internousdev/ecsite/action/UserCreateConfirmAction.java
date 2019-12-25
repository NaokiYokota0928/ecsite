package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;
	private String errorMessage;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private Boolean alreadyExists = false;

	public String execute() {

		String result = SUCCESS;

		if (!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))) {
					session.put("loginUserId", loginUserId);
					session.put("loginPassword", loginPassword);
					session.put("userName", userName);
		} else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}

		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);

		if(loginUserId.equals(loginDTO.getLoginId())){
			alreadyExists=true;
			result=ERROR;

		}


		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Boolean getAlreadyExists() {
		return alreadyExists;
	}

	public void setAlreadyExists(boolean alreadyExists) {
		this.alreadyExists=alreadyExists;
	}
}
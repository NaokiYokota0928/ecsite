package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	public String execute(){
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
//			↑session参考https://www.atmarkit.co.jp/ait/articles/0108/29/news002.html
			result=SUCCESS;
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

//			if(loginDTO.getAdminFlg() == "1"){
//				session.put("adminFlg", "1");
//			}

			if(loginDTO.getAdminFlg()){
				session.put("adminFlg", true);
			}

			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}

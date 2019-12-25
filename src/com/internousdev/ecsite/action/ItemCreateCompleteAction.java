package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {

	private String itemName;
	private int itemPrice;
	private int itemStock;
	private Map<String, Object> session;
	ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();

	public String execute() throws SQLException{

		int intPrice = Integer.parseInt(session.get("itemPrice").toString());
		int intStock = Integer.parseInt(session.get("itemStock").toString());

		itemCreateCompleteDAO.createUser(
				session.get("itemName").toString(),
				intPrice,
				intStock);

		String result = SUCCESS;

		return result;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int setItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock=itemStock;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

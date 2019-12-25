package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemListDTO> itemList = new ArrayList<ItemListDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {

//		if (!session.containsKey("login_user_id")) {
//			return ERROR;
//		}
//		現段階（STEP3）では、このクラスの実行にログイン状態は必要なし

		if (deleteFlg == null) {
//			String item_transaction_id = session.get("id").toString();
//			String user_master_id = session.get("login_user_id").toString();
//			↑DBから入手するのはiitのみなので特定userに紐づいた情報＝結合のkeyは不要
			itemList = itemListDAO.getAllItemInfo();

		} else if (deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {


		int res = ItemListDAO.itemListHistoryDelete();

		if (res > 0) {
			itemList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public ArrayList<ItemListDTO> getItemList() {
		return this.itemList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

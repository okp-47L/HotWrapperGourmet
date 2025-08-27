package store;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.StoreBean;
import DAO.StoreDAO;
import tool.Action;

public class StoreEditAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		StoreBean storeInfo = (StoreBean)session.getAttribute("storeInfo");
		StoreDAO dao = new StoreDAO();
		StoreBean store = dao.getStoreInfo(storeInfo.getStoreCode());
		session.setAttribute("storeKeepInfo", store);
		
		return "store-edit.jsp";
	}
}

package store;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.StoreBean;
import DAO.StoreDAO;
import tool.Action;

public class StoreUpdateAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		StoreBean store = (StoreBean)session.getAttribute("storeKeepInfo");
		
		if (store == null) {
			return "store-error.jsp";
		}
		
		StoreDAO dao = new StoreDAO();
		boolean isUpdated = dao.update(store);
		
		if (isUpdated == false) {
			System.out.println("更新に失敗しました");
		}
		
		StoreBean storeInfo = dao.getStoreInfo(store.getStoreCode());
		session.setAttribute("storeInfo", storeInfo);
		
		return "store-update-completed.jsp";
	}
}

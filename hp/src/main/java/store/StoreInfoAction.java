package store;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.StoreBean;
import DAO.StoreDAO;
import tool.Action;

public class StoreInfoAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int storeCode = Integer.parseInt(request.getParameter("storeCode"));
		boolean isMatched = false;
		
		StoreDAO dao = new StoreDAO();
		List<StoreBean> list = dao.search("", 0, "", 0.0, null, null, 0);
		
		for (StoreBean store : list) {
			if (storeCode == store.getStoreCode()) {
				isMatched = true;
			}
		}
		
		if (isMatched == false) {
			return "store-info-error.jsp";
		}
		
		StoreBean storeInfo = dao.getStoreInfo(storeCode);
		
		HttpSession session = request.getSession();
		session.setAttribute("storeInfo", storeInfo);
		/*System.out.println(storeInfo.getRegularHoliday());*/
		return "store-info.jsp";
	}
}
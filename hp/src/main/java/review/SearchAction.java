package review;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.ReviewBean;
import Bean.StoreBean;
import DAO.ReviewDAO;
import tool.Action;

public class SearchAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ReviewDAO rDao = new ReviewDAO();
		StoreBean storeInfo = (StoreBean)session.getAttribute("storeInfo");
		int storeCode = storeInfo.getStoreCode();
		
		List<ReviewBean> reviewList = new ArrayList<>();
		reviewList = rDao.allGet(storeCode);
		
		session.setAttribute("reviewList", reviewList);
		
		return "../review/reviewList.jsp";
	}

}
 
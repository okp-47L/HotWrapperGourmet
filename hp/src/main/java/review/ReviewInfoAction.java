package review;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.ReviewBean;
import DAO.ReviewDAO;
import tool.Action;

public class ReviewInfoAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewCode = Integer.parseInt(request.getParameter("reviewCode"));
		ReviewDAO rDao = new ReviewDAO();
		ReviewBean reviewInfo = rDao.getReviewInfo(reviewCode);
		
		HttpSession session = request.getSession();
		session.setAttribute("reviewInfo", reviewInfo);
		return "reviewInfo.jsp";
	}

}

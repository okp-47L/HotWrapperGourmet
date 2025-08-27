package review;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.ReviewBean;
// import Bean.StoreBean;
import DAO.ReviewDAO;
// import DAO.StoreDAO;
import tool.Action;

public class deleteReviewAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ReviewBean reviewInfo = (ReviewBean)session.getAttribute("reviewInfo");
		int reviewCode = reviewInfo.getReviewCode();
		int storeCode = reviewInfo.getStoreCode();
		List<ReviewBean> reviewList = new ArrayList<>();

		ReviewDAO rDao = new ReviewDAO();
		boolean isReview = rDao.delete(reviewCode);
		if ( isReview == true) {
			reviewList = rDao.allGet(storeCode);
			session.setAttribute("reviewList", reviewList);
			return "deleteReviewSuccess.jsp";
		}else {
			request.setAttribute("error", "口コミの削除に失敗しました");
			return "deleteReview.jsp";
		}		
		
	}

}

package review;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import Bean.AccountBean;
import Bean.ReviewBean;
import Bean.StoreBean;
import DAO.ReviewDAO;
import tool.Action;

public class InsertAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		AccountBean aBean = (AccountBean)session.getAttribute("account");
		if (aBean == null ) {
			request.setAttribute("error", "ログインしていません");
			return "insertReviewError.jsp";
		}
		StoreBean sBean = (StoreBean)session.getAttribute("storeInfo");
		int accountCode = aBean.getAccountCode();
		String name = aBean.getName();
		int storeCode = sBean.getStoreCode();
		
		String reviewContent = request.getParameter("message");
		if (reviewContent == null || reviewContent == "" || reviewContent.isBlank()) {
			request.setAttribute("error", "投稿内容がありません");
			return "../review/insertReviewError.jsp";
		}
		
		//エスケープ処理
		reviewContent = escapeHtml(reviewContent);
		
		//画像アップロード
		Part part=request.getPart("file");
		String reviewImage=null;
		String fleName="no_image_square.jpeg";
		
		if(part.getSize()!=0) {
		String original=part.getSubmittedFileName();
		String extension=original.substring(original.lastIndexOf("."));
		int amount=0;
		File dir = new File("\\\\192.168.33.122\\upload");
		
			if (dir.isDirectory()) {
				 File[] file=dir.listFiles(File::isFile);
				 amount=file.length;
				 amount++;
			} 
		fleName="reviewImage"+amount+extension;
		part.write("\\\\192.168.33.122\\upload\\"+fleName);
		
		reviewImage="http://192.168.33.122:8080/HotWrapperGourmet/upload/"+fleName;
		}else {
		reviewImage="http://192.168.33.122:8080/HotWrapperGourmet/upload/"+fleName;
		}
		
		String grade = request.getParameter("grade");
		
		ReviewBean review = new ReviewBean();
		review.setAccountCode(accountCode);
		review.setStoreCode(storeCode);
		review.setReviewContent(reviewContent);
		review.setReviewImage(reviewImage);
		review.setReviewGrade(Integer.parseInt(grade));
		
		try {
			ReviewDAO rDao = new ReviewDAO();
			boolean isReview = rDao.insert(review);
			if (isReview == true) {
				request.setAttribute("storeCode", storeCode);
				request.setAttribute("accountCode", accountCode);
				request.setAttribute("name", name);
				request.setAttribute("reviewContent", reviewContent);
				request.setAttribute("grade", grade);
				
				List<ReviewBean> reviewList = new ArrayList<>();
				reviewList = rDao.allGet(storeCode);
				session.setAttribute("reviewList", reviewList);
				
				return "../review/insertReviewSuccess.jsp";
				
			}else {
				request.setAttribute("error", "口コミ投稿に失敗しました");
				return "../review/insertReview.jsp";
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "エラーが発生しました");
			return "../review/insertReview.jsp";
		}
		
	}
	
	//エスケープ処理メソッド
	private String escapeHtml(String input) {
		if (input == null) {
			return null;
		}else {
			return input.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
		}
	}

}

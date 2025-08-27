package store;

import java.sql.Time;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO.StoreDAO;
import tool.Action;

public class StoreCheckAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();//セッションの取得
		
		String storeName = request.getParameter("storeName");//リクエストパラメータからgetParameterメソッドでデータを取得
		String storeExplain = request.getParameter("storeExplain");//
		String address = request.getParameter("address");//
		String isdn = request.getParameter("isdn");//
		int genre = Integer.valueOf(request.getParameter("genre"));//取得したgenreをint型に変更
//		Double storeGrade = Double.valueOf("storeGrade");//取得したstoreGradeをDouble型に変更
		Time openTime = Time.valueOf(request.getParameter("openTime"));//取得したopentimeをTime型に変更
		Time closeTime = Time.valueOf(request.getParameter("closeTime"));//取得したcloseTimeをTime型に変更
		Byte holiday = Byte.valueOf(request.getParameter("holiday"));//取得したholidayをByte型に変更
		
		session.setAttribute("storeName", storeName);
		session.setAttribute("storeExplain", storeExplain);
		session.setAttribute("address", address);
		session.setAttribute("isdn", isdn);
		session.setAttribute("genre", genre);
//		session.setAttribute("storeGrade", storeGrade);
		session.setAttribute("openTime", openTime);
		session.setAttribute("closeTime", closeTime);
		session.setAttribute("holiday", holiday);
		
		StoreDAO dao=new StoreDAO();//重複チェック、どう処理するか？
		
		
				
			return "store-create_confirm.jsp";
		
}
	}

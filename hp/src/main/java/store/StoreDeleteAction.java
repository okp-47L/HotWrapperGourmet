package store;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.StoreBean;
import DAO.StoreDAO;
import tool.Action;

public class StoreDeleteAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		
		boolean IsDeleted=true;
		
		if(session!=null&&session.getAttribute("storeInfo") !=null) {

			
		StoreBean store = (StoreBean) session.getAttribute("storeInfo");

		int store_code = Integer.valueOf(store.getStoreCode());//削除する店舗の店舗コードを取得。


		StoreDAO storeDAO = new StoreDAO();//storeDAOオブジェクトを作成。
		IsDeleted = storeDAO.delete(store_code);//引数store_codeを受け取りstoreDAOオブジェクトのdeleteメソッドで該当情報を削除。			


		}
		
		StoreBean storeSearchResults = (StoreBean)session.getAttribute("searchResults");
		StoreDAO dao = new StoreDAO();
		List<StoreBean> list = dao.search(storeSearchResults.getStoreName(), storeSearchResults.getGenre(), storeSearchResults.getAddress(), storeSearchResults.getStoreGrade(), null, null, 0);
		session.setAttribute("list", list);
		

		if (IsDeleted && session.getAttribute("storeInfo") !=null ) {
			session.removeAttribute("storeInfo");

			return "store-delete_out.jsp";

		} else {
			return "store-delete_error.jsp";

		}

	}
}

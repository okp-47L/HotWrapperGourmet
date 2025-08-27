package store;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.StoreBean;
import DAO.StoreDAO;
import tool.Action;

public class StoreInsertAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();//セッションを取得
		StoreBean newStore = (StoreBean) session.getAttribute("newStore");//登録画面で入力した値「newStore」を取り出し、「newStore」に格納。

		StoreDAO dao = new StoreDAO();//「Store」が空でなければ、StoreDAOオブジェクトを生成。

		List<StoreBean> list = dao.search("", 0, "", 0.0,
				newStore.getOpenTime(), newStore.getCloseTime(), newStore.getRegularHoliday());//StoreDAOのsearchメソッドで取得したパラメーターをlistに格納する。
		//何か不具合があったら、search内をnullにして全件取得に変更。

		for (StoreBean store : list) {
			if (newStore.getIsdn().equals(store.getIsdn())) {//電話番号で検索し、重複否かを確認する。
				return "store-create_error.jsp";//すでに登録されている旨(登録時にエラーが発生しました）表示する。
			}
		}
			boolean isInserted = dao.insert(newStore);//StoreDAOのinsertメソッドを呼び出し、isInsertedにBoolean型で代入。

			{
				if (isInserted == false) {//insertメソッドで更新作業をした結果、成功すれば「true」を返すが、失敗した場合は戻ってきてその旨表示する。
					System.out.println("登録に失敗しました");
				}
			}
	
		return "store-create-out.jsp";//登録完了の旨表示する。
	}
}

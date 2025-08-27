package account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.AccountBean;
import DAO.AccountDAO;
import tool.Action;

public class ValidChangeAction extends Action { //利用者退会アクション

	//セッションからアカウントビーンを持ってきて、アカウントDAOを呼び出す。
	//	SQL文でアカウントコードをとってくる。

	//戻り値は遷移させたい画面のURL。なのでStringをつっかている。

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false); 

		AccountBean account=null;
		boolean result=true;
		//AccountBeanに入っているフィールドが使えるようになる。accountにアカウントbeanから持ってきたものを入れる
		if(session!=null&&session.getAttribute("account") !=null) {
			account = (AccountBean) session.getAttribute("account"); 
		

//		account=new AccountBean();
//		account.setAccountCode(95);
		
		

		AccountDAO dao = new AccountDAO();
		result = dao.validChange(account.getAccountCode());
		}
		
		if (result && session.getAttribute("account") !=null ) {
				session.removeAttribute("account");
			
			return "invalid-out.jsp";//成功ページへ
			

		} else{
			return "invalid.jsp";
			

			//		セッションから削除したアカウントデーターを消して削除完了画面へ
			//		遷移させる。

		}

	}

}


//return "invalid.jsp";

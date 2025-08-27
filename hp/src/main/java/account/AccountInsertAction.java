package account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.AccountBean;
import DAO.AccountDAO;
import tool.Action;

public class AccountInsertAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		String loginId="";
		String password="";
		String name="";
		int age =0;
		int role=2;
		
		AccountBean account=(AccountBean) session.getAttribute("account");
		if(account!=null&&account.getRole()==0) {
			role=1;
		}
		
		
		
		if(session.getAttribute("loginId") !=null) { 
		loginId= session.getAttribute("loginId").toString();
		password = session.getAttribute("password").toString();
		name = session.getAttribute("name").toString();
		age= (int) session.getAttribute("age");
		}
		AccountDAO dao = new AccountDAO();
		boolean result = dao.insert(loginId, password, name, age, role);

		if (result) {
			if(session!=null) {
				session.removeAttribute("loginId");
				session.removeAttribute("password");
				session.removeAttribute("name");
				session.removeAttribute("age");
				session.removeAttribute("role");
			}
			
			return "user_insert_out.jsp";
			
		} else {
			return "user_insert_error.jsp";
		}
	}
}

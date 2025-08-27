package account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.AccountBean;
import DAO.AccountDAO;
import tool.Action;

public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		AccountDAO dao = new AccountDAO();
		AccountBean account = dao.login(loginId, password);
		
		
		if (account != null) {
			if(account.getValid()==1) {
			session.setAttribute("account", account);
			
			return "login-out.jsp";
		}else{
			return "invalid.jsp";
		}
	}else {
		return "login-error.jsp";
	}
		}

}

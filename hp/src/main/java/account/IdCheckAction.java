package account;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.tomcat.jakartaee.commons.lang3.StringUtils;

import tool.Action;
import tool.Validation;

public class IdCheckAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String hidePass=StringUtils.repeat("*",password.length());
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
				
		ArrayList<String> errors=Validation.validateAccount(loginId, password, name, age);
		if(!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			request.setAttribute("eloginId", loginId);
			request.setAttribute("epassword", password);
			request.setAttribute("ename", name);
			request.setAttribute("eage", age);
			return "user_insert_in.jsp";
		}
		
		session.setAttribute("loginId", loginId);
		session.setAttribute("password", password);
		session.setAttribute("hidePass", hidePass);
		session.setAttribute("name", name);
		session.setAttribute("age", age);
		
		
		
		return "account_check.jsp";
//		AccountDAO dao = new AccountDAO();
//		boolean ac = dao.accountCheck(loginId);
//		
//		if(ac) {
//			return "account_check.jsp";
//		}else {
//			return "same_id.jsp";
//		}
}
	}

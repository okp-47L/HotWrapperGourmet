package account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import tool.Action;

public class ReviseAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);

		request.removeAttribute("errors");

		request.setAttribute("eloginId", session.getAttribute("loginId"));
		request.setAttribute("epassword", session.getAttribute("password"));
		request.setAttribute("ename", session.getAttribute("name"));
		request.setAttribute("eage", session.getAttribute("age"));

		return "user_insert_in.jsp";
	}
}
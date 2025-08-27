package account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO.AccountDAO;
import tool.Action;

public class AdminDeleteAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String loginId = request.getParameter("loginId");

		AccountDAO dao = new AccountDAO();
		boolean result = dao.adminDelete(loginId);
		
		if (result) {
			return "../superadmin/admin_delete_out.jsp";
		} else {

			return "../superadmin/admin_delete_error.jsp";
		}

	}
}

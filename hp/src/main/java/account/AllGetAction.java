package account;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.AccountBean;
import DAO.AccountDAO;
import tool.Action;

public class AllGetAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
//		int role=Integer.parseInt(request.getParameter("role"));
		
		AccountDAO dao = new AccountDAO();
		List<AccountBean> list = dao.allGet(1);

		session.setAttribute("list", list);
	
			return "../superadmin/account_get_out.jsp";
	}

}
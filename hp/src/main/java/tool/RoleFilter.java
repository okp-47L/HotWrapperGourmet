package tool;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.AccountBean;

@WebFilter("/*")
public class RoleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = ((HttpServletRequest) request).getSession(false);

		int role = 3;
		if (session != null && session.getAttribute("account") != null) {
			AccountBean account = (AccountBean) session.getAttribute("account");
			role = account.getRole();
		}
		String uri = req.getRequestURI();

		if (uri.contains("/superadmin") && role != 0) {
			res.sendRedirect("../unauthorized.jsp");
			return;
		}

		if (uri.contains("/generaladmin") && (role != 1 || role != 0)) {
			res.sendRedirect("../unauthorized.jsp");
			return;
		}

		if ((uri.contains("store-create_in.jsp") || uri.contains("store-create-out.jsp")
				|| uri.contains("store-create_error.jsp") || uri.contains("store-create_confirm.jsp")
				|| uri.contains("store-delete_error.jsp") || uri.contains("store-delete_out.jsp")
				|| uri.contains("store-delete-check.jsp") || uri.contains("store-error.jsp")
				|| uri.contains("store-update-completed.jsp") || uri.contains("deleteReview.jsp")
				|| uri.contains("deleteReviewError.jsp") || uri.contains("deleteReviewSuccess.jsp"))
				&& (role != 1 && role != 0)) {
			res.sendRedirect("../unauthorized.jsp");
			return;
		}

		chain.doFilter(request, response);

	}
}
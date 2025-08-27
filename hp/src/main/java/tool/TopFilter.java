package tool;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.StoreBean;
import DAO.StoreDAO;

@WebFilter("/*")
public class TopFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = ((HttpServletRequest) request).getSession();
		
		StoreDAO dao = new StoreDAO();
		List<StoreBean> list=null;
		try {
			list=dao.randomGet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("topview", list);
		chain.doFilter(request, response);
	}
	

}

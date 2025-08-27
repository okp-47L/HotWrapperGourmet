package tool;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//						formやlinkで指定するときは〇〇.action
//						プログラム自体は〇〇Action.java
@WebServlet(urlPatterns={"*.action"})
@MultipartConfig
public class FrontController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			//パスの取得、先頭一文字目(/)の除去
			String path=request.getServletPath().substring(1);

			//.aをAに、/を.に置き換え
			String name=path.replace(".a", "A").replace('/', '.');

			//Action action = (Action) new chapter23.SearchAction();を行っている
			Action action = (Action)Class.forName(name).getDeclaredConstructor().newInstance();

			//検索処理等をexecute（実行）する フォワード先の"〇〇.jsp"の文字列を受け取る
			String url=action.execute(request, response);

			//フォワード処理 文字列urlのページへフォワードする
			request.getRequestDispatcher(url).
				forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

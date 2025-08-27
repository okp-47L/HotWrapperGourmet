package store;

import java.io.File;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import Bean.StoreBean;
import DAO.StoreDAO;
import tool.Action;
import tool.Convert;
import tool.Validation;

public class StoreCreateConfirmAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String storeName = request.getParameter("storeName");//リクエストパラメータからgetParameterメソッドでデータを取得
		String storeExplain = request.getParameter("storeExplain");//
		String address = request.getParameter("address");//
		String isdn = request.getParameter("isdn");//
		
		
		int genre = Integer.parseInt(request.getParameter("genre"));//取得したgenreをint型に変更
		
		
		
//		Double storeGrade = Double.valueOf("storeGrade");//取得したstoreGradeをDouble型に変更。店舗登録時には入力しない。
		LocalTime openLocalTime = LocalTime.parse(request.getParameter("openTime"));//取得したopentimeをTime型に変更
		LocalTime closeLocalTime = LocalTime.parse(request.getParameter("closeTime"));//取得したcloseTimeをTime型に変更
		Time openTime = Time.valueOf(openLocalTime);
		Time closeTime=Time.valueOf(closeLocalTime);
		/*Byte holiday = Byte.valueOf(request.getParameter("holiday"));*///取得したholidayをByte型に変更
		String[] holidays = request.getParameterValues("holiday");
		int holiday = Convert.convertRegularHoliday(holidays);
		Part part=request.getPart("file");
		
		
		
		
		String storeImage=null;
		String fleName="no_image_square.jpeg";
		
		if(part.getSize()!=0) {
		String original=part.getSubmittedFileName();
		String extension=original.substring(original.lastIndexOf("."));
		int amount=0;
		File dir = new File("\\\\192.168.33.122\\upload");
		
			if (dir.isDirectory()) {
				 File[] file=dir.listFiles(File::isFile);
				 amount=file.length;
				 amount++;
			} 
		fleName="storeImage"+amount+extension;
		part.write("\\\\192.168.33.122\\upload\\"+fleName);
		
		storeImage="http://192.168.33.122:8080/HotWrapperGourmet/upload/"+fleName;
		}else {
		storeImage="http://192.168.33.122:8080/HotWrapperGourmet/upload/"+fleName;
		}
		
		
		
		StoreDAO dao = new StoreDAO();//StoreDAOオブジェクトを作成
		List<StoreBean> list = dao.search("", 0, "", 0.0,openTime, closeTime, holiday);//StoreDAOのsearchメソッドで取得したパラメーターをlistに格納する。
		for (StoreBean store : list) {
			if (isdn.equals(store.getIsdn())) {//電話番号で検索し、重複否かを確認する。
				return "store-create_error.jsp";//すでに登録されている旨表示する。
			}
		}
		
		HttpSession session = request.getSession();//セッションの取得
		StoreBean newStore = (StoreBean)session.getAttribute("newStore");//「storeinfo」に格納したデータを「newStore」に代入。

		if (newStore == null) {//newStoreに格納したデータが無ければ、新規に作成する（重複チェック）。
			newStore = new StoreBean();//newStore（入力データを格納）を作成。
		}
		
		storeName = Convert.convertSpecialCharacter(storeName);
		address = Convert.convertSpecialCharacter(address);
		storeExplain = Convert.convertSpecialCharacter(storeExplain);
		
		newStore.setStoreName(storeName);
		newStore.setStoreExplain(storeExplain);
		newStore.setAddress(address);
		newStore.setIsdn(isdn);
		newStore.setGenre(genre);
		newStore.setOpenTime(openTime);
		newStore.setCloseTime(closeTime);
		newStore.setRegularHoliday(holiday);
		newStore.setStoreImage(storeImage);
		
//	return "store-create_confirm.jsp";
		
		session.setAttribute("newStore", newStore);
		
		if(part.getSize()!=0) {
			ArrayList<String> errors=Validation.validateStore(part.getSubmittedFileName());
			if(!errors.isEmpty()) {
				request.setAttribute("errors", errors);
				
				return "store-create_in.jsp";
			}}
		
		
		/*boolean isInserted = dao.insert(newStore);//一致しなければ新規登録と判断し、DAOのinsertメソッドを実行する。
		if (isInserted == true) {
			System.out.println("登録できました");
		}*/
		return "store-create_confirm.jsp";
//		return "store-create_out.jsp";//登録完了の旨表示する。

	}

}

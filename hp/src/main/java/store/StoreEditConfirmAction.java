package store;

import java.io.File;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import Bean.StoreBean;
import tool.Action;
import tool.Convert;
import tool.Validation;

public class StoreEditConfirmAction extends Action{  //編集確認画面
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String storeName = request.getParameter("storeName");
		String isdn = request.getParameter("isdn");
		String address = request.getParameter("address");
		LocalTime localOpenTime = LocalTime.parse(request.getParameter("openTime"));
		LocalTime localCloseTime = LocalTime.parse(request.getParameter("closeTime"));
		Time openTime = Time.valueOf(localOpenTime);
		Time closeTime = Time.valueOf(localCloseTime);
		String storeExplain = request.getParameter("storeExplain");
		String[] holidays = request.getParameterValues("holiday");
		int genre = Integer.parseInt(request.getParameter("genre"));
		int holiday = Convert.convertRegularHoliday(holidays);
		String image=request.getParameter("image");
		Part part=request.getPart("file");
		
		
		
		HttpSession session = request.getSession();
		StoreBean store = (StoreBean)session.getAttribute("storeKeepInfo");
		
		if (store == null) {
			store = (StoreBean)session.getAttribute("storeInfo");
			if (store == null) {
				return "store-error.jsp";
			}
		}
		
		
		String storeImage=null;
		String fleName="no_image_square.jpeg";	
		
		if(image.equals("0") && part.getSize()!=0) {
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
		}else if(image.equals("0") && part.getSize()==0){
		storeImage="http://192.168.33.122:8080/HotWrapperGourmet/upload/"+fleName;
		}else {
		storeImage=image;
		}
		
		storeName = Convert.convertSpecialCharacter(storeName);
		address = Convert.convertSpecialCharacter(address);
		storeExplain = Convert.convertSpecialCharacter(storeExplain);
		
		store.setStoreName(storeName);
		store.setIsdn(isdn);
		store.setAddress(address);
		store.setOpenTime(openTime);
		store.setCloseTime(closeTime);
		store.setStoreExplain(storeExplain);
		store.setRegularHoliday(holiday);
		store.setGenre(genre);
		store.setStoreImage(storeImage);
		
		/*System.out.println(store.getStoreName());
		System.out.println(store.getIsdn());
		System.out.println(store.getAddress());
		System.out.println(store.getOpenTime());
		System.out.println(store.getCloseTime());
		System.out.println(store.getStoreExplain());*/
		
		session.setAttribute("storeKeepInfo", store);
		
		if(part.getSize()!=0) {
			ArrayList<String> errors=Validation.validateStore(part.getSubmittedFileName());
			if(!errors.isEmpty()) {
				request.setAttribute("errors", errors);
				
				return "store-edit.jsp";
			}}
		
		
		return "store-edit-confirmation.jsp";
	}
	
}

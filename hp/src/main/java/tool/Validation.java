package tool;

import java.util.ArrayList;

import DAO.AccountDAO;

public class Validation {
	public static ArrayList<String> validateAccount(String userId, String pass, String name, int age) throws Exception {
		ArrayList<String> errors = new ArrayList();
		userId = userId.trim();
		pass = pass.trim();
		name = name.trim();
		
		AccountDAO dao=new AccountDAO();
		boolean dup=dao.accountCheck(userId);
		
		if (userId.isEmpty()) {
			errors.add("スペースのみのIDは無効です");
		} else if (userId.length() > 16) {
			errors.add("IDは16文字以内です");
		} else if (!userId.matches("[\\w]*")) {
			errors.add("IDに使用できるのは半角英数字のみです");
		}
		if(!dup) {
			errors.add("すでに使われているIDです");
		}
		
		if (pass.isEmpty()) {
			errors.add("スペースのみのpassは無効です");
		} else if (pass.length() > 16||pass.length()<4) {
			errors.add("パスワードは4文字以上16文字以内です");
		}else if(!pass.matches("[\\w]*")){
			errors.add("パスワードに使用できるのは半角英数字のみです");
		}
		
		if (name.isEmpty()) {
			errors.add("スペースのみのニックネームは無効です");
		} else if (name.length() > 16) {
			errors.add("ニックネームは16文字以内です");
		}else if(!name.matches("[ぁ-んァ-ヶｱ-ﾝﾞﾟ一-龠ー\\w]*")) {
			errors.add("名前に記号は使えません");
		}
		if(age<=0||age>200) {
			errors.add("不正な年齢です");
		}
		
		return errors;
	}
	
	public static ArrayList<String> validateStore(String image){
		ArrayList<String> errors = new ArrayList();
		String ext=image.substring(image.lastIndexOf("."));
		ext=ext.toLowerCase();
		if(!ext.equals(".jpeg")&&!ext.equals(".jpg")&&!ext.equals(".png")&&!ext.equals(".gif")) {
			errors.add("画像に対応していないファイル形式です");
		}
		
		return errors;
		
	}
	
	

}

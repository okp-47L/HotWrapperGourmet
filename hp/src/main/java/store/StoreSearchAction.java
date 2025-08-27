package store;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Bean.StoreBean;
import DAO.StoreDAO;
import tool.Action;

public class StoreSearchAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			String storeName = request.getParameter("storeName");
			int genre = Integer.parseInt(request.getParameter("genre"));
			String address = request.getParameter("address");
			/*System.out.println(request.getParameter("storeGrade"));*/
			double storeGrade = Double.parseDouble(request.getParameter("storeGrade"));
			HttpSession session = request.getSession();
			
			int addressNumber = 0;
			switch (address) {
			    case "":
			        addressNumber = 0;
			        break;
			    case "千葉市中央区":
			        addressNumber = 1;
			        break;
			    case "千葉市花見川区":
			        addressNumber = 2;
			        break;
			    case "千葉市稲毛区":
			        addressNumber = 3;
			        break;
			    case "千葉市若葉区":
			        addressNumber = 4;
			        break;
			    case "千葉市緑区":
			        addressNumber = 5;
			        break;
			    case "千葉市美浜区":
			        addressNumber = 6;
			        break;
			    case "銚子市":
			        addressNumber = 7;
			        break;
			    case "市川市":
			        addressNumber = 8;
			        break;
			    case "船橋市":
			        addressNumber = 9;
			        break;
			    case "館山市":
			        addressNumber = 10;
			        break;
			    case "木更津市":
			        addressNumber = 11;
			        break;
			    case "松戸市":
			        addressNumber = 12;
			        break;
			    case "野田市":
			        addressNumber = 13;
			        break;
			    case "茂原市":
			        addressNumber = 14;
			        break;
			    case "成田市":
			        addressNumber = 15;
			        break;
			    case "佐倉市":
			        addressNumber = 16;
			        break;
			    case "東金市":
			        addressNumber = 17;
			        break;
			    case "旭市":
			        addressNumber = 18;
			        break;
			    case "習志野市":
			        addressNumber = 19;
			        break;
			    case "柏市":
			        addressNumber = 20;
			        break;
			    case "勝浦市":
			        addressNumber = 21;
			        break;
			    case "市原市":
			        addressNumber = 22;
			        break;
			    case "流山市":
			        addressNumber = 23;
			        break;
			    case "八千代市":
			        addressNumber = 24;
			        break;
			    case "我孫子市":
			        addressNumber = 25;
			        break;
			    case "鴨川市":
			        addressNumber = 26;
			        break;
			    case "鎌ヶ谷市":
			        addressNumber = 27;
			        break;
			    case "君津市":
			        addressNumber = 28;
			        break;
			    case "富津市":
			        addressNumber = 29;
			        break;
			    case "浦安市":
			        addressNumber = 30;
			        break;
			    case "四街道市":
			        addressNumber = 31;
			        break;
			    case "袖ヶ浦市":
			        addressNumber = 32;
			        break;
			    case "八街市":
			        addressNumber = 33;
			        break;
			    case "印西市":
			        addressNumber = 34;
			        break;
			    case "白井市":
			        addressNumber = 35;
			        break;
			    case "富里市":
			        addressNumber = 36;
			        break;
			    case "南房総市":
			        addressNumber = 37;
			        break;
			    case "匝瑳市":
			        addressNumber = 38;
			        break;
			    case "香取市":
			        addressNumber = 39;
			        break;
			    case "山武市":
			        addressNumber = 40;
			        break;
			    case "いすみ市":
			        addressNumber = 41;
			        break;
			    case "大網白里市":
			        addressNumber = 42;
			        break;
			    case "酒々井町":
			        addressNumber = 43;
			        break;
			    case "栄町":
			        addressNumber = 44;
			        break;
			    case "神崎町":
			        addressNumber = 45;
			        break;
			    case "多古町":
			        addressNumber = 46;
			        break;
			    case "東庄町":
			        addressNumber = 47;
			        break;
			    case "九十九里町":
			        addressNumber = 48;
			        break;
			    case "芝山町":
			        addressNumber = 49;
			        break;
			    case "横芝光町":
			        addressNumber = 50;
			        break;
			    case "一宮町":
			        addressNumber = 51;
			        break;
			    case "睦沢町":
			        addressNumber = 52;
			        break;
			    case "長生村":
			        addressNumber = 53;
			        break;
			    case "白子町":
			        addressNumber = 54;
			        break;
			    case "長柄町":
			        addressNumber = 55;
			        break;
			    case "長南町":
			        addressNumber = 56;
			        break;
			    case "大多喜町":
			        addressNumber = 57;
			        break;
			    case "御宿町":
			        addressNumber = 58;
			        break;
			    case "鋸南町":
			        addressNumber = 59;
			        break;
			}
			
			StoreBean searchResults = new StoreBean();
			searchResults.setStoreName(storeName);
			searchResults.setGenre(genre);
			searchResults.setAddress(address);
			searchResults.setStoreGrade(storeGrade);
			
			StoreDAO dao = new StoreDAO();
			List<StoreBean> list = dao.search(storeName, genre, address, storeGrade, null, null, 0);
			if (list != null) {
				session.setAttribute("list", list);
				session.setAttribute("searchResults", searchResults);
				session.setAttribute("addressNumber", addressNumber);
			}
		} catch (Exception e) {
			return "store-error.jsp";
		}
		
		
		return "store-search-result.jsp";
	}
}

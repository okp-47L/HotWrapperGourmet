package tool;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Convert {
	public static String convertRegularHoliday(int regularHoliday) {
		if (regularHoliday == 0) {
			return "なし";
		}
		
		String s = Integer.toString(regularHoliday);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i == 0) {
				switch(s.charAt(i)) {
				case '1':
					stringBuilder.append("日");
					break;
				case '2':
					stringBuilder.append("月");
					break;
				case '3':
					stringBuilder.append("火");
					break;
				case '4':
					stringBuilder.append("水");
					break;
				case '5':
					stringBuilder.append("木");
					break;
				case '6':
					stringBuilder.append("金");
					break;
				case '7':
					stringBuilder.append("土");
					break;
				}
			} else {
				switch(s.charAt(i)) {
				case '1':
					stringBuilder.append("、日");
					break;
				case '2':
					stringBuilder.append("、月");
					break;
				case '3':
					stringBuilder.append("、火");
					break;
				case '4':
					stringBuilder.append("、水");
					break;
				case '5':
					stringBuilder.append("、木");
					break;
				case '6':
					stringBuilder.append("、金");
					break;
				case '7':
					stringBuilder.append("、土");
					break;
				}
			}
			
		}
		
		/*System.out.println(stringBuilder.toString());*/
		
		return stringBuilder.toString();
	}
	
	public static int convertRegularHoliday(String[] holidays) {
		ArrayList<Integer> holidayList = new ArrayList<>();
		
		StringBuilder sHoliday = new StringBuilder();
		int holiday = 0;
		
		if (holidays != null) {
			for (String cHoliday : holidays) {
				holidayList.add(Integer.parseInt(cHoliday));
			}
			
			for (int iHoliday : holidayList) {
				switch(iHoliday) {
					case 1:
						sHoliday.append(1);
						break;
						
					case 2:
						sHoliday.append(2);
						break;
						
					case 3:
						sHoliday.append(3);
						break;
						
					case 4:
						sHoliday.append(4);
						break;
						
					case 5:
						sHoliday.append(5);
						break;
						
					case 6:
						sHoliday.append(6);
						break;
						
					case 7:
						sHoliday.append(7);
						break;
				}
			}
			holiday = Integer.parseInt(sHoliday.toString());
		}
		return holiday;
	}
	
	public static String convertGenre(int genre) {
		String sGenre = "なし";
		switch(genre) {
			case 1:
				sGenre = "和食";
				break;
			case 2:
				sGenre = "洋食";
				break;
			case 3:
				sGenre = "丼";
				break;
			case 4:
				sGenre = "麺類";
				break;
			case 5:
				sGenre = "カレー";
				break;
			case 6:
				sGenre = "ベーカリー";
				break;
			case 7:
				sGenre = "ファストフード";
				break;
			case 8:
				sGenre = "焼肉";
				break;
			case 9:
				sGenre = "海鮮";
				break;
			case 10:
				sGenre = "その他";
				break;
		}
		
		return sGenre;
	}
	
	public static String convertStoreGrade(double storeGrade) {
		if (storeGrade == 0.0) {
			return "未評価";
		}
		
		return Double.valueOf(storeGrade).toString();
	}
	
	public static String convertTime(Time time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.parse(time.toString());
		String formatted = localTime.format(formatter);
		
		return formatted;
	}
	
	public static String convertSpecialCharacter(String text){
		if (text == null) {
			return null;
		} else {
			String replaceText = text.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&#39;");
			return replaceText;
		}
		
	}
}

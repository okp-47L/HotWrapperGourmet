package tool;

public class DrawStar {
	public static int drawStoreGrade(double storeGrade) {
		int starNumber = 0;
		
		if (storeGrade >= 0.0 && storeGrade < 1.0) {
			starNumber = 0;
		}else if (storeGrade >= 1.0 && storeGrade < 2.0) {
			starNumber = 1;
		}else if (storeGrade >= 2.0 && storeGrade < 3.0) {
			starNumber = 2;
		}else if (storeGrade >= 3.0 && storeGrade < 4.0) {
			starNumber = 3;
		}else if (storeGrade >= 4.0 && storeGrade < 5.0) {
			starNumber = 4;
		}else if (storeGrade == 5.0) {
			starNumber = 5;
		}
		return starNumber;
	}
}

package tool;

public class ReviewStar {
	public static int reviewStarGrade(double reviewGrade) {
		int starNum = 0;
		if (reviewGrade >= 0.0 && reviewGrade < 1.0) {
			starNum = 0;
		}else if (reviewGrade >= 1.0 && reviewGrade < 2.0) {
			starNum = 1;
		}else if (reviewGrade >= 2.0 && reviewGrade < 3.0) {
			starNum = 2;
		}else if (reviewGrade >= 3.0 && reviewGrade < 4.0) {
			starNum = 3;
		}else if (reviewGrade >= 4.0 && reviewGrade < 5.0) {
			starNum = 4;
		}else if (reviewGrade == 5.0) {
			starNum = 5;
		}
		return starNum;
		
	}

}

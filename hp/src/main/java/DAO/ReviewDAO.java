package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.ReviewBean;

public class ReviewDAO extends DAO {

	//レビュー登録
	public boolean insert(ReviewBean content) throws Exception {
		boolean result = false;
		int check = 0;
		
		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("INSERT INTO review(store_code,account_code,review_content,review_image,review_grade) VALUES(?,?,?,?,?)");) {
			st.setInt(1, content.getStoreCode());
			st.setInt(2, content.getAccountCode());
			st.setString(3, content.getReviewContent());
			st.setString(4, content.getReviewImage());
			st.setInt(5, content.getReviewGrade());
			check = st.executeUpdate();
		
			if(check > 0) {
				result = true;
				boolean gradeChange = gradeUpdate(content.getStoreCode());
				if (gradeChange == true) {
					result = true;
				}
			}
			}catch (Exception e) {
				e.printStackTrace();
		}
		return result;
	}

	//レビュー情報取得
	public ReviewBean getReviewInfo(int reviewCode) throws Exception {
		ReviewBean rbean = null;
		
		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM review INNER JOIN account ON review.account_code = account.account_code WHERE review.review_code = ?");
				) {
			st.setInt(1, reviewCode);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
			rbean = new ReviewBean();
			rbean.setReviewCode(rs.getInt("review_code"));
			rbean.setAccountCode(rs.getInt("account_code"));
			rbean.setStoreCode(rs.getInt("store_code"));
			rbean.setReviewContent(rs.getString("review_content"));
			rbean.setDate(rs.getDate("date"));
			rbean.setReviewImage(rs.getString("review_image"));
			rbean.setReviewGrade(rs.getInt("review_grade"));
			rbean.setName(rs.getString("name"));

			try (PreparedStatement st2 = con.prepareStatement("SELECT * FROM review INNER JOIN store ON review.store_code = store.store_code WHERE review.review_code = ?");
					) {
				st2.setInt(1, reviewCode);
				ResultSet rs2 = st2.executeQuery();
				if (rs2.next()) {
				rbean.setStoreName(rs2.getString("store_name"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rbean;
	}
	
	//レビュー削除
	public boolean delete(int reviewCode) throws Exception {
		boolean result = false;
		int check = 0;
		boolean gradeChange = false;
		
		try (Connection con = getConnection();
		PreparedStatement st1 = con.prepareStatement("SELECT store_code FROM review WHERE review_code = ?");
		PreparedStatement st2 = con.prepareStatement("DELETE FROM review WHERE review_code = ?")) {
			con.setAutoCommit(false);
			
			st1.setInt(1, reviewCode);
			ResultSet rs = st1.executeQuery();
			st2.setInt(1, reviewCode);
			check = st2.executeUpdate();
		
			if(check > 0) {
				con.commit();
				while(rs.next()) {
					gradeChange = gradeUpdate(rs.getInt("store_code"));
				}
				if(gradeChange == true) {
					result = true;
				}
				
			}else {
				con.rollback();
			}
			con.setAutoCommit(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//各店舗の全レビュー表示
	public List<ReviewBean> allGet(int storeCode) throws Exception {
		List<ReviewBean> reviewList = new ArrayList<>();
		ReviewBean rbean = null;
		
		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM review WHERE store_code = ?");
				) {
			st.setInt(1, storeCode);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				rbean = new ReviewBean();
				rbean.setReviewCode(rs.getInt("review_code"));
				rbean.setAccountCode(rs.getInt("account_code"));
				rbean.setStoreCode(rs.getInt("store_code"));
				rbean.setReviewContent(rs.getString("review_content"));
				rbean.setDate(rs.getDate("date"));
				rbean.setReviewImage(rs.getString("review_image"));
				rbean.setReviewGrade(rs.getInt("review_grade"));
				try (PreparedStatement st2 = con.prepareStatement("SELECT * FROM account WHERE account_code = ?")
						) {
					st2.setInt(1, rs.getInt("account_code"));
					ResultSet rs2 = st2.executeQuery();
					while (rs2.next()) {
						rbean.setName(rs2.getString("name"));
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				reviewList.add(rbean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
	}

	//各店舗のgrade更新
	public boolean gradeUpdate(int storeCode) throws Exception {
		boolean result = false;
		
		try (Connection con = getConnection();
		PreparedStatement st1 = con.prepareStatement("SELECT * FROM review WHERE store_code = ?");
		PreparedStatement st2 = con.prepareStatement("UPDATE store SET store_grade = ? WHERE store_code = ?")) {
			st1.setInt(1, storeCode);
			ResultSet rs = st1.executeQuery();
			
			List<Double> gradeList = new ArrayList<>();
			double gradeSum = 0;
			double gradeAvg;
			
			while (rs.next()) {
				gradeList.add(rs.getDouble("review_grade"));
			}
			if (gradeList.size() > 0) {
				for (double i :gradeList)
					gradeSum += i;
				gradeAvg = Double.parseDouble(String.format("%.1f", gradeSum / gradeList.size()));
			}else {
				gradeAvg = 0;
			}
				
			st2.setDouble(1, gradeAvg);
			st2.setInt(2, storeCode);
			st2.execute();
			result = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

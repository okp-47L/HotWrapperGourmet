package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import Bean.StoreBean;

public class StoreDAO extends DAO {

	public boolean insert(StoreBean info) {
		boolean isInsert = false;//isInsertの初期化
		try (Connection con = getConnection();//try文
				//SQL文を作成する
				PreparedStatement st = con.prepareStatement(
						"insert into store(store_name,store_explain,open_time,close_time,address,store_image,store_grade,regular_holiday,isdn,genre) values(?,?,?,?,?,?,?,?,?,?)");) {

			st.setString(1, info.getStoreName());
			st.setString(2, info.getStoreExplain());
			st.setTime(3, info.getOpenTime());
			st.setTime(4, info.getCloseTime());
			st.setString(5, info.getAddress());
			st.setString(6, info.getStoreImage());
			st.setDouble(7, info.getStoreGrade());
			st.setInt(8, info.getRegularHoliday());
			st.setString(9, info.getIsdn());
			st.setInt(10, info.getGenre());
//			st.setString(10, info.getGenre());

			int line = st.executeUpdate();//executeUpdateで実行した行数を変数lineに代入する。
			//変数lineが1以上だったら、アクションが成功したと判断。
			if (line > 0) {

				isInsert = true;//trueをisInsertへ代入
			}

		} catch (Exception e) {
			e.printStackTrace();//Stacktraceを出力するメソッド
		}

		return isInsert;//isInsertを戻り値として返す
	}

	public boolean delete(int storeCode) {
		boolean IsDeleted = false;//isDeletedの初期化
		int check=0;
		try (Connection con = getConnection();

				PreparedStatement st = con.prepareStatement("delete from store where store_code=?;");) {
			con.setAutoCommit(false);//自動コミットモードをoffにする。
			st.setInt(1, storeCode);

			check = st.executeUpdate();//executeUpdateで実行した行数を変数checkに代入する。
			if (check > 0) {//変数checkが１以上なら、アクションが成功したと判断。
				con.commit();
				IsDeleted = true;//trueをIsDeletedに代入
			}else {
				con.rollback();//トランザクションで行われた変更を取り消す。
				IsDeleted = false;//falseをIsDeletedに代入

			}
			con.setAutoCommit(true);//自動コミットモードをonにする。
			
		} catch (Exception e) {
			e.printStackTrace();//Stacktraceを出力するメソッド
		}

		return IsDeleted;//isDeletedを戻り値として返す。
	}

	public StoreBean getStoreInfo(int storeCode) {
		StoreBean store = new StoreBean();
		
		try(Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("select * from store where store_code = ?");){
			st.setInt(1, storeCode);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				store.setStoreCode(rs.getInt("store_code"));
				store.setStoreName(rs.getString("store_name"));
				store.setStoreExplain(rs.getString("store_explain"));
				store.setOpenTime(rs.getTime("open_time"));
				store.setCloseTime(rs.getTime("close_time"));
				store.setAddress(rs.getString("address"));
				store.setStoreImage(rs.getString("store_image"));
				store.setStoreGrade(rs.getDouble("store_grade"));
				store.setRegularHoliday(rs.getInt("regular_holiday"));
				store.setIsdn(rs.getString("isdn"));
				store.setGenre(rs.getInt("genre"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;
	}

	public boolean update(StoreBean info) {
		boolean isUpdated = false;
		
		try(Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("update store set store_name = ?, store_explain = ?, open_time = ?, close_time = ?, address = ?, store_image = ?, store_grade = ?, regular_holiday = ?, isdn = ?, genre = ? where store_code = ?");){
			st.setString(1, info.getStoreName());
			st.setString(2, info.getStoreExplain());
			st.setTime(3, info.getOpenTime());
			st.setTime(4, info.getCloseTime());
			st.setString(5, info.getAddress());
			st.setString(6, info.getStoreImage());
			st.setDouble(7, info.getStoreGrade());
			st.setInt(8, info.getRegularHoliday());
			st.setString(9, info.getIsdn());
			st.setInt(10, info.getGenre());
			st.setInt(11, info.getStoreCode());
			
			int line = st.executeUpdate();
			
			if (line > 0) {
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isUpdated;
	}



	public List<StoreBean> search(String storeName, int genre, String address, double storeGrade, Time openTime, Time closeTime, int regularHoliday) {
		List<StoreBean> list = new ArrayList<>();
		int parameterCount = 1;
		int genreParameterCount = 0;
		int addressParameterCount = 0;
		int storeGradeParameterCount = 0;
		StringBuilder stringBuilder = new StringBuilder("select * from store where (store_name like ?");
		
		if (genre != 0) {
			stringBuilder.append("and genre = ?)");
			parameterCount++;
			genreParameterCount = parameterCount;
		} else {
			stringBuilder.append(")");
		}
		
		if (!address.equals("")) {
			stringBuilder.append("and (address like ?");
			parameterCount++;
			addressParameterCount = parameterCount;
		}
		
		if (storeGrade != 0.0) {
			if (!address.equals("")) {
				stringBuilder.append("and store_grade >= ?)");
			} else {
				stringBuilder.append("and store_grade >= ?");
			}
			
			parameterCount++;
			storeGradeParameterCount = parameterCount;
		} else if (!address.equals("")) {
			stringBuilder.append(")");
		}
		
		String sql = stringBuilder.toString();
		
		/*System.out.println(sql);*/
		
		try(Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);){
			st.setString(1, "%" + storeName + "%");
			
			if (genre != 0) {
				st.setInt(genreParameterCount, genre);
			}
			
			if (!address.equals("")) {
				st.setString(addressParameterCount, "%" + address + "%");
			}
			
			if (storeGrade != 0.0) {
				st.setDouble(storeGradeParameterCount, storeGrade);
			}
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				StoreBean store = new StoreBean();
				store.setStoreCode(rs.getInt("store_code"));
				store.setStoreName(rs.getString("store_name"));
				store.setStoreExplain(rs.getString("store_explain"));
				store.setOpenTime(rs.getTime("open_time"));
				store.setCloseTime(rs.getTime("close_time"));
				store.setAddress(rs.getString("address"));
				store.setStoreImage(rs.getString("store_image"));
				store.setStoreGrade(rs.getDouble("store_grade"));
				store.setRegularHoliday(rs.getInt("regular_holiday"));
				store.setIsdn(rs.getString("isdn"));
				store.setGenre(rs.getInt("genre"));


				list.add(store);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		return list;

	}

	public List<StoreBean> randomGet() throws Exception {
		List<StoreBean> list = new ArrayList<>();
		StoreBean store = null;
		try (Connection con = getConnection();

				PreparedStatement st = con.prepareStatement("select *from store where store_image not like '%no_image_square.jpeg' order by rand() limit 5");) {
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				store = new StoreBean();
				store.setStoreCode(rs.getInt("store_code"));
				store.setStoreName(rs.getString("store_name"));
				store.setStoreExplain(rs.getString("store_explain"));
				store.setOpenTime(rs.getTime("open_time"));
				store.setCloseTime(rs.getTime("close_time"));
				store.setAddress(rs.getString("address"));
				store.setStoreImage(rs.getString("store_image"));
				store.setStoreGrade(rs.getDouble("store_grade"));
				store.setRegularHoliday(rs.getInt("regular_holiday"));
				store.setIsdn(rs.getString("isdn"));
				store.setGenre(rs.getInt("genre"));

				list.add(store);
			}
			return list;

		}

	}

}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.AccountBean;

public class AccountDAO extends DAO {

	public AccountBean login(String loginId, String password) throws Exception {

		AccountBean account = null;

		try (Connection con = getConnection();

				PreparedStatement st = con.prepareStatement("select*from account where BINARY login_id= ? and BINARY password=?");) {
			st.setString(1, loginId);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				account = new AccountBean();
				account.setAccountCode(rs.getInt("account_code"));
				account.setLoginId(rs.getString("login_id")); 
				account.setPassword(rs.getString("password"));
				account.setName(rs.getString("name"));
				account.setDate(rs.getDate("date"));
				account.setRole(rs.getByte("role"));
				account.setAge(rs.getShort("age"));
				account.setValid(rs.getByte("valid"));

			}

		}
		return account;
	}

	public boolean insert(String loginId, String password, String name, int age, int role) throws Exception {
		final String SQL = "INSERT INTO ACCOUNT(login_id,password,name,role,age) VALUES(?,?,?,?,?)";
		boolean result = true;
			
		try (Connection con = getConnection();

					PreparedStatement st = con
							.prepareStatement(SQL);) {
				st.setString(1, loginId);
				st.setString(2, password);
				st.setString(3, name);
				st.setInt(4, role);
				st.setInt(5, age);

				if (st.executeUpdate() > 0) {
					result = true; //成功
				}
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}

	public boolean adminDelete(String loginId) throws Exception {
		boolean result=true;
		try (Connection con = getConnection();

				PreparedStatement st = con.prepareStatement("delete from account where login_id =?");) {
			st.setString(1, loginId);
			int line = st.executeUpdate();
			
			if(line>0) {
				result=true;
			}else {
				result=false;
			}
			
			return result;
		}
	}

	public List<AccountBean> allGet(int role) throws Exception {
		List<AccountBean> list = new ArrayList<>();
		AccountBean account = null;
		try (Connection con = getConnection();

				PreparedStatement st = con.prepareStatement("select*from account where role =? ");) {
			st.setInt(1, role);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				account = new AccountBean();
				account.setAccountCode(rs.getInt("account_code"));
				account.setLoginId(rs.getString("login_id")); 
				account.setPassword(rs.getString("password"));
				account.setName(rs.getString("name"));
				account.setDate(rs.getDate("date"));
				account.setRole(rs.getByte("role"));
				account.setAge(rs.getShort("age"));
				account.setValid(rs.getByte("valid"));
				list.add(account);
			}
			return list;
		}
	}

	public boolean accountCheck(String loginId) throws Exception { //登録時のID重複チェック
		boolean check = true;

		try (Connection con = getConnection();

				PreparedStatement st = con.prepareStatement("select * from account where login_id=?");) {
			st.setString(1, loginId);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				check = false; //ヒットあり
			} else {
				check = true; //ヒットなし
			}
			return check;
		}

	}

	public boolean validChange(int accountCode) throws Exception {
		
		boolean result = true;
		

			try (Connection con = getConnection();
					PreparedStatement st = con.prepareStatement("UPDATE account SET valid=0 WHERE account_code=?;");) {
				st.setInt(1, accountCode);
								
				
				if (st.executeUpdate() > 0) {
					result = true; //成功
				}else {
					result = false; //失敗

				}
			return result;

			}catch (SQLException e) {
				result = false;
			}
			return result;

			//1roleが2（利用者）かを判断する機能を追加する

					
					//validChangeActionからアカウントコードをもらってきて１から０に変更したい。（アカウントの無効化）
					
//					アカウントコードを検索してvalitをアップデートする記述をする。

	}
}
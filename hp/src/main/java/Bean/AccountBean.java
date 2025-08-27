package Bean;

import java.io.Serializable;
import java.sql.Date;

public class AccountBean implements Serializable {
	
	private int accountCode;

	private String loginId;

	private String password;

	private String name;

	private Date date;

	private int age;

	private int role;
	
	private int valid;

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public int getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(int accountCode) {
		this.accountCode = accountCode;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public int getRole() {
		return role;
	}

	public void setRole(byte role) {
		this.role = role;
	}
	


}

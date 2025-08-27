package DAO;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	static DataSource ds;


	public Connection getConnection() throws Exception{
		if(ds == null) {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:/comp/env/jdbc/initiald");
		}
		//コネクション確立までの流れを最適化している
		return ds.getConnection();
	}
}
package org.ice.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class push {
	public static void main(String[] args) {

	}

	public static int add(String ip, String size, long l, String data) {
		Statement stmt;
		int rs = 0;
		try {
			stmt = DBCon.getInstance().getConnection().createStatement();
			String sql = "insert into ip_data(ip,size,add_time) values ('" + ip
					+ "','" + size + "'," + l + ")";
			rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

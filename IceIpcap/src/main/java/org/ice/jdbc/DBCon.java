package org.ice.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DBCon {
	static BoneCP connectionPool = null;
	static Connection connection = null;

	public static void main(String[] args) {

	}

	// 构造私有实例
	private static DBCon con = null;

	public static DBCon getInstance() {
		// 延迟加载
		if (con == null) {
			// 加锁 防止线程并发
			synchronized (DBCon.class) {
				// 必须有的判断
				if (con == null) {
					con = new DBCon();
				}
			}
		}
		return con;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BoneCPConfig config = new BoneCPConfig();
		config.setJdbcUrl("jdbc:mysql://127.0.0.1/scan");
		config.setUsername("root");
		config.setPassword("");
		config.setMinConnectionsPerPartition(5);
		config.setMaxConnectionsPerPartition(10);
		config.setPartitionCount(1);
		try {
			connectionPool = new BoneCP(config);
			connection = connectionPool.getConnection(); // fetch a connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 获取连接
	public Connection getConnection() {
		return this.connection;
	}
}

package Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OracleConnection implements ConnectionInterface {
	private String userName = "tosad_2015_2b_team5";
	private String password = "tosad_2015_2b_team5";

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@ondora02.hu.nl:8521:cursus02",
					"tosad_2015_2b_team5_target", "tosad_2015_2b_team5_target");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	public void sendQuery(Connection con, String s) {

		try {
			Statement stmt = con.createStatement();
			stmt.execute(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}

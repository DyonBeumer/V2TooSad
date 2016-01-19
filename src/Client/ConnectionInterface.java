package Client;

import java.sql.Connection;

public interface ConnectionInterface {
	public Connection getConnection();
	public void sendQuery(Connection c, String s);
	
	
}

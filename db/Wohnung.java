import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Wohnung {
	public Wohnung() throws ClassNotFoundException, SQLException{
		initieren();
	}
	private void initieren() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");//stelle verbindung zur DB her
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS wohnung(wohnungs_id INTEGER PRIMARY KEY, adress_id INTEGER NOT NULL, miete DOUBLE,zimmer DOUBLE NOT NULL,baeder DOUBLE NOT NULL,ebk BOOLEAN)");
		connection.close();
	}
}

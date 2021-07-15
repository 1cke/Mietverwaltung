package Backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class datentyp_test {
	public static String[] get_values(String anweisung) throws ClassNotFoundException, SQLException{
		String zwischenerg ="";
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:sqlite:kundenDB.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		//System.out.println(anweisung);//Kontrollausgabe
		ResultSet rs = statement.executeQuery(anweisung);
		ArrayList<Person> daten = new ArrayList<Person>();
		while(rs.next()) {
			Person p = new Person();
			p.setId(rs.getInt(1));
			p.setVorname(rs.getString(2));
			p.setNachname(rs.getString(3));
			p.setGeburtsdatum(rs.getString(4));
			p.setTelefon(rs.getString(5));
			p.setEmail(rs.getString(6));
			daten.add(p);
			
		}
		System.out.println(daten);
		connection.close();
		String[] values = zwischenerg.split(",");
		return values;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		String[] a = get_values("SELECT * FROM kunden");
		
	}
	

}

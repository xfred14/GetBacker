package getter.run.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGetter {
	String myMachineName;
	int runId;
	Connection con;
	
	@BeforeTest
	public void setMachineName() {
		this.myMachineName = "machine1";
	}
	
	@Test
	public void getTest() {
		try {  
			Class.forName("org.sqlite.JDBC");  
			con = DriverManager.getConnection(
			"jdbc:sqlite:C:\\Users\\fmayao\\eclipse-workspace\\TestNGDemo\\data\\testDB.db");  
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from trigger_run where machine_name='"+myMachineName+"' order by id asc;"); 
			
			while (rs.next()) {
				runId = rs.getInt(5);
				System.out.println("runId: "+runId);
			}
			
			
			
			
			con.close();
		} catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
		}
		
	}
}

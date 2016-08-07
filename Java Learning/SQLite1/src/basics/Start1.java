package basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Start1 {
	
	private static Connection connection;
	private static boolean hasData=false;
	
	
	
	public ResultSet displayItems() throws ClassNotFoundException, SQLException{
		if(connection==null){
			getConnection();
			
		}
		
		Statement statement1= connection.createStatement();
		ResultSet res= statement1.executeQuery("Select  item,price from allitems");
		
		return res;
		
		
		
	}



	private void getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		connection =DriverManager.getConnection("jdbc:sqlite:SQLite1DB.db");
		
		initialize();
		
	}



	private void initialize() throws SQLException {
		// TODO Auto-generated method stub
		
		if(!hasData){
			
			hasData=true;
			
			Statement statement1= connection.createStatement();
			ResultSet res1= statement1.executeQuery("SELECT name from sqlite_master WHERE type='table' AND name='allitems'");
			
			if(!res1.next()){
				
				System.out.println("Table Creating");
				
				//create table
				Statement statement2= connection.createStatement();
				statement2.execute("CREATE TABLE allitems (id int,"
						+ "item varchar(75), price int,primary key (id) );");
				
				System.out.println("Table Created");
				
				PreparedStatement preparedStat= connection.prepareStatement("INSERT INTO allitems values(?,?,?)");

				preparedStat.setInt(1, 1);
				preparedStat.setString(2, "IDLI");
				preparedStat.setInt(3, 22);
				preparedStat.execute();
			
				System.out.println("Data1");
				
				PreparedStatement preparedStat2= connection.prepareStatement("INSERT INTO allitems values(?,?,?)");

				preparedStat2.setInt(1, 2);
				preparedStat2.setString(2, "Vada");
				preparedStat2.setInt(3, 20);
				preparedStat2.execute();
				
				
				
			}
			
			
		}
		
		
	}
	
	
	public void addItem(String item , int value) throws ClassNotFoundException, SQLException{
		
		
		if(connection==null){
			
			getConnection();
		}
		
		PreparedStatement preparedStat= connection.prepareStatement("INSERT INTO allitems values(?,?,?)");
		

		preparedStat.setString(2, item);
		preparedStat.setInt(3, value);
		preparedStat.execute();
		
	}

}






















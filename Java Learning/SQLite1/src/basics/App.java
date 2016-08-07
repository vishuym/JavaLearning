package basics;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Start1 testStart= new Start1();
		
		ResultSet resultSet;
		
		try {
			resultSet = testStart.displayItems();
			while(resultSet.next()){
				
				System.out.println(resultSet.getString("item") + "  " + resultSet.getFloat("price"));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

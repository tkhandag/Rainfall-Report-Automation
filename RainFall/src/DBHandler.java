import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
public class DBHandler {

	//Write the required business logic as expected in the question description
	public Connection establishConnection() throws InvalidCityPincodeException{
		Properties props=new Properties();
		try {
			
			
			FileInputStream fis=new FileInputStream("db.properties");
			props.load(fis);
			String url=props.getProperty("db.classname");
			String driver=props.getProperty("db.url");
			String userName=props.getProperty("db.username");
			String pwd=props.getProperty("db.password");
			
			Class.forName(url);
				
			return DriverManager.getConnection(driver,userName,pwd);
			} 
			
		catch (FileNotFoundException e) {
		
		
			throw new InvalidCityPincodeException(e.getMessage());
		}
		
		catch (IOException e) {
			throw new InvalidCityPincodeException(e.getMessage());
			} 
		
		catch (ClassNotFoundException e) {
				throw new InvalidCityPincodeException(e.getMessage());
					} 
		catch (SQLException e) {
			throw new InvalidCityPincodeException(e.getMessage());
						
		}

		//fill the code

	}
}

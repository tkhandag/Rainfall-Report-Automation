import java.util.*;
import java.io.*;

import java.sql.*;


public class RainfallReport {
	String s=null;
    String str[];
    RainfallReport r=null;
    List <AnnualRainfall> l=null;
    public List<AnnualRainfall> generateRainfallReport(String filePath)
    {      
    try
    {
           BufferedReader br =new BufferedReader(new FileReader(filePath));
           while((s=br.readLine())!=null)
           {
                  AnnualRainfall a=new AnnualRainfall();
           double avgRain[]=null;
                  str=s.split(",");
                  if(r.validate(str[0]))
                	  a.setCityPincode(Integer.parseInt(str[0]));
                  a.setCityName(str[1]);
                  int i=2;
                  int j=0;
               while(i<str.length)
               {
                 avgRain[j] = Double.parseDouble(str[i]);
                 i++;
                 j++;
               }
                  a.calculateAverageAnnualRainfall(avgRain);
               l.add(a);
           }
           return l;
    
    }
    catch(Exception e)
    {
           System.out.println(e.getMessage());
    }
    return l;
}

	
	public List<AnnualRainfall>  findMaximumRainfallCities() {
	List<AnnualRainfall>ar=new ArrayList<AnnualRainfall>();
		
		
	AnnualRainfall annualRainfall = new AnnualRainfall();
			try{
				
				
				DBHandler db=new DBHandler();
				Connection	con = db.establishConnection();
				PreparedStatement ps;
				ps=con.prepareStatement("Select * from annualrainfall where average_annual_rainfall=(select max(average_annual_rainfall) from annualrainfall)");
				
			   ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				
				
				annualRainfall.setCityName(rs.getString(2));
				annualRainfall.setCityPincode(rs.getInt("city_pincode"));
				annualRainfall.setAverageAnnualRainfall(rs.getDouble("average_annual_rainfall"));	
				ar.add(annualRainfall);
			}
			
		}
		
		catch (SQLException | InvalidCityPincodeException e) {
			// TODO Auto-generated catch block
			 System.out.println(e.getMessage());
		}
		
		return ar;
		
	}
	
	
	public boolean validate(String cityPincode) throws InvalidCityPincodeException {
	if(cityPincode.matches("^[0-9]{5}$")){
		return true;
	}
			return false;
	}

}

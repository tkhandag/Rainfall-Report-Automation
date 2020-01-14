import java.util.*;

public class Main
{
   public static void main(String[] args) { 
   
	   //fill the code
	   
	   RainfallReport rr=new RainfallReport();
	   
	   List<AnnualRainfall>a=rr.findMaximumRainfallCities();
	 
	   for(AnnualRainfall l: a ){
		   System.out.println(l.getCityPincode()+" "+ l.getCityName()+" "+ l.getAverageAnnualRainfall());
	   }
	   
	   
	   
	   
   }
}
          
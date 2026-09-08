package Assign_Framework.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class flightReservation extends testBase{
	String getCurrentURL;
	boolean defaulttriptype;
	boolean sameDate;
	boolean samePort;
		
	String selecteddepartureDate;
	String selecteddepatrureMonth;
	String selectedarrivalDate;
	String selectedarrivalMonth;
	String selecteddepartureport;
	String selectedarrivalPort;
	
	@Test(dataProvider ="dataprovider")
	
	public void flightReservationTest(String triptype,String passengers,String departingFrom,String	departureDate,String departureMonth,String arrivalTo,String	returnDate,String returnMonth,String serviceClass,String airlinePreference) throws InterruptedException
	{
		try {
			driver.get(flightReservationURL);
			getCurrentURL=driver.getCurrentUrl();
			Assert.assertEquals(getCurrentURL, flightReservationURL, pageLoadFailMessage);
			System.out.println(getCurrentURL);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			System.out.println("Code is here 1");
			defaulttriptype=bookFlight.roundTripSelected();
						System.out.println("Code is here 2");
			/*System.out.println(defaulttriptype);
			System.out.println(triptype);
			System.out.println(bookFlight.getTextOneWayTrip());
			System.out.println(bookFlight.getTextRoundTrip());*/
			
			if(triptype.trim().equalsIgnoreCase(bookFlight.getTextRoundTrip()))
				bookFlight.userclickroundTrip();
			else
			if(triptype.trim().equalsIgnoreCase(bookFlight.getTextOneWayTrip()))
				bookFlight.userclickoneWayTrip();
			
			Thread.sleep(5000);
		
				
			bookFlight.userSelectpassengerCount(passengers);
			selecteddepartureport=bookFlight.userSelectdepartureFrom(departingFrom);
			selecteddepatrureMonth=bookFlight.userSelectmonthofDeparture(departureMonth);
			selecteddepartureDate=bookFlight.userSelectdayofDeparture(departureDate);
			selectedarrivalPort=bookFlight.userSelectarrivalTo(arrivalTo);
			selectedarrivalMonth=bookFlight.userSelectmonthofArrival(returnMonth);
			selectedarrivalDate=bookFlight.userSelectarrivalDay(returnDate);
			
			System.out.println(serviceClass);
			System.out.println(bookFlight.getTexteconomyClass());
			System.out.println(bookFlight.getTextbusinessClass());
			System.out.println(bookFlight.getTextfirstClass());
			
			if(serviceClass.equals(bookFlight.getTexteconomyClass()))
				bookFlight.userclickeconomyClass();
			else if(serviceClass.equals(bookFlight.getTextbusinessClass()))
				bookFlight.userclickbusinessClass();
			else if(serviceClass.equals(bookFlight.getTextfirstClass()))
					bookFlight.userclickfirstClass();
			
			bookFlight.userSelectairlinePreference(airlinePreference);
			
						
			System.out.println("Date "+selecteddepartureDate);
			System.out.println("Fmonth "+selecteddepatrureMonth);
			System.out.println("tdate "+selectedarrivalDate);
			System.out.println("tmonth "+selectedarrivalMonth);
			System.out.println("fport "+selecteddepartureport);
			System.out.println("tport "+selectedarrivalPort);
			
			
			sameDate=((selectedarrivalDate.equalsIgnoreCase(selectedarrivalDate))&&(selecteddepatrureMonth.equalsIgnoreCase(selectedarrivalMonth)));
			System.out.println(sameDate);
			Assert.assertFalse(sameDate, departureArrivalSameDate);
			samePort=selecteddepartureport.equalsIgnoreCase(selectedarrivalPort);
			Assert.assertFalse(samePort, departureArrivalSamePort);
			
			bookFlight.userclickflightSelect();
			
			getCurrentURL=driver.getCurrentUrl();
			
			Assert.assertTrue((getCurrentURL.equals(flightReservationSuccess)),flightReservationUnsuccessful+" "+flightReservationSuccess);
						
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] dataprovider() throws IOException{
		int rowCount=exceldataflightbooking.NumberofRows(excelPath, sheetNameFlightBooking);
		int colCount=exceldataflightbooking.NumberofColumns(excelPath, sheetNameFlightBooking);
		//System.out.println("DP"+rowCount);
		//System.out.println("DP"+colCount);
		Object[][] flightBookingData=new Object[rowCount-1][colCount];
		flightBookingData=exceldataflightbooking.excelDataFormatter(excelPath, sheetNameFlightBooking);
		//System.out.println("FlightBookingData "+flightBookingData);
		return flightBookingData;
			
	}

}

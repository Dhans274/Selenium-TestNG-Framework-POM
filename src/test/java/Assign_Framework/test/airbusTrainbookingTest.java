package Assign_Framework.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class airbusTrainbookingTest extends testBase {
	Alert validDestination;
	Alert sourcedestinationSame;
	SoftAssert softassert;
	WebDriverWait explicitWait;
	@Test(dataProvider="dataprovider")
	
	public void railwayTicketBooking(String fromcode,String fromName,String tocode,String toname,String date,String month,String year)
	{
		String stationFrom;
		String stationcodeFrom;
		String stationTo;
		String stationcodeTo;
		//String inputfromstation;
		boolean sameSourceDest;
		boolean stationfromEmpty;
		boolean stationtoEmpty;
		int i=0;
		try {
			driver.get(redbusURL);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			airbusBooking.userclktrainticketicon();
			airbusBooking.userclkbookTickets();
			
			airbusBooking.userclickstationFrom();
			airbusBooking.userinputSourcestationCode(fromcode);
			//explicitWait=new WebDriverWait(driver,Duration.ofSeconds(30));
			//explicitWait.until(ExpectedConditions.)
			Thread.sleep(3000);
			do
			{
				stationFrom=airbusBooking.userSelectstationName(i); //checks if station name is same as the one passed in excel
				stationfromEmpty=(!(stationFrom.isEmpty()));
				stationcodeFrom=airbusBooking.userSelectstationNameCode(i);
				System.out.println(stationFrom+" "+stationcodeFrom);
				if((stationFrom.equalsIgnoreCase(fromName))&&(stationcodeFrom.equalsIgnoreCase(fromcode)))
				{
					System.out.println("code is here 1 "+stationFrom);
						airbusBooking.userClickTablestationName(i);
					System.out.println("code is here 11 "+stationFrom);
				break;
				}
				else
					Assert.assertTrue(stationfromEmpty,fromcode+" "+ searchEmpty);
				i++;
			}while(stationfromEmpty);
			Thread.sleep(3000);
			
			
			
			airbusBooking.userclkstationTo();
			System.out.println("code is here 20");
			airbusBooking.userinputDestinationstation(tocode);
			Thread.sleep(3000);
			
			i=0;
			do {
				
				stationTo=airbusBooking.userSelectstationName(i); //checks if station name is same as the one passed in excel
				stationtoEmpty=(!(stationTo.isEmpty()));
				stationcodeTo=airbusBooking.userSelectstationNameCode(i);
				System.out.println(stationTo+" "+stationcodeTo);
				if((stationTo.equalsIgnoreCase(toname))&&(stationcodeTo.equalsIgnoreCase(tocode)))
				{
					System.out.println("code is here 21 "+stationTo);
						airbusBooking.userClickTablestationName(i);
					System.out.println("code is here 22 "+stationTo);
				break;
				}
				else
					Assert.assertTrue(stationtoEmpty,tocode+" "+ searchEmpty);
				i++;
			}while(stationtoEmpty);
			
			
			airbusBooking.userClkTraveldate();
			Thread.sleep(3000);
			airbusBooking.userclkFreeCancellation();
			airbusBooking.userClicksearchButton();
			sameSourceDest=(stationTo.equalsIgnoreCase(stationFrom));
			if(sameSourceDest)
			{
			Alert alert1=driver.switchTo().alert();
			String alert1text=alert1.getText();
			//String sourceDestinationSame=sourcedestinationSame.getText();
			System.out.println(alert1text);
			//sourcedestinationSame.accept();
			}
			else
			{
			softassert=new SoftAssert();
			softassert.assertFalse(sameSourceDest,samesourceDestination+" "+stationTo+" "+stationFrom);
			softassert.assertAll();
			}
			
			
			Set<String>handles=driver.getWindowHandles();
			Iterator<String> itr=handles.iterator();
			while(itr.hasNext())
				System.out.println(itr.next());
				
			
			Thread.sleep(2000);
			
			
		}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	
	}
	
	
	
	@DataProvider
	public Object[][] dataprovider() throws IOException{
		int rowCount=airbusData.NumberofRows(airbusPath, sheetNameRegistration);
		int colCount=airbusData.NumberofColumns(airbusPath, sheetNameRegistration);
		//System.out.println("DP"+rowCount);
		//System.out.println("DP"+colCount);
		Object[][] bookTrainData=new Object[rowCount-1][colCount];
		bookTrainData=airbusData.excelDataFormatter(airbusPath, sheetNameRegistration);
		//System.out.println("bookTrainData "+bookTrainData);
		return bookTrainData;
			
	}
	
	
}

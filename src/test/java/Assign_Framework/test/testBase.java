package Assign_Framework.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


import Assign_Framework.excelData.excelDataProvider;
import Assign_Framework.pageobject.airbusTrainbooking;
import Assign_Framework.pageobject.confirmregisterPage;
import Assign_Framework.pageobject.flightBooking;
import Assign_Framework.pageobject.loginSuccessPage;
import Assign_Framework.pageobject.registerPage;
import Assign_Framework.pageobject.signIn;
import Assign_Framework.resources.utility;

public class testBase{
	
	WebDriver driver;
	protected registerPage register;
	protected flightBooking bookFlight;
	protected confirmregisterPage confirmregistration;
	protected signIn signin;
	protected loginSuccessPage loginSuccess;

	
	Properties propertytable;
	Properties redbusproperty;
	static String signInURL;
	static String getURL;
	static String pageTitle;
	static String assertFailMessage;
	static String registerFailMessage;
	static String pageLoadFailMessage;
	static String passwordValidate;
	static String registerSuccess;
	static String enterData;
	static String flightReservationURL;
	static String pageNotFound ; 
	static String expectedMessageBody;
	static String expectedGreeting;
	static String expectedNote;
	static String loginSuccessMessage;
	static String loginSuccessMessageBody;
	static String loginSuccessURL;
	static String signinFailMessage;
	static String navigationFailMessage;
	static String departureArrivalSameDate;
	static String departureArrivalSamePort;
	static String businessClassNotAvailable;
	static String triptypeError;
	static String flightReservationUnsuccessful;
	static String oneWayTripError;
	static String defaulttriptype;
	static String flightReservationSuccess;
	

	String excelPath;
	String sheetNameRegistration;
	String sheetNamesignIn;
	String sheetNameFlightBooking;
	
	excelDataProvider exceldata;
	excelDataProvider exceldatasignIn;
	excelDataProvider exceldataflightbooking;
	
	//redbus
	airbusTrainbooking airbusBooking;
	static String redbusURL;
	excelDataProvider airbusData;
	String airbusPath;
	static String samesourceDestination;
	static String invalidsource;
	static String invalidDestination;
	static String searchEmpty;
	
	@BeforeClass
	public void testSetup()
	{
		//String configPath="C:\\Users\\psr\\eclipse-workspace\\Demotour\\src\\test\\java\\Assign_Framework\\resources\\config.properties";
		//String configPath=".\\src\\test\\java\\Assign_Framework\\resources\\config.properties";
		String configPath= System.getProperty("user.dir")+"/src/test/java/Assign_Framework/resources/config.properties"; //gets current directory
		String configPath_airbus="C:\\Users\\psr\\eclipse-workspace\\Demotour\\src\\test\\java\\Assign_Framework\\resources\\properties.properties";	
		
		excelPath="C:\\Users\\psr\\eclipse-workspace\\Demotour\\src\\test\\java\\Assign_Framework\\excelData\\excelData.xlsx";
		airbusPath="C:\\Users\\psr\\eclipse-workspace\\Demotour\\src\\test\\java\\Assign_Framework\\excelData\\airbusData.xlsx";
		
		
		sheetNameRegistration="Sheet1";
		sheetNamesignIn="Sheet2";
		sheetNameFlightBooking="Sheet3";
		try {
			driver=new ChromeDriver();
			propertytable=utility.loadConfigVariables(configPath);
			redbusproperty=utility.loadConfigVariables(configPath_airbus);
			
			exceldata=new excelDataProvider(excelPath,sheetNameRegistration);
			exceldatasignIn=new excelDataProvider(excelPath,sheetNamesignIn);
			exceldataflightbooking=new excelDataProvider(excelPath,sheetNameFlightBooking);
					
			
			register= new registerPage(driver);
			confirmregistration=new confirmregisterPage(driver);
			loginSuccess=new loginSuccessPage(driver);
			signin=new signIn(driver);
			bookFlight=new flightBooking(driver); 
			
		
			getURL=propertytable.getProperty("URL"); //URL from configuration variables
			pageTitle=propertytable.getProperty("pageTitle");
			assertFailMessage=propertytable.getProperty("assertFailMessage");
			registerFailMessage=propertytable.getProperty("registerFailMessage");
			pageLoadFailMessage=propertytable.getProperty("pageLoadFailMessage");
			passwordValidate=propertytable.getProperty("passwordValidate");
			registerSuccess=propertytable.getProperty("registerSuccess");
			enterData=propertytable.getProperty("enterData");
			flightReservationURL=propertytable.getProperty("flightReservationURL");
			pageNotFound=propertytable.getProperty("pageNotFound");
			expectedMessageBody=propertytable.getProperty("expectedMessageBody");
			expectedGreeting=propertytable.getProperty("expectedGreeting");
			expectedNote=propertytable.getProperty("expectedNote");
			loginSuccessMessage=propertytable.getProperty("loginSuccessMessage");
			loginSuccessMessageBody=propertytable.getProperty("loginSuccessMessageBody");
			signinFailMessage=propertytable.getProperty("signinFailMessage");
			navigationFailMessage=propertytable.getProperty("navigationFailMessage");
			departureArrivalSameDate=propertytable.getProperty("departureArrivalSameDate");
			departureArrivalSamePort=propertytable.getProperty("departureArrivalSamePort");
			businessClassNotAvailable=propertytable.getProperty("businessClassNotAvailable");
			triptypeError=propertytable.getProperty("triptypeError");
			oneWayTripError=propertytable.getProperty("oneWayTripError");
			defaulttriptype=propertytable.getProperty("defaulttriptype");
			flightReservationSuccess=propertytable.getProperty("flightReservationSuccess");
			flightReservationUnsuccessful=propertytable.getProperty("flightReservationUnsuccessful");
			signInURL=propertytable.getProperty("signInURL");
			loginSuccessURL=propertytable.getProperty("loginSuccessURL");
			
			
			//
			airbusBooking= new airbusTrainbooking(driver);
			redbusURL=redbusproperty.getProperty("redbusURL");
			airbusData=new excelDataProvider(airbusPath,sheetNameRegistration);
			samesourceDestination=redbusproperty.getProperty("samesourceDestination");
			invalidsource=redbusproperty.getProperty("invalidsource");
			invalidDestination=redbusproperty.getProperty("invalidDestination");
			searchEmpty=redbusproperty.getProperty("searchEmpty");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			}
		}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}

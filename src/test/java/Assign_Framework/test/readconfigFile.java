package Assign_Framework.test;

import java.util.Properties;

public class readconfigFile {
	
	Properties propertytable;
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
	
	public void configfileInitialization()
	{
		getURL=propertytable.getProperty("URL"); //URL from configuration variables
		pageTitle=propertytable.getProperty("pageTitle");
		assertFailMessage=propertytable.getProperty("assertFailMessage");
		//assertPassMessage=propertytable.getProperty("assertPassMessage");
		registerFailMessage=propertytable.getProperty("registerFailMessage");
		pageLoadFailMessage=propertytable.getProperty("pageLoadFailMessage");
		passwordValidate=propertytable.getProperty("passwordValidate");
		registerSuccess=propertytable.getProperty("registerSuccess");
		enterData=propertytable.getProperty("enterData");
		flightReservationURL=propertytable.getProperty("flightReservationURL");
		pageNotFound=propertytable.getProperty("pageNotFound");
		expectedMessageBody=propertytable.getProperty("expectedMessageBody");
		expectedGreeting=propertytable.getProperty("expectedGreeting");
	}

}

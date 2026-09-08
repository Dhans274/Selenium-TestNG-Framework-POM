package Assign_Framework.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Registration extends testBase {
	boolean invaliduserName;
	boolean invalidfirstName;
	boolean invalidlastName;
	boolean invalidphonenum;
	boolean invalidemailId;
	boolean invalidpassword;
	boolean invalidconfirmPassword;
	boolean registrationSuccess;
	
	String getfirstName;
	String getlastName;
	String getemailID;
	String getphoneNo;
	String getuserName;
	String getPassword;
	String getconfirmPassword;
	
	SoftAssert softassert;
	
	String loadTitle;
	String actualGreeting;
	String actualMessage;
	String actualNote;
	String expectedfinalGreeting;
	String expectedfinalMessage;
	String expectedfinalNote;
	
	@Test(dataProvider="dataprovider", priority=0)
	public void userRegistration(String firstName, String lastName,String phoneNo,String emailId,String address, String city,String state,String pincode,String country,String userName,String password,String confirmPassword) throws InterruptedException 
	{
		try
		{
		driver.get(getURL); 
		System.out.println(getURL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		loadTitle=driver.getTitle();
		Assert.assertEquals(loadTitle, pageTitle, pageLoadFailMessage);
		driver.manage().window().maximize();
		
		register.userInputfirstName(firstName);
		register.userInputlastName(lastName);
		register.userInputphoneNo(phoneNo);
		register.userInputemailID(emailId);
		register.userInputaddress(address);
		register.userInputcity(city);
		register.userInputstate(state);
		register.userInputpincode(pincode);
		register.userSelectcountry(country);
		register.userInputuserName(userName);
		register.userInputpassword(password);
		register.userInputconfirmpassword(confirmPassword);
		
		System.out.println("Code is here"+register.getTextuserName());
		
		
		getfirstName=register.getTextfirstName();
		getlastName=register.getTextlastName();
		getemailID=register.getTextemailId();
		getphoneNo=register.getTextphoneNum();
		getuserName=register.getTextuserName();
		getPassword=register.getTextpassword();
		getconfirmPassword=register.getTextconfirmPassword();
		
		System.out.println("First name"+getfirstName+" "+getlastName);
		
		
		invalidfirstName=getfirstName.isBlank(); 
		System.out.println("Code is here 10");
		Assert.assertFalse(invalidfirstName, enterData+getfirstName);
		
		invaliduserName=getuserName.isBlank(); 
		System.out.println("Code is here 20");
		Assert.assertFalse(invaliduserName, enterData+getuserName);
		
		invalidpassword=getPassword.isBlank();
		System.out.println("Code is here 30"+getPassword);
		Assert.assertFalse(invalidpassword, enterData+getPassword);
		
		invalidconfirmPassword=getconfirmPassword.isBlank(); 
		System.out.println("Code is here 40"+getconfirmPassword);
		Assert.assertFalse(invalidconfirmPassword, enterData+getconfirmPassword);
		
		
		//Thread.sleep(2000);
		register.userClicksubmit();
		
		System.out.println("Code is here 50"+getPassword);
		System.out.println("Code is here 60"+getconfirmPassword);
		if(!(getPassword.equals(getconfirmPassword)))
		{
			System.out.println("Code is here 2");
			Assert.assertEquals(passwordValidate,register.reenterpassworderror(),passwordValidate);
			System.out.println(register.reenterpassworderror());
		}
		else
		{
		//<--------To check if https://demo.guru99.com/test/newtours/register_sucess.php is displayed
			
		registrationSuccess= (driver.getCurrentUrl()).equals(registerSuccess);
		System.out.println("Code is here 3  "+driver.getCurrentUrl());
		Assert.assertTrue(registrationSuccess, registerFailMessage);
		
		//Confirmation page validation
		expectedfinalGreeting=expectedGreeting+" "+firstName+" "+lastName+",";
		expectedfinalNote=expectedNote+" "+userName+".";
		actualGreeting=confirmregistration.confirmGreeting();
		actualMessage=confirmregistration.messageBody();
		actualNote=confirmregistration.confirmUserName();
		
		System.out.println(actualGreeting);
		System.out.println(actualMessage);
		System.out.println(actualNote);
		
		softassert=new SoftAssert();
		System.out.println("Code is here 4");
		softassert.assertEquals(actualGreeting,expectedfinalGreeting, actualGreeting);
		System.out.println("Code is here 5");
		softassert.assertEquals(actualMessage,expectedMessageBody, actualMessage);
		System.out.println("Code is here 6");
		softassert.assertEquals(actualNote,expectedfinalNote, actualNote);	
		System.out.println("Code is here 7");
		softassert.assertAll();
		
		}
		
		softassert=new SoftAssert();
		System.out.println("Code is here 101");
		
		invalidemailId=(getemailID.contains("@"));
		System.out.println("Code is here 100");
		softassert.assertTrue(invalidemailId,enterData+"@"+getemailID);
		
		invalidemailId=getemailID.isBlank();
		softassert.assertFalse(invalidemailId,enterData+getemailID);
		System.out.println("Code is here 200");
		
		invalidlastName=getlastName.isBlank();
		softassert.assertFalse(invalidlastName,enterData+getemailID);
		System.out.println("Code is here 200");
		
		invalidphonenum=getphoneNo.isBlank();
		softassert.assertFalse(invalidphonenum,enterData+getphoneNo+"");
		System.out.println("Code is here 300");
		
		softassert.assertAll();
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
			
	}

	
	
	
	@DataProvider
	public Object[][] dataprovider() throws IOException{
		int rowCount=exceldata.NumberofRows(excelPath, sheetNameRegistration);
		int colCount=exceldata.NumberofColumns(excelPath, sheetNameRegistration);
		//System.out.println("DP"+rowCount);
		//System.out.println("DP"+colCount);
		Object[][] registerData=new Object[rowCount-1][colCount];
		registerData=exceldata.excelDataFormatter(excelPath, sheetNameRegistration);
		//System.out.println("Registerdata "+registerData);
		return registerData;
			
	}

}


/*Set<String> handles= driver.getWindowHandles();
List<String> windowhandles=new ArrayList<String>(handles);
System.out.println(windowhandles);
System.out.println(driver.getCurrentUrl());
*/
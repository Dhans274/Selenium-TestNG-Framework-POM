package Assign_Framework.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginTest extends testBase{
	String getCurrentURL;
	String linkregisterURL;
	
	String getuserName;
	String getPassword;
	
	Boolean validateuserName;
	Boolean validatePassword;
	
	Boolean signinSuccess;
	Boolean linkregisterPage;
		
	String getValidationmessage;
	String actualLoginErrorMessage;
	String actualLoginSuccessMessage;
	String actualLoginSuccesMessageBody;
	String linkRegistrationPage;
	String backtoSignInPage;
	
	SoftAssert softassert;
	
	
	@Test(dataProvider="dataprovider", priority=0)
	public void signinTest(String userName,String password) throws InterruptedException
	{
		try {
			
		driver.get(signInURL);
		getCurrentURL=driver.getCurrentUrl();
		Assert.assertEquals(getCurrentURL, signInURL, pageLoadFailMessage);
		System.out.println(getCurrentURL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		signin.inputUserName(userName);
		signin.inputPassword(password);
		//System.out.println("userName"+" "+userName);
		//System.out.println("password"+" "+password);
		
		getuserName=signin.getUserName();
		getPassword=signin.getPassword();
		
		validateuserName=!(getuserName.isBlank());
		Assert.assertTrue(validateuserName, enterData+validateuserName);
		validatePassword=!(getuserName.isBlank());
		Assert.assertTrue(validatePassword, enterData+validatePassword);
		
		
		signin.btnclickSubmit();
		signinSuccess= (driver.getCurrentUrl()).equals(loginSuccessURL);
		System.out.println("Code is here 1  "+driver.getCurrentUrl());
		Assert.assertTrue(signinSuccess, signinFailMessage);
	}catch(NullPointerException nullpointexception)
		{
			System.out.println(nullpointexception.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test(dependsOnMethods="signinTest",priority=1 )
	public void verifyLoginSuccessPage() {
		try
		{
		System.out.println("Code is here 11  "+driver.getCurrentUrl());
		actualLoginSuccessMessage=loginSuccess.successfulLoginMessage();
		actualLoginSuccesMessageBody=loginSuccess.successfulLoginMessageBody();
		System.out.println(actualLoginSuccessMessage);
		System.out.println(loginSuccessMessage);
		System.out.println(actualLoginSuccesMessageBody);
		System.out.println(loginSuccessMessageBody);
	
		softassert=new SoftAssert();
		softassert.assertEquals(actualLoginSuccessMessage,loginSuccessMessage, signinFailMessage+" "+actualLoginSuccessMessage);
		softassert.assertEquals(actualLoginSuccesMessageBody,loginSuccessMessageBody, signinFailMessage+" "+actualLoginSuccesMessageBody);
		softassert.assertAll();
		}
		catch(NullPointerException nullpointexception)
		{
			System.out.println(nullpointexception.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	
	@SuppressWarnings("deprecation")
	@Test(priority=2)
		public void linktoRegisterPage(){
		try{
		driver.get(signInURL);
		getCurrentURL=driver.getCurrentUrl();
		Assert.assertEquals(getCurrentURL, signInURL, pageLoadFailMessage);
		//System.out.println(getURL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		signin.linkclkRegistration();
		linkregisterPage= (driver.getCurrentUrl()).equals(getURL);
		System.out.println("Code is here 10  "+driver.getCurrentUrl());
		System.out.println("Code is here 20  "+linkregisterPage);
		softassert=new SoftAssert();
		softassert.assertTrue(linkregisterPage,navigationFailMessage+" "+linkregisterPage);
		softassert.assertAll();
		}
		catch(NullPointerException nullpointexception)
		{
			System.out.println(nullpointexception.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	

	@DataProvider
	public Object[][] dataprovider() throws IOException{
		int rowCount = exceldatasignIn.NumberofRows(excelPath, sheetNamesignIn);
		int colCount = exceldatasignIn.NumberofColumns(excelPath, sheetNamesignIn);
		//System.out.println("DP "+rowCount);
		//System.out.println("DP " +colCount);
		Object[][] signInData = new Object[rowCount - 1][colCount];
		signInData = exceldatasignIn.excelDataFormatter(excelPath, sheetNamesignIn);
		System.out.println("SignIndata " + signInData);
		return signInData;
		
	}
		
}
	
	


package Assign_Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginSuccessPage extends pageBase{

	public loginSuccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//h3[text()='Login Successfully']")
	WebElement loginsuccessMessage;
	
	@FindBy(xpath="//b[text()=' Thank you for Loggin. ']")
	WebElement loginmessageBody;
	
	public String successfulLoginMessage()
	{
		return loginsuccessMessage.getText();
	}
	
	public String successfulLoginMessageBody()
	{
		return loginmessageBody.getText();
	}

}

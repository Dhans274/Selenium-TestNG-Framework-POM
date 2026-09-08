package Assign_Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signIn extends pageBase{

	public signIn(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="userName")
	WebElement loginUsername;
	
	@FindBy(name="password")
	WebElement loginPassword;
	
	@FindBy(name="submit")
	WebElement loginSubmit;
	
	@FindBy(xpath="//body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/a")
	WebElement loginRegistrationlink;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::span")
	WebElement loginValidationMessage;
	
	public void inputUserName(String userName)
	{
		loginUsername.clear();
		loginUsername.sendKeys(userName);
	}
	
	public void inputPassword(String password)
	{
		loginPassword.clear();
		loginPassword.sendKeys(password);
	}

	public void btnclickSubmit()
	{
		loginSubmit.click();
	}
	
	public void linkclkRegistration()
	{
		loginRegistrationlink.click();
	}
	
	
	public String getUserName()
	{
		return loginUsername.getAttribute("value");
	}
		
	public String getPassword()
	{
		return loginPassword.getAttribute("value");
	}
	
	public String validationMessage()
	{
		return loginValidationMessage.getText();
	}
}

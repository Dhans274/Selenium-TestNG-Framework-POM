package Assign_Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class confirmregisterPage extends pageBase{

	public confirmregisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how=How.XPATH,using="//a[text()=' sign-in ']/parent::font/parent::p/parent::td/p[1]/font[1]/b")
	WebElement greetingWords;
	
	@FindBy(xpath="//a[text()=' sign-in ']/parent::font")
	WebElement registerconfirmMessage;
	
	@FindBy(xpath="//a[text()=' sign-in ']/parent::font/parent::p/parent::td/p[3]/font/b")
	WebElement usernameConfirmation;
	
	public String confirmGreeting()
	{
		return greetingWords.getText();
	}
	
	public String messageBody()
	{
		return registerconfirmMessage.getText();
	}
	
	public String confirmUserName()
	{
		return usernameConfirmation.getText();
	}
	

}

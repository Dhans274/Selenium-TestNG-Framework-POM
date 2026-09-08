package Assign_Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class registerPage extends pageBase{

		public registerPage(WebDriver driver) {
			super(driver);
			
		}

		@FindBy(how=How.NAME,using="firstName")
		private WebElement inputfirstName;
		
		@FindBy(xpath="//input[@name='lastName']")
		WebElement inputlastName;
		
		@FindBy(name="phone")
		WebElement inputphoneNum;
		
		@FindBy(id="userName")
		WebElement inputemailId;
		
		@FindBy(name="address1")
		WebElement inputaddress;
		
		@FindBy(xpath="//input[@name='city']")
		WebElement inputcity;
		
		@FindBy(xpath="//input[@name='state']")
		WebElement inputstate;
		
		@FindBy(xpath="//input[@name='postalCode']")
		WebElement inputpincode;
		
		@FindBy(name="country")
		WebElement selectcountry;
			
		
		@FindBy(id="email")
		WebElement inputuserName;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement inputpassword;
		
		@FindBy(xpath="//input[@name='confirmPassword']")
		WebElement inputconfirmPassword;
		
		@FindBy(name="submit")
		WebElement btnsubmit;
		
		@FindBy(xpath="//input[@name='confirmPassword']/following-sibling::span")
		WebElement confirmpassworderror;
		
		
			
		public void userInputfirstName(String firstName) {
			inputfirstName.sendKeys(firstName);
			
		}

		public void userInputlastName(String lastName) {
			inputlastName.sendKeys(lastName);
		}

		public void userInputphoneNo(String phoneNo) {
			inputphoneNum.sendKeys(phoneNo);
		}

		public void userInputemailID(String emailID) {
			inputemailId.sendKeys(emailID);
		}

		public void userInputaddress(String address1) {
			inputaddress.sendKeys(address1);
		}
		
		
		public void userInputcity(String city) {
			inputcity.sendKeys(city);
		}

		public void userInputstate(String state) {
			inputstate.sendKeys(state);
		}

		public void userInputpincode(String pincode) {
			inputpincode.sendKeys(pincode);
		}
		
		public void userSelectcountry(String country) {
			Select oselect=new Select(selectcountry);
			oselect.selectByVisibleText(country);
			
		}
		
		public void userInputuserName(String userid) {
			inputuserName.sendKeys(userid);
		}

		public void userInputpassword(String password) {
			inputpassword.sendKeys(password);
		}
		public void userInputconfirmpassword(String cnfmpassword) {
			inputconfirmPassword.sendKeys(cnfmpassword);
		}
		
		public void userClicksubmit() {
			btnsubmit.click();
		}
		
		//Password error Text
		public String reenterpassworderror() {
			 return this.confirmpassworderror.getText();
			
		}
		
		public String getTextfirstName() {
			return inputfirstName.getAttribute("value");
			
		}

		public String getTextlastName() {
			return inputlastName.getAttribute("value");
		}

		public String getTextuserName() {
			return inputuserName.getAttribute("value");
		}
		
		public String getTextpassword() {
			return inputpassword.getAttribute("value");
		}

		public String getTextconfirmPassword() {
			return inputconfirmPassword.getAttribute("value");
		}
		
		public String getTextphoneNum() {
			return inputphoneNum.getAttribute("value");
		}
		
		public String getTextemailId() {
			System.out.println("Email id"+inputemailId.getAttribute("value"));
			return inputemailId.getAttribute("value");
		}

}

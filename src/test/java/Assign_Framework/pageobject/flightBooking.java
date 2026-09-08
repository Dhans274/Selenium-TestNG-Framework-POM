package Assign_Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

public class flightBooking extends pageBase{

	public flightBooking(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		@FindBys({
		@FindBy(name="findflight"),	@FindBy(xpath="//input[@value='roundtrip']")})
		WebElement roundTrip;
		
		@FindBys({
			@FindBy(name="findflight"),	@FindBy(xpath="//input[@value='oneway']")})
		WebElement oneWayTrip;
		
		@FindBy(xpath="//input[@value='roundtrip']/parent::font")
		WebElement tripType;
		
		@FindBy(name="passCount")
		WebElement passengersCount;
		
		@FindBy(name="fromPort")
		WebElement departurePort;
		
		@FindBy(name="fromMonth")
		WebElement fromdepartureMonth;
		
		@FindBy(name="fromDay")
		WebElement fromdepartureDay;
		
		@FindBy(name="toPort")
		WebElement arrivalPort;
		
		@FindBy(name="toMonth")
		WebElement toarrivalMonth;
		
		@FindBy(name="toDay")
		WebElement toarrivalDay;
		
		@FindBy(xpath="//input[@value='Coach']")
		WebElement economyClass;
		
		@FindBy(xpath="//input[@value='Business']")
		WebElement businessClass;
		
		@FindBy(xpath="//input[@value='First']")
		WebElement firstClass;
		
		@FindBy(xpath="//select[@name='airline']")
		WebElement airlinePreference;
		
		@FindBy(name="findFlights")
		WebElement findFlights;
		
		
		public void userclickroundTrip() {
			roundTrip.click();
		}
		
		
		
		public void userclickoneWayTrip() {
			oneWayTrip.click();
		}
		
		public void userclickbusinessClass() {
			businessClass.click();
		}
		
		public void userclickeconomyClass() {
			economyClass.click();
		}
		
		public void userclickfirstClass() {
			firstClass.click();
		}
		
		
		public void userSelectpassengerCount(String passCount) {
			Select oselect=new Select(passengersCount);
			oselect.selectByValue(passCount);
		}
		
		public String userSelectdepartureFrom(String departureFrom) {
			Select oselect=new Select(departurePort);
			oselect.selectByVisibleText(departureFrom);
			return oselect.getFirstSelectedOption().getText();
		}
		
		public String userSelectmonthofDeparture(String departureMonth) {
			Select oselect=new Select(fromdepartureMonth);
			oselect.selectByVisibleText(departureMonth);
			return oselect.getFirstSelectedOption().getText();
		}
		
		public String userSelectdayofDeparture(String departureDay) {
			Select oselect=new Select(fromdepartureDay);
			oselect.selectByValue(departureDay);
			return oselect.getFirstSelectedOption().getText();
		}
		
		public String userSelectarrivalTo(String arrivalTo) {
			Select oselect=new Select(arrivalPort);
			oselect.selectByVisibleText(arrivalTo);
			return oselect.getFirstSelectedOption().getText();
		}
		
		
		public String userSelectmonthofArrival(String arrivalMonth) {
			Select oselect=new Select(toarrivalMonth);
			oselect.selectByVisibleText(arrivalMonth);
			return oselect.getFirstSelectedOption().getText();
		}
		
		
		public String userSelectarrivalDay(String arrivalDay) {
			Select oselect=new Select(toarrivalDay);
			oselect.selectByValue(arrivalDay);
			return oselect.getFirstSelectedOption().getText();
		}
		
		public void userSelectairlinePreference(String preference) {
			Select oselect=new Select(airlinePreference);
			oselect.selectByVisibleText(preference);
		}
		
		public void userclickflightSelect() {
			findFlights.click();
		}
			
		
		public boolean roundTripSelected() {
			return roundTrip.isSelected();
		}
				
		public String getTextRoundTrip()
		{
			return roundTrip.getAttribute("value");
			
			
		}
		public String getTextOneWayTrip()
		{
			return oneWayTrip.getAttribute("value");
			
		}
		
		public String getTexteconomyClass()
		{
			return economyClass.getAttribute("value");
			
		}
		public String getTextbusinessClass()
		{
			return businessClass.getAttribute("value");
			
		}
		public String getTextfirstClass()
		{
			return firstClass.getAttribute("value");
			
		}
		
	/*	public String getdepartureDate()
		{
			
			return fromdepartureDay.getAttribute("value");
		}
		
		public String getdepartureMonth()
		{
			return fromdepartureMonth.getAttribute("value");
		}
		public String getArrivalDate()
		{
			return toarrivalDay.getAttribute("value");
		}
		public String getArrivalMonth()
		{
			return toarrivalMonth.getAttribute("value");
		}
		public String getDepaturePort()
		{
			return departurePort.getAttribute("value");
		}
		public String getArrivalPort()
		{
			WebElement
			return arrivalPort.getAttribute("value");
		}
		
		*/
}


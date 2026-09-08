package Assign_Framework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class airbusTrainbooking extends pageBase {

	public airbusTrainbooking(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="rail_tickets_vertical")
	WebElement userClktrainTickets;
	
	@FindBy(xpath="//p[text()='Book Train tickets']/following-sibling::div")
	WebElement userClkbookTrainTickets;
		
	@FindBy(xpath="//label[@for='src']")
	WebElement userclkstationFrom;
	
	@FindBy(xpath="//label[@for='dst']")
	WebElement userclkstationTo;
	
	@FindBy(id="src")
	WebElement sourcestation;
	
	@FindBy(id="dst")
	WebElement destinationStation;
	
	@FindBy(xpath="//div[@class='stn_name_code_wrap']/div[1]")
	WebElement dropdownStationName;
	
	@FindBy(xpath="//div[@class='stn_name_code_wrap']/div[2]")
	WebElement dropdownStationCode;
	
	@FindBy(xpath="//div[@class='home_date_month']")
	WebElement travelDate;
	
	@FindBys({
		@FindBy(xpath="//div[@class='solr_results_search_wrap']"),
		@FindBy(xpath="//div[@class='solr_results_block']")
	})
	List<WebElement> stationNameCode;
	
	@FindBy(xpath="//div[@class='home_date_month']")
			WebElement clickdateMonth;
	
	/*@FindBy(xpath="//div[@class='date-text']/div[3]")
	WebElement setdateYear;*/
	
	@FindBy(xpath="//div[@class='sc-gzVnrw ktEypG']/span")
	WebElement selectDate;
	
	@FindBy(xpath="//div[@class='sc-gZMcBi fSiRuE']/div[2]")
	WebElement monthyearPicker;
	
	@FindBy(xpath="//div[@class='sc-gZMcBi fSiRuE']/div[1]")
	WebElement backArrow;
	
	@FindBy(xpath="//div[@class='sc-gZMcBi fSiRuE']/div[3]")
	WebElement forwardArrow;
	
	
	@FindBys({
		@FindBy(xpath="//div[@class='calendar-wrapper']/div/div/div/div[3]"),
		@FindBy(id="Layer_1")
	})
	WebElement datePicker;
	
	@FindBy(xpath="//div[@class='checkbox_wrap']")
	WebElement freeCancellation;

	
	@FindBy(xpath="//button[@class='search-btn ']")
	WebElement searchTrains;
	
	public void userclktrainticketicon()
	{
		userClktrainTickets.click();
	}
	
	public void userclkbookTickets()
	{
		userClkbookTrainTickets.click();
	}
	
	public void userclickstationFrom() //
	{
		userclkstationFrom.click();
	}
	
	public void userclkstationTo()
	{
		userclkstationTo.click();
	}
	
	
	
	public void userinputSourcestationCode(String fromstation)
	{
		sourcestation.clear();
		destinationStation.clear();
		sourcestation.sendKeys(fromstation);
		//sourcestation.sendKeys(Keys.ENTER);
	}
	
		
	public void userinputSourcestation()
	{
		sourcestation.click();
	}
	
	
	public void userinputDestinationstation(String tostation)
	{
		destinationStation.clear();
		destinationStation.sendKeys(tostation);
	
	}
	
	public String userSelectstationName(int i)
	{
		 String selectedstationname="";
		int tableSize=stationNameCode.size();
		System.out.println("Stations "+tableSize);
		if(i<tableSize)
			 selectedstationname = stationNameCode.get(i).findElement(By.xpath(".//div/div[1]")).getText();
		return selectedstationname;
	}
	
	public void userClickTablestationName(int i)
	{
		int tableSize=stationNameCode.size();
		System.out.println("Stations "+tableSize);
		if(i<tableSize)
			stationNameCode.get(i).findElement(By.xpath(".//div/div[1]")).click();
	}
	
	public String userSelectstationNameCode(int i)
	{
		 String selectedstationcode="";
		int tableSize=stationNameCode.size();
		System.out.println("Stations "+tableSize);
		if(i<tableSize)
			 selectedstationcode = stationNameCode.get(i).findElement(By.xpath(".//div/div[2]")).getText();
		return selectedstationcode;
	}
	
	public String sourceSelected()
	{
		return sourcestation.getAttribute("value");
	}
	
	public String sestinationSelected()
	{
		return destinationStation.getAttribute("value");
	}
	
	public void userClickDateTimePickerDisplay()
	{
		clickdateMonth.click();;
	}
	
	public String displayDPmonthYear()
	{
		return monthyearPicker.getText();
	}
	
	
	public void forwardpointer()
	{
		forwardArrow.click();
	}
	
	
	public void backwardpointer()
	{
		backArrow.click();
	}
	
	public void userclkFreeCancellation()
	{
		freeCancellation.click();
	}
	
			
	public void userClkTraveldate()
	{
		travelDate.click();
	}
	
	public void userClicksearchButton()
	{
		searchTrains.click();
	}
	
	
}





/*public void userinputSourcestation(Keys arrowdown)
{
	sourcestation.sendKeys(arrowdown);
}

public void userinputDestinationstation(Keys arrowdown)
{
	destinationStation.sendKeys(arrowdown);
	
}*/
/*public String userinputStationCode()
{
	return dropdownStationCode.getText();
}

public void userinputStationNameClick()
{
	 dropdownStationName.click();
}

public String userinputStationName()
{
	return dropdownStationName.getText();
}
*/
	



	


package Assign_Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageBase {

		// TODO Auto-generated method stub
		protected WebDriver driver;
		
		public pageBase(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this); //initialize driver = this.driver
					
		}

	}



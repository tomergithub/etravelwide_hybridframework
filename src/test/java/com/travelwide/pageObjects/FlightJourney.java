package com.travelwide.pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.travelwide.testCases.BaseClass;

public class FlightJourney{
	WebDriver ldriver;
	//Constructor created
		public FlightJourney(WebDriver rdriver)
		{
			 ldriver=rdriver;
			 PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(name="origin_name")
		WebElement txtOrigin;
		
		@FindBy(name="destination_name")
		@CacheLookup
		WebElement txtdestination;
		//depart
		@FindBy(xpath="//*[@id=\"flights-form-b7ddacb4d3a5500b3045913931e2b9b6\"]/div[4]/div[1]")
		@CacheLookup
		WebElement txtDepartDateTextClick;
		@FindBy(xpath="//span[contains(@class,'mewtwo-datepicker-months')]/span")
		@CacheLookup
		WebElement txtDepartDateMonthselected;
		@FindBy(xpath="//span[contains(@class,'mewtwo-datepicker-next-month-control')]")
		@CacheLookup
		WebElement txtDepartDateMonthnextarrow;
		@FindBy(xpath="//div[@class='mewtwo-datepicker-container']//div//div[1]//table[1]//tr//td//div[1]")
		@CacheLookup
		List<WebElement> txtDepartDateselected;
		
		//return
		@FindBy(xpath="//div[contains(@class,'mewtwo-flights-dates-return mewtwo-flights-dates-return--filled')]")
		@CacheLookup
		WebElement txtReturnDateTextClick;
		@FindBy(xpath="//span[@class='mewtwo-datepicker-months mewtwo-datepicker-months--with_return_button']/span")
		@CacheLookup
		WebElement txtReturnDateMonthselected;
		@FindBy(xpath="//span[@class='mewtwo-datepicker-next-month-control']")
		@CacheLookup
		WebElement txtReturnDateMonthnextarrow;
		@FindBy(xpath="//div[@class='mewtwo-datepicker-container']//div[2]//table[1]//tr/td/div[1]")
		@CacheLookup
		List<WebElement> txtReturnDateselected;
		
		@FindBy(className="mewtwo-flights-trip_class-wrapper mewtwo-flights-trip_class-wrapper--new")
		@CacheLookup
		WebElement txtPassenger;
		
		@FindBy(xpath="//*[@id=\"flights-form-b7ddacb4d3a5500b3045913931e2b9b6\"]/div[6]/button")
		@CacheLookup
		WebElement txtSubmit;	
		
		@FindBy(xpath="//a[@class='ticket-action-button-deeplink ticket-action-button-deeplink--'][@role='main-proposal-link']")
		@CacheLookup
	    List<WebElement> txtBookLink;	
		
		
		
		public void setOrigin(String origin) throws InterruptedException
		{   
			txtOrigin.click();
			txtOrigin.clear();
			Thread.sleep(3000);
			txtOrigin.sendKeys(origin);
		}
		
		public void setdestination(String destination) throws InterruptedException
		{txtdestination.click();
			txtdestination.clear();
			Thread.sleep(3000);
			txtdestination.sendKeys(destination);
			Thread.sleep(3000);
		}
		
		public void setSubmit() throws InterruptedException
		{
			txtSubmit.click();
			Thread.sleep(5000);
		}	
		
		public void setBookLink(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(6000);	
			
			Set<String> s=driver.getWindowHandles();
			for(String W:s) 
			{
			String t=driver.switchTo().window(W).getTitle();
			System.out.println(t);
			}	
		
			for (WebElement webElement : txtBookLink) 
			{
	        webElement.click();
	        break;       
			}	
		}
		/*public static void selectDepartDateByJS(WebDriver driver,WebElement depdate ,String dateVal)
		{depdate.click();
		System.out.println(depdate.getTagName());
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",depdate);
		}*/
		
		public void DepartDatePicker() throws InterruptedException
		{Thread.sleep(3000);
		txtDepartDateTextClick.click();
		    String month="May 2020";
		    String exp_date="28";    	  
		    
		    while(true)
		    {
		    	String text=txtDepartDateMonthselected.getText();
		         
		    	if(text.equals(month))
		    	{
		    		break;
		    	}
		    	else
		    	{
		    		txtDepartDateMonthnextarrow.click();
		    	}
		    	
		    }
		    List <WebElement>allDates=txtDepartDateselected;
		    
			for(WebElement ele:allDates)
			{
		    	String date_text=ele.getText();
		    	// if months come together with date like March 
		    	//1
		    	//March
		    	//2
		    	//String date[]=date_text.split("\n"); date 0 =March ; date1=1;etc
		    	if(date_text.equals(exp_date)) 
		    	{
		    		ele.click();
		    		break;
		    	}
		    	
			}}	
		
		public void ReturnDatePicker() throws InterruptedException
		{Thread.sleep(3000);
		txtReturnDateTextClick.click();
		    String ret_month="June 2020";
		    String ret_exp_date="5";    	  
		    
		    while(true)
		    {
		    	String text=txtReturnDateMonthselected.getText();
		         
		    	if(text.equals(ret_month))
		    	{
		    		break;
		    	}
		    	else
		    	{
		    		txtReturnDateMonthnextarrow.click();
		    	}
		    	
		    }
		    List <WebElement>ret_allDates=txtReturnDateselected;
		    
			for(WebElement ret_ele:ret_allDates)
			{
		    	String date_text=ret_ele.getText();
		    	// if months come together with date like March 
		    	//1
		    	//March
		    	//2
		    	//String date[]=date_text.split("\n"); date 0 =March ; date1=1;etc
		    	if(date_text.equals(ret_exp_date)) 
		    	{
		    		ret_ele.click();
		    		break;
		    	}
		    	
			}
			}	
		
		
}

package com.travelwide.testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.travelwide.pageObjects.FlightJourney;

//import junit.framework.Assert;

public class TC_FlightJourney_001 extends BaseClass
{
	@Test
	public void FlightJourneyTest() throws InterruptedException
	{

		driver.get(baseURL);
		FlightJourney fj=new FlightJourney(driver);
		fj.setOrigin(origin);
		fj.setdestination(destination);	
		Thread.sleep(3000);
		fj.DepartDatePicker();
		
		Thread.sleep(3000);
		fj.ReturnDatePicker();
		Thread.sleep(3000);
		fj.setSubmit();		
		Thread.sleep(6000);		
		System.out.println(driver.getTitle());	
	    fj.setBookLink(driver);
	//WebDriverWait wait=new WebDriverWait(driver,30);
	//wait.until(ExpectedConditions.elementToBeClickable(txtBookLink1));
	//txtBookLink1.click();//
	    System.out.println(driver.getTitle());
	    System.out.println("Hooray");
		Thread.sleep(6000);
		Assert.assertFalse(driver.getTitle().contains("error"));
		
	
	}
	
	
	
	
	
	
	

}

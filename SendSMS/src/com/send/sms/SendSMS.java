package com.send.sms;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SendSMS {
	
	@SuppressWarnings("rawtypes")
	AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	@BeforeMethod
	 public void setUp() throws MalformedURLException {
		// TODO Auto-generated method stub
	
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "My Phone");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.sonyericsson.conversations");
		capabilities.setCapability("appActivity", "com.sonyericsson.conversations.ui.ConversationListActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
	
	@Test(priority = 1)
	public void approach1() throws InterruptedException
	{
		driver.findElementById("com.sonyericsson.conversations:id/floating_button_new_conversation").click();
		driver.findElementById("com.sonyericsson.conversations:id/recipients_editor").sendKeys("7824033266");
		driver.findElementById("com.sonyericsson.conversations:id/conversation_edit_text").sendKeys("Test SMS from Appium");
		driver.hideKeyboard();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'sim_card_text') and @text = '2']").click();
		Thread.sleep(5000);
		Boolean iselementpresent = driver.findElementsByXPath("//android.widget.TextView[contains(@resource-id,'message')]").size() != 0;
		System.out.println("Result: "+iselementpresent);
		if(iselementpresent == true)
		{
			driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]").click();
		}
	}
	
	@Test(priority = 2)
	public void approach2() throws InterruptedException
	{
		driver.findElementById("com.sonyericsson.conversations:id/floating_button_new_conversation").click();
		driver.getKeyboard().sendKeys("7824033266");
		Thread.sleep(5000);
		driver.findElementById("com.sonyericsson.conversations:id/conversation_edit_text").sendKeys("");
		driver.getKeyboard().sendKeys("Test SMS from Appium");
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'sim_card_text') and @text = '2']").click();
		Thread.sleep(5000);
		Boolean iselementpresent = driver.findElementsByXPath("//android.widget.TextView[contains(@resource-id,'message')]").size() != 0;
		if(iselementpresent == true)
		{
			driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]").click();
		}
	}
	
	@Test(priority = 3)
	public void approach3() throws InterruptedException
	{
		driver.findElementById("com.sonyericsson.conversations:id/floating_button_new_conversation").click();
		driver.pressKeyCode(14);
		driver.pressKeyCode(15);
		driver.pressKeyCode(9);
		driver.pressKeyCode(11);
		driver.pressKeyCode(7);
		driver.pressKeyCode(10);
		driver.pressKeyCode(10);
		driver.pressKeyCode(9);
		driver.pressKeyCode(14);
		driver.pressKeyCode(14);
		Thread.sleep(5000);
		driver.findElementById("com.sonyericsson.conversations:id/conversation_edit_text").sendKeys("");
		driver.pressKeyCode(48);
		driver.pressKeyCode(33);
		driver.pressKeyCode(47);
		driver.pressKeyCode(48);
		driver.pressKeyCode(62);
		driver.pressKeyCode(47);
		driver.pressKeyCode(41);
		driver.pressKeyCode(47);
		driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'sim_card_text') and @text = '2']").click();
		Thread.sleep(5000);
		Boolean iselementpresent = driver.findElementsByXPath("//android.widget.TextView[contains(@resource-id,'message')]").size() != 0;
		if(iselementpresent == true)
		{
			driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]").click();
		}
		
	}
	
	 @AfterMethod
	 public void tearDown()  {
	 driver.quit();
	}

}

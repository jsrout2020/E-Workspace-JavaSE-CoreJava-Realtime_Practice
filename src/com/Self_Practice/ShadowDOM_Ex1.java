package com.Self_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM_Ex1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\DriverFolder\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://books-pwakit.appspot.com/");
	WebElement root=driver.findElement(By.tagName("book-app"));
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	WebElement shadowDom1=(WebElement) js.executeScript("return arguments[0].shadowRoot", root);
	
	WebElement appheader= shadowDom1.findElement(By.tagName("app-header"));
	WebElement apptoolbar= appheader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
	WebElement bookInputDecorator=apptoolbar.findElement(By.tagName("book-input-decorator"));
	bookInputDecorator.findElement(By.cssSelector("input#input")).sendKeys("Testing");
	}

}

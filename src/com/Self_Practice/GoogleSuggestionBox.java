package com.Self_Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSuggestionBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\DriverFolder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("java");
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class='jKWzZXdEJWi__suggestions-inner-container']"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			String linkText=list.get(i).getText();
			System.out.println(linkText);
			if(linkText.contains("javascript")) {
				list.get(i).click();
				break;
			}
		}
		driver.close();
		}
}

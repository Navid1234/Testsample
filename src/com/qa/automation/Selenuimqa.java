package com.qa.automation;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenuimqa {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://dev.trackwalkins.com/");
		WebElement usern = driver.findElement(
				By.xpath("//input[@class='w-input-text form-input-text ng-touched ng-dirty ng-valid'](1)"));
		usern.click();
		driver.findElement(By.xpath("//input[@type='password']")).click();
		driver.findElement(By.xpath("//button[@class='mat-raised-button mat-primary mat-button']")).click();
		WebElement wb = driver.findElement(By.xpath(
				"//mat-expansion-panel[@class='custom-header mat-expansion-panel ng-tns-c17-39 ng-star-inserted']"));

		// ( mouse over operation )

		Actions act = new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//span[text()='Send SMS']")).click();
		driver.findElement(By.xpath("//div[@class='mat-radio-outer-circle']\")[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Select picture')]")).click();
		driver.findElement(By.xpath("//mat-icon[@class='folder mat-icon material-icons']")).click();

		// running Auto It script
		Runtime.getRuntime().exec("D:\\Fileuploadscript1.exe");

		driver.findElement(By.xpath("//span[contains(text(),'select')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Manual Post')]")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Mobile Number'])")).sendKeys("1234567891");
		driver.findElement(By.xpath("//button[contains(text(),'ADD NUMBERS')])")).click();
		// Drop down
		String expvalue = "template";
		boolean Flag = false;
		WebElement wb1 = driver.findElement(
				By.xpath("//div[@class='form-control']//div[@class='form-control']//select[@id='country'])"));
		Select sel = new Select(wb1);
		List<WebElement> lst = sel.getOptions();
		for (WebElement wbx : lst) {
			String actvalue = wbx.getText();
			if (expvalue.equals(actvalue)) {
				sel.selectByVisibleText(expvalue);
				Flag = true;
				break;
			}
		}
		if (Flag == true) {
			System.out.println(" the expected vlaue is available ===== Pass");
		} else {
			System.out.println(" the expected value is not available== Fail");
		}

		driver.findElement(By.xpath("//textarea[@class='ng-pristine ng-invalid ng-touched'])")).sendKeys("8618907606");
		driver.findElement(By.xpath("//span[contains(text(),'Send Now')])")).click();

		// pop up no
		Alert alt = driver.switchTo().alert();
		String str = alt.getText();
		System.out.println(" the pop up message is " + str);
		alt.dismiss();

		// SMS report
		WebElement smsreport = driver
				.findElement(By.xpath("//span[@class='color-blue-a800 header-title f-family-sans f-weight-bold'])"));
		Actions act1 = new Actions(driver);
		act.moveToElement(smsreport);
		act.perform();

		// identification of message in Table
		String exp1msg = "8618907606";
		// boolean Flag1= false;

		String x = " //table[@class='custom-mat-table mat-table-new mat-table']" + "//tr[1]//td[3]//div[1]//div[1] ";
		WebElement reportmsg = driver.findElement(By.xpath("x"));
		String act1msg = reportmsg.getText();
		if (act1msg.equals(exp1msg)) {
			System.out.println("the sms sended to customer is matched===== passs");
		} else {
			System.out.println(" the sms sended to customer  is not matched===Fail ");
		}

	}

}

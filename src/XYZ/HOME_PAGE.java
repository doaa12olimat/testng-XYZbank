package XYZ;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HOME_PAGE extends parameters {
	String[] NameCostomer = { "Rahaf", "DOAA", "LEEN", "RETAL" };

	@Test()
	public void t_01bankmanagementlogin() throws InterruptedException, IOException {
		
		// driver.manage().window().maximize();

		driver.findElement(
				By.xpath("//button[contains(@class, 'btn btn-primary btn-lg') and text() = 'Bank Manager Login']"))
				.click();
		Thread.sleep(3000);
		// add customer
		driver.findElement(By.xpath("//*[@class='ng-scope']//*[contains(text(), 'Add Customer')]/../button[1]"))
				.click();
		Thread.sleep(9000);

		for (int i = 0; i < 4; i++) {

			driver.findElement(By.xpath("//*[@type='submit']//preceding::input[3]")).sendKeys(NameCostomer[i]);
			driver.findElement(By.xpath("//*[@type='submit']//preceding::input[2]")).sendKeys("FERAS");
			driver.findElement(By.xpath("//*[@type='submit']//preceding::input[1]")).sendKeys("12345");
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			Thread.sleep(3000);

			Alert alert = driver.switchTo().alert();
			String Textonalert = alert.getText();
			Thread.sleep(3000);

			System.out.println(Textonalert);
			alert.accept();

		}

		Thread.sleep(3000);
		// driver.navigate().back();

	}
//test for open account
	@Test()
	public void t_02bankmanagementopenacount() throws InterruptedException, IOException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='ng-scope']//*[contains(text(), 'Add Customer')]/../button[2]"))
				.click();
		Thread.sleep(3000);
		for (int i = 0; i < 4; i++) {

			WebElement costomer = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));

			Select Drop = new Select(costomer);

			Drop.selectByVisibleText(NameCostomer[i] + " FERAS");

			WebElement Currency = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
			Select DropCurrency = new Select(Currency);
			DropCurrency.selectByValue("Dollar");
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
			Alert alert = driver.switchTo().alert();
			String Textonalert = alert.getText();
			Thread.sleep(3000);

			System.out.println(Textonalert);
			alert.accept();
		}

	}
// test for delete customer
	@Test()
	public void t_03bankmanagementdeletcostomer() throws InterruptedException, IOException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
		// screenshot before
		// delete
		Thread.sleep(9000);
		Date curentdate = new Date();
		System.out.println(curentdate);
		String screenfilename = curentdate.toString().replace(":", "-");
		String screenfilenamenew = screenfilename.substring(11, 19);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(".//screenshot//" + screenfilenamenew + ".png");
		FileUtils.copyFile(SrcFile, DestFile); // delete customer rahaf FERAS
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")).sendKeys("rahaf");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table"));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[5]/button"))
				.click();
		Thread.sleep(3000); // screenshot after delete
		Date curentdate1 = new Date();
		System.out.println(curentdate);
		String screenfilename1 = curentdate1.toString().replace(":", "-");
		String screenfilenamenew1 = screenfilename1.substring(11, 19);
		TakesScreenshot scrShot1 = ((TakesScreenshot) driver);
		File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1 = new File(".//screenshot//" + screenfilenamenew1 + ".png");
		FileUtils.copyFile(SrcFile1, DestFile1);

	}
//test for deposit
	@Test()
	public void t_04bankmanagementDeposit() throws InterruptedException, IOException {
		Thread.sleep(3000);//customer login
		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();
		Thread.sleep(3000);
		//enter name customer
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
		WebElement Your_Name = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select drop = new Select(Your_Name);
		int RandomNumber = rand.nextInt(500) % 6;
		String selectvalue = String.valueOf(RandomNumber);
		drop.selectByValue(selectvalue);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
		Thread.sleep(3000);
        //customer deposite 5000
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("5000");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		Thread.sleep(3000);
		Thread.sleep(3000); 
		Date curentdate1 = new Date();
		System.out.println(curentdate1);
		String screenfilename1 = curentdate1.toString().replace(":", "-");
		String screenfilenamenew1 = screenfilename1.substring(11, 19);
		TakesScreenshot scrShot1 = ((TakesScreenshot) driver);
		File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1 = new File(".//screenshot//" + screenfilenamenew1 + ".png");
		FileUtils.copyFile(SrcFile1, DestFile1);
		String Expected = "Deposit Successful";
		String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).getText();// get msg "Deposit Successful"
		myAssertion.assertEquals(actual, Expected);
		myAssertion.assertAll();
	}
//test for check lasttransaction
	@Test()
	public void t_05checklasttransaction() throws InterruptedException, IOException {
		Thread.sleep(3000);
//click on withdraw button
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("3000");//withdraw 3000
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
//click on transactions button
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]")).click();
		Thread.sleep(3000);
//takes screenshot
		Date curentdate = new Date();
		System.out.println(curentdate);
		String screenfilename = curentdate.toString().replace(":", "-");
		String screenfilenamenew = screenfilename.substring(11, 19);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(".//screenshot//" + screenfilenamenew + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
//check last transaction from table
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table"));
		String Expected = "Debit";
		String actual = driver.findElement(By.xpath("//*[@id=\"anchor1\"]/td[3]")).getText();

		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[2]")).click();

		myAssertion.assertEquals(actual, Expected);
		myAssertion.assertAll();
	}

}

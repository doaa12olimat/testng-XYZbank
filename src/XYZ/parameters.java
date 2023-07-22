package XYZ;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class parameters {
	// WebDriver driver=new EdgeDriver();
		SoftAssert myAssertion = new SoftAssert();
		 Random rand = new Random();
		 
	    WebDriver driver;
	    
		@BeforeTest
		public void mySetup() {

			
			  //*** this method How to solve the problem of inability to use Chrome *****
			  
			
			  ChromeOptions option = new ChromeOptions();
			  option.addArguments("--remote-allow-origins=*");
			  driver = new ChromeDriver(option);
			  
			  driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
			
			 
			  
		}

}

package commonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ERP_Functions {
    
	   WebDriver driver;
	   String res;
	
	public String launchApp(String url) throws Exception{
		
		System.setProperty("webdriver.gecko.driver", "F:\\Project\\Automation\\DataDriven\\CommonJars\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		if (driver.findElement(By.id("btnsubmit")).isDisplayed()) {
			res = "pass";

		} else {
			res = "fail";

		}

		return res;
	}

	// login method

	public String Login(String username, String password) {

		driver.findElement(By.id("btnreset")).click();

		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("btnsubmit")).click();

		if (driver.findElement(By.id("logout")).isDisplayed()) {
			res = "pass";

		} else {
			res = "fail";

		}

		return res;
	}

	// supplying data to suppliers

	public String supplier(String sname, String address, String city, String country, String cperson, String pnumber,
			String mail, String mnumber, String note) throws Exception {

		driver.findElement(By.linkText("Suppliers")).click();
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();

		String expdata = driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
		driver.findElement(By.id("x_Address")).sendKeys(address);
		driver.findElement(By.id("x_City")).sendKeys(city);
		driver.findElement(By.id("x_Country")).sendKeys(country);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
		driver.findElement(By.id("x_Phone_Number")).sendKeys(pnumber);
		driver.findElement(By.id("x__Email")).sendKeys(mail);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(mnumber);
		driver.findElement(By.id("x_Notes")).sendKeys(note);
		// driver.findElement(By.id("btnAction")).click();
		// done by keyboard
		driver.findElement(By.name("btnAction")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'OK!')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']")).click();
		Thread.sleep(3000);

		if (driver.findElement(By.id("psearch")).isDisplayed()) {

			driver.findElement(By.id("psearch")).clear();
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();
		} else {

			driver.findElement(By.xpath("//button[@data-caption='Search Panel']/span")).click();
			driver.findElement(By.id("psearch")).clear();
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();

		}

		String actdata = driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();

		if (expdata.equalsIgnoreCase(actdata)) {
			res = "pass";
		} else {
			res = "fail";
		}

		return res;

	}

	public String logout() throws Exception {
		driver.findElement(By.xpath("//*[@id='logout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'OK!')]")).click();

		if (driver.findElement(By.id("btnsubmit")).isDisplayed()) {
			res = "pass";
		} else {
			res = "fail";
		}
		driver.close();
		return res;
	}

}
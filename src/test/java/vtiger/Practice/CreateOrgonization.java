package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgonization {

	public static void main(String[] args) {
		//1.launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		//2.login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//3.navigate to orgonization link
		driver.findElement(By.linkText("Organizations")).click();
		//4.click on create orgonizations look up image and fill fields
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("QSpiders");
		//5.save
		driver.findElement(By.name("button")).click();
		//6.logout
		WebElement out = driver.findElement(By.xpath("(//td[@class='small']//img)[1]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(out).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}

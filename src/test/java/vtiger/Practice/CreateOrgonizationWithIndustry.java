package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgonizationWithIndustry {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Apollo");
		WebElement drop = driver.findElement(By.xpath("//select[@name='industry']"));
		Select select=new Select(drop);
		select.selectByValue("Healthcare");
		driver.findElement(By.name("button")).click();

		WebElement out = driver.findElement(By.xpath("(//td[@class='small']//img)[1]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(out).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	}

}

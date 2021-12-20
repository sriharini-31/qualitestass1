package qualitest;

import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "D:\\");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		exerciseOne(driver);
		exerciseTwo(driver);
		exerciseThree(driver);
		exerciseFour(driver);
		exerciseFourPointOne(driver);
		exerciseFourPointTwo(driver);
		exericseFive(driver);
		exerciseSix(driver);
		exericseSeven(driver);
		exericseEight(driver);
		exerciseNine(driver);

	}

	public static void exerciseOne(WebDriver driver) {

		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
	}

	public static void exerciseTwo(WebDriver driver) throws InterruptedException {
		// driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("United States");
		Thread.sleep(2000);
		List<WebElement> countries = (List<WebElement>) driver.findElements(By.xpath("//ui/li[@class='ui-menu-item']"));
		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("United States Minor Outlying Islands")) {
				country.click();
				break;
			}
		}
		if (driver.findElement(By.id("autocomplete")).getAttribute("value")
				.equalsIgnoreCase("United States Minor Outlying Islands")) {
			System.out.println(driver.findElement(By.id("autocomplete")).getText());
		}
	}

	public static void exerciseThree(WebDriver driver) throws InterruptedException {

		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));

		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		dropdown.selectByIndex(2);
		// dropdown.selectByVisibleText("option2");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		dropdown.selectByIndex(3);
		// dropdown.selectByVisibleText("option3");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

	public static void exerciseFour(WebDriver driver) {

		boolean option1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected();
		if (option1 == false)
			driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();

		boolean option1option1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected();
		if (option1option1 == true)
			driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();

		boolean option2 = driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected();
		if (option2 == false)
			driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();

		boolean option2option2 = driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected();
		if (option2option2 == true)
			driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();

		boolean option3 = driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).isSelected();
		if (option3 == false)
			driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();

		boolean option3option3 = driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).isSelected();
		if (option3option3 == true)
			driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
	}

	public static void exerciseFourPointOne(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		Thread.sleep(2000);
	}

	public static void exerciseFourPointTwo(WebDriver driver) {
		WebElement ckbox1 = driver.findElement(By.id("checkBoxOption1"));
		System.out.println(ckbox1.isSelected());
		ckbox1.click();
		WebElement ckbox2 = driver.findElement(By.id("checkBoxOption2"));
		System.out.println(ckbox2.isSelected());
		ckbox2.click();
		WebElement ckbox3 = driver.findElement(By.id("checkBoxOption3"));
		System.out.println(ckbox3.isSelected());
		ckbox3.click();
	}

	public static void exericseFive(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("openwindow")).click();
		System.out.println(driver.findElement(By.id("openwindow")).isDisplayed());
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		System.out.println(driver.findElement(By.id("openwindow")).getText());
	}

	public static void exerciseSix(WebDriver driver) throws InterruptedException {

		System.out.println(driver.findElement(By.id("opentab")).isSelected());
		driver.findElement(By.id("opentab")).click();
		System.out.println(driver.findElement(By.id("opentab")).isDisplayed());
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(winHandleBefore);

		System.out.println(driver.findElement(By.id("opentab")).getText());
	}

	public static void exericseSeven(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("name")).sendKeys("John");
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
	}

	public static void exericseEight(WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950);");
	
	}

	public static void exerciseNine(WebDriver driver) throws InterruptedException {
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
		System.out.println("Text obtained by scrolling down is :" + act);
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.cssSelector("#mousehover"))).build().perform();
		driver.findElement(By.cssSelector("#mousehover")).click();
		System.out.println("Text obtained by scrolling up is :" + act);
}
}

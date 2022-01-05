import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class finalProjectTest {

    WebDriver driver;

    public finalProjectTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test

    public void register() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to("http://tutorialsninja.com/demo/");
        WebElement myAccount = driver.findElement(By.className("fa-user"));
        myAccount.click();
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("test");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("test");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='E-Mail' and @class='form-control']"));
        email.sendKeys("test@gmail.com");
        WebElement telephone = driver.findElement(By.cssSelector("#input-telephone"));
        telephone.sendKeys("test");
        WebElement password = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
        password.sendKeys("test");
        WebElement confirmPassword = driver.findElement(By.name("confirm"));
        confirmPassword.sendKeys("test");
        WebElement subscribe = driver.findElement(By.xpath("//*[1][@class='radio-inline']/input"));
        js.executeScript("arguments[0].checked=true",subscribe);
        WebElement agree = driver.findElement(By.cssSelector("input[name='agree']"));
        agree.click();
        WebElement continueElement = driver.findElement(By.cssSelector(".btn-primary:empty"));
        continueElement.click();
    }

    @Test

    public void task2() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location= 'http://tutorialsninja.com/demo/index.php?route=product/category&path=24' ");
        WebElement phones = driver.findElement(By.cssSelector("a[href$='path=24']"));
        phones.click();
        WebElement telephone = driver.findElement(By.xpath("//img[@title='Palm Treo Pro']"));
        action.moveToElement(telephone).perform();
        String expectedValue = "Palm Treo Pro";
        String actualValue =  telephone.getAttribute("title");
        if(expectedValue.equalsIgnoreCase(actualValue)) {
            System.out.println("test passed.. tooltip is: " + actualValue);
        } else {
            System.out.println("its not same,here is tooltip: " + actualValue);
        }
        

        driver.quit();
    }


}

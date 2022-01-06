import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebElement subscribe = driver.findElement(By.xpath("//*[@class='radio-inline']/input[@value='1']"));
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
        WebElement palmTreoPhone = driver.findElement(By.xpath("//img[@alt='Palm Treo Pro']"));
        palmTreoPhone.click();
    }

    @Test

    public void task3() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location= 'http://tutorialsninja.com/demo/index.php?route=product/product&path=24&product_id=29'");
        WebElement phoneImage = driver.findElement(By.cssSelector(".thumbnails li:first-child"));
        phoneImage.click();
        WebElement text = driver.findElement(By.className("mfp-counter"));
        String expectedText = "3 of 3";
        String actualText = js.executeScript("return document.getElementsByClassName('mfp-counter')[0].innerHTML").toString();
        while(!expectedText.equalsIgnoreCase(actualText)) {
            WebElement image = driver.findElement(By.className("mfp-img"));
            WebDriverWait wait = new WebDriverWait(driver,3);
            wait.until(ExpectedConditions.elementToBeClickable(image));
            image.click();
            actualText = js.executeScript("return document.getElementsByClassName('mfp-counter')[0].innerHTML").toString();
        }
        WebElement close = driver.findElement(By.className("mfp-close"));
        close.click();
        WebElement review = driver.findElement(By.xpath("//a[starts-with(text(),'Write')]"));
        review.click();
        WebElement name = driver.findElement(By.id("input-name"));
        name.sendKeys("test");
        WebElement Writereview = driver.findElement(By.id("input-review"));
        Writereview.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        WebElement rating = driver.findElement(By.xpath("//input[@name='rating'][@value='3']"));
        rating.click();
//        WebElement form = driver.findElement(By.id("form-review"));
//        form.submit();
        WebElement submit = driver.findElement(By.id("button-review"));
        submit.click();

        driver.quit();
    }


}

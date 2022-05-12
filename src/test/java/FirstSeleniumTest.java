import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {
    private static final String HOME_PAGE_URL = "https://www.facebook.com/";

    private static WebDriver driver;

    @BeforeAll
    public static void classSetup(){
     driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown(){
        SharedDriver.closeDriver();

    }
    @AfterEach
    public void testTearDown(){
        driver.get(HOME_PAGE_URL);

    }

    @Test
    public void homePageURLTest() {

        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "URLs do not match");


    }
    @Test
    public void findEmailFieldTest(){

        //WebElement element = driver.findElement(By.id("email"));
      //  WebElement element = driver.findElement(By.name("email"));
       // WebElement element = driver.findElement(By.linkText("Create a Page"));
      //  WebElement element = driver.findElement(By.partialLinkText("a Page"));
      //  WebElement element = driver.findElement(By.cssSelector("#email"));
        //WebElement element = driver.findElement(By.className("inputtext"));
      List<WebElement> element = driver.findElements(By.className("inputtext"));
        System.out.println(element.size());

        assertNotNull(element);
    }
    @Test
    public void findElementsByXpathTest(){
     WebElement emailElement   =  driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);

        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
        WebElement forgotPassElement = driver.findElement(By.xpath("//a[text()='Forgot password?']"));
        assertNotNull(forgotPassElement);
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
    }

    @Test
    public void loginScreenTest(){
        WebElement emailElement   =  driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("Lubkinenator@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("Lubkinenator@gmail.com", emailValue);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testId='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("123456");
        String passValue = passwordElement.getAttribute("value");
        assertEquals("123456", passValue);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);

        loginButtonElement.click();

    }

    @Test
    public void findElemByXpathTest() throws Exception{
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        createNewAccButton.click();
        Thread.sleep(2000);
        WebElement firstNameElement  = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameElement);
        WebElement lastNameElement  = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        WebElement mobileNumberOrEmailNameElement  = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobileNumberOrEmailNameElement);
        WebElement NewPasswordElement  = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(NewPasswordElement);
        WebElement SignUpElement  = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(SignUpElement);




    }
    @Test
    public void createNewAccountUnitTest() throws InterruptedException {

        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        createNewAccButton.click();
        Thread.sleep(1000);
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("Lu");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Lu", firstNameValue);
        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Lazovsky");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Lazovsky", lastNameValue);
        WebElement mobileNumberOrEmailNameElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobileNumberOrEmailNameElement);
        mobileNumberOrEmailNameElement.sendKeys("lubkinenator@gmail.com");
        String mobileNameOrEmailNameValue = mobileNumberOrEmailNameElement.getAttribute("value");
        assertEquals("lubkinenator@gmail.com", mobileNameOrEmailNameValue);
        WebElement NewPasswordElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(NewPasswordElement);
        NewPasswordElement.sendKeys("D1234567");
        String NewPasswordValue = NewPasswordElement.getAttribute("value");
        assertEquals("D1234567", NewPasswordValue);

        WebElement SignUpElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(SignUpElement);

        SignUpElement.click();
    }


}








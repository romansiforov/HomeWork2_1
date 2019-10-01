import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomeWork2_1 {

    WebDriver driver;
    final static String BASE_URL = "http://automationpractice.com";
    final static String PATH_TO_DRIVER = "C:\\Users\\roman\\IdeaProjects\\SeleniumHomework\\src\\main\\resources\\Drivers\\chromedriver.exe";

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void hometask1 (){
        String testMail = "roman@defentry.com";
        String testName = "Roman";
        String testLastName = "Siforov";
        String testPassword = "12345";
        String testCity = "Kiev";
        String testPhone = "+380501112233";

        driver.navigate().to(BASE_URL);  // open the site http://automationpractice.com
        driver.findElement(By.xpath("//a[@class='login']")).click(); // click the Sign in button
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(testMail); //fill the Email field with correct value
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click(); //click the create button
        driver.findElement(By.xpath("//div[@class = 'required form-group']/input[@id='customer_firstname']")).sendKeys(testName); //fill the Name field
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(testLastName); // fill the Last Name field
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(testPassword); // fill the password field
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(testCity); //fill the City field
        driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys(testPhone); //fill the Mobile phone field
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        String actualErrorText = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
        String expectedErrorText = "There are 3 errors";

        Assert.assertEquals("The error message is not match to the current situation", expectedErrorText, actualErrorText);

    }
    @After
    public void dint(){
        driver.quit();
    }
}

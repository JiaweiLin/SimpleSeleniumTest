/**
 * Workshop on Automation with Selenium
 * Created by Jiawei on 29/8/15.
 */
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTest
{
    WebDriver driverFireFox;

    @Before
    public void beforeTest()
    {
        driverFireFox = new FirefoxDriver();
        driverFireFox.get("http://goo.gl/zgGE1S");
    }

    @After
    public void after()
    {
        driverFireFox.quit();
    }

    @Test
    public void checkSuccessMessage()
    {
        driverFireFox.findElement(By.id("entry_1026726585")).sendKeys("abcd");
        driverFireFox.findElement(By.id("entry_1653638531")).sendKeys("QA");
        driverFireFox.findElement(By.id("group_213245409_1")).click();
        driverFireFox.findElement(By.id("group_929635229_1")).click();
        driverFireFox.findElement(By.id("ss-submit")).click();

        Assert.assertEquals("Test Failed", "Thank you for time. Soon, we will let you know about the next meetup.", driverFireFox.findElement(By.className("ss-resp-message")).getText());
    }

    @Test
    public void checkNameRequiredField()
    {
        driverFireFox.findElement(By.id("ss-submit")).click();

        Assert.assertEquals("Test Failed", "*Required", driverFireFox.findElement(By.className("ss-required-asterisk")).getText());
    }
}

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class CheckCSSSRLink {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSwitchToMonosnap() {
        driver.get("http://blog.csssr.ru/qa-engineer/");
        driver.findElement(By.xpath("/html/body/div[1]/section[1]/section/div[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[2]/aside/ul/li[4]/label/a")).click();
        ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        Assert.assertTrue(driver.getCurrentUrl().equals("http://monosnap.com/"));

    }

    @After
    public void closeWeb() {
        driver.quit();


    }
}


package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenOurEdu {
    public static WebDriver driver = null;
    @Before
    public void open()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        String sitePath = "https://frontend.oetest.tech/ar/user/login";
        driver.navigate().to(sitePath);
        driver.manage().window().maximize();
    }
    @After
    public void close()
    {
        driver.quit();
    }
}

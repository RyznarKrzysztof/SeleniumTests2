import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/");
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}

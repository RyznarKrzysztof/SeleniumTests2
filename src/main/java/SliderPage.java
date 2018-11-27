import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SliderPage extends BasePage{

    public SliderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        //metoda initElements odpowiada za inicjalizacje wszystkich elementów oznaczonych przy pomocy @FindBy
    }

    @FindBy(className = "demo-frame")
    private WebElement frame;

    @FindBy(css = "div[class='demo-list'] a[href='/resources/demos/slider/custom-handle.html']")
    private WebElement customHandle;

    @FindBy(css = "div[id='custom-handle']")
    private WebElement customSlider;

    public SliderPage switchToFrame(){
        waitForElementToBeClickable(frame);
        driver.switchTo().frame(frame);
        return this;
    }

    public SliderPage moveSlider(int value) {
        waitForElementToBeClickable(customSlider);
        if (Integer.parseInt(customSlider.getText()) < value) {
            while (Integer.parseInt(customSlider.getText()) != value) {
                customSlider.sendKeys(Keys.ARROW_RIGHT);
            }
            assertSliderPosition(Integer.toString(value), customSlider.getText());
        } else {
            while (Integer.parseInt(customSlider.getText()) != value) {
                customSlider.sendKeys(Keys.ARROW_LEFT);
            }
            assertSliderPosition(Integer.toString(value), customSlider.getText());
        }
        return this;
    }

    public SliderPage clickCustomHandle(){
        waitForElementToBeClickable(customHandle);
        customHandle.click();
        return this;
    }

    public void assertSliderPosition(String desired, String actual){
        Assert.assertEquals(desired, actual);
    }



}

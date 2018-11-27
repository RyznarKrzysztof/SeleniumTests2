import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DroppablePage extends BasePage{

    Actions action;

    public DroppablePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        //metoda initElements odpowiada za inicjalizacje wszystkich elementów oznaczonych przy pomocy @FindBy
    }

    @FindBy(className = "demo-frame")
    private WebElement frame;

    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = "droppable")
    private WebElement droppable;

    public DroppablePage switchToFrame(){
        waitForElementToBeClickable(frame);
        driver.switchTo().frame(frame);
        return this;
    }

    public DroppablePage moveDragableToDropable(){
        action = new Actions(driver);
        action.dragAndDrop(draggable, droppable).perform();
        return this;
    }

    public DroppablePage assertDragableInDropable(){
        Assert.assertEquals(droppable.getText(), "Dropped!");
        return this;
    }

}

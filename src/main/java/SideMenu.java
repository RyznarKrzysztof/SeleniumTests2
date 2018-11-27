import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu extends BasePage{

    public SideMenu(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        //metoda initElements odpowiada za inicjalizacje wszystkich elementów oznaczonych przy pomocy @FindBy
    }

    @FindBy(css = "div[id='sidebar'] a[href='https://jqueryui.com/droppable/']")
    private WebElement droppableFromSideMenu;

    @FindBy(css = "div[id='sidebar'] li a[href='https://jqueryui.com/slider/']")
    private WebElement sliderFromSideMenu;

    @FindBy(css = "div[id='sidebar'] li a[href='https://jqueryui.com/datepicker/']")
    private WebElement datepickerFromSideMenu;

    public void clickSliderFromSideMenu(){
        waitForElementToBeClickable(sliderFromSideMenu);
        sliderFromSideMenu.click();
    }

    public void clickDroppableFromSideMenu(){
        waitForElementToBeClickable(droppableFromSideMenu);
        droppableFromSideMenu.click();
    }

    public void clickDatepickerFromSideMenu(){
        waitForElementToBeClickable(datepickerFromSideMenu);
        datepickerFromSideMenu.click();
    }



}

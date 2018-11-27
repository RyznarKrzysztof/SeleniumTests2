import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu {

    WebDriver driver;

    public MainMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //metoda initElements odpowiada za inicjalizacje wszystkich elementów oznaczonych przy pomocy @FindBy
    }

    @FindBy(linkText = "Demos")
    private WebElement demos;

    public void goDemoPage(){
        demos.click();
    }

}

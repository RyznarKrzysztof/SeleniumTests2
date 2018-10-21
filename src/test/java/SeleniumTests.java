import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTests extends BasicTest {



    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropable = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        action.dragAndDrop(draggable, dropable).perform();

        Assert.assertEquals(dropable.getText(), "Dropped!");

        Thread.sleep(4000);

    }

    @Test
    public void moveSlider() throws InterruptedException {

        driver.get("https://jqueryui.com/slider/#custom-handle");

        driver.switchTo().frame(0);
        WebElement slider = driver.findElement(By.id("custom-handle"));

        int i = 80;
        if (Integer.parseInt(slider.getText()) < i) {
            while (Integer.parseInt(slider.getText()) != i) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            }
        } else {
            while (Integer.parseInt(slider.getText()) != i) {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }

        Thread.sleep(4000);
    }



}

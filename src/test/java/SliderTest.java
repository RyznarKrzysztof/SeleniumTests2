import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    @Test
    public void sliderTest(){

        SideMenu sideMenu = new SideMenu(driver);
        SliderPage sliderPage = new SliderPage(driver);

        sideMenu.clickSliderFromSideMenu();

        sliderPage.clickCustomHandle()
                  .switchToFrame()
                  .moveSlider(80)
                  .moveSlider(50)
                  .moveSlider(55)
                  .moveSlider(55);
    }
}

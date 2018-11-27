import org.testng.annotations.Test;

public class CalendarTest extends BaseTest{


    @Test
    public void testCalendar() {

        SideMenu sideMenu = new SideMenu(driver);
        CalendarPage calendarPage = new CalendarPage(driver);

        sideMenu.clickDatepickerFromSideMenu();

        calendarPage.clickOtherMonths()
                    .switchToFrame()
                    .clickDatepicker()
                    .selectDate(30, 06, 2018);
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CalendarPage extends BasePage{

    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                       "October", "November", "December"};

    public CalendarPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/resources/demos/datepicker/other-months.html']")
    private WebElement otherMonths;

    @FindBy(className = "demo-frame")
    private WebElement frame;

    @FindBy(css = "input[id='datepicker']")
    private WebElement datepickerInput;

    @FindBy(css = "div[class='ui-datepicker-title'] span[class='ui-datepicker-year']")
    private WebElement yearContainer;

    @FindBy(css = "div[class='ui-datepicker-title'] span[class='ui-datepicker-month']")
    private WebElement monthContainer;

    @FindBy(css = "table[class='ui-datepicker-calendar'] tbody tr td")
    private List<WebElement> daysContainer;

    @FindBy(css = ".ui-datepicker-prev span")
    private WebElement calendarPreviousArrow;

    @FindBy(css = ".ui-datepicker-next span")
    private WebElement calendarNextArrow;

    public CalendarPage clickOtherMonths(){
        waitForElementToBeVisible(otherMonths);
        otherMonths.click();
        return this;
    }

    public CalendarPage switchToFrame(){
        waitForElementToBeVisible(frame);
        driver.switchTo().frame(frame);
        return this;
    }

    public CalendarPage clickDatepicker(){
        waitForElementToBeClickable(datepickerInput);
        datepickerInput.click();
        return this;
    }

    public CalendarPage clickNextOnCalendar(){
        waitForElementToBeClickable(calendarNextArrow);
        calendarNextArrow.click();
        return this;
    }

    public CalendarPage clickPreviousOnCalendar(){
        waitForElementToBeClickable(calendarPreviousArrow);
        calendarPreviousArrow.click();
        return this;
    }

    public CalendarPage selectDate(int day, int month, int year){

        selectYear(year);
        selectMonth(month);
        selectDay(day);
        return this;
    }

    public void selectYear(int year){
        waitForElementToBeVisible(yearContainer);
        if(year > Integer.parseInt(yearContainer.getText())){
            while(Integer.parseInt(yearContainer.getText()) != year){
                clickNextOnCalendar();
            }
        }else {
            while(Integer.parseInt(yearContainer.getText()) != year){
                clickPreviousOnCalendar();
            }
        }
    }

    public void selectMonth(int month) {
        String monthToSet = months[month-1];
        String actualMonth = monthContainer.getText();
        int numberOfActualMonth = getMonthsNumber(actualMonth);

        if(month > numberOfActualMonth){
            while(!actualMonth.equals(monthToSet)){
                clickNextOnCalendar();
                actualMonth = monthContainer.getText();
            }
        }else {
            while(!actualMonth.equals(monthToSet)){
                clickPreviousOnCalendar();
                actualMonth = monthContainer.getText();
            }
        }
    }

    public void selectDay(int day){
        List<WebElement> tmpList = new ArrayList<WebElement>();

        if (day < 25){
            for(WebElement weDay : daysContainer){
                if (weDay.getText().equals(Integer.toString(day))){
                    weDay.click();
                }
            }
        }else {

            for(WebElement weDay : daysContainer){
                if (weDay.getText().equals(Integer.toString(day))){
                    tmpList.add(weDay);
                }
            }
        }
        tmpList.get(1).click();
    }

    public int getMonthsNumber(String monthName){
        for(int i = 0; i < months.length; i++){
            if (months[i].equalsIgnoreCase(monthName)){
                return i+1;
            }
        }
        return -1;
    }
}

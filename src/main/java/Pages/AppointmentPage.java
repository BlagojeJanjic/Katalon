package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AppointmentPage extends BasePage {
    private By facilitySelect = By.id("combo_facility");
    private By applyForHospitalReadmision = By.id("chk_hospotal_readmission");
    private By healthcareProgram = By.xpath("//*[@name='programs'][@value='\"+ Medicare +\"']");
    private By visitDateInput = By.id("txt_visit_date");
    private By commentInput = By.id("txt_comment");
    private By bookAppointmentButton = By.id("btn-book-appointment");
    private By appointmentConfirmation = By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2");



    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public boolean isFormPresented() {
        List<WebElement> elements = getDriver().findElements(By.id("appointment"));
        if (elements.size() == 0) {
            return false;
        }
        return true;
    }

    public void facility(int index) {
        Select dropdown = new Select(getDriver().findElement(facilitySelect));
        dropdown.selectByIndex(index);
    }

    public void healthCareProgram() {
        WebElement button1 = getDriver().findElement(By.id("radio_program_medicare"));
        WebElement button2 = getDriver().findElement(By.id("radio_program_medicaid"));
        WebElement button3 = getDriver().findElement(By.id("radio_program_none"));
        button1.click();

    }

    public boolean isAppointmentConfirmationDisplayed() {
        return getDriver().findElement(appointmentConfirmation).isDisplayed();
    }


    public void setUpAppointmentForm() {
        facility(0);
        getDriver().findElement(applyForHospitalReadmision).click();
        healthCareProgram();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(visitDateInput).sendKeys("21/09/2020");
        getDriver().findElement(bookAppointmentButton).click();


    }
}

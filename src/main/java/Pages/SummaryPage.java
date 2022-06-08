package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {
    private By facilitySummaryPage = By.id("facility");
    private By applyForHospitalReadmisionSummaryPage = By.id("hospital_readmission");
    private By healthCareProgramSummaryPage = By.id("program");
    private By visitDateSummaryPage = By.id("visit_date");
    private By commentSummaryPage = By.xpath("//*[@id=\"summary\"]/div/div/div[6]/div[2]");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String facilityText() {
        return getDriver().findElement(facilitySummaryPage).getText();
    }

    public String applyText() {
        return getDriver().findElement(applyForHospitalReadmisionSummaryPage).getText();
    }

    public String dateText() {
        return getDriver().findElement(visitDateSummaryPage).getText();
    }
}

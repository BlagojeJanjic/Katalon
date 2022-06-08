package Tests;

import Pages.AppointmentPage;
import Pages.LoginPage;
import Pages.SummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);

    }


    @Test (priority = 1)
    public void loginTest() {
        loginPage.login();
        loginPage.clickLoginButton();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test (priority = 2)
    public void appointment() {
        appointmentPage.setUpAppointmentForm();
        Assert.assertTrue(appointmentPage.isAppointmentConfirmationDisplayed());
    }

    @Test (priority = 3)
    public void confirmation() {
        Assert.assertEquals(summaryPage.facilityText(), "Tokyo CURA Healthcare Center");
        Assert.assertEquals(summaryPage.applyText(), "Yes");
        Assert.assertEquals(summaryPage.dateText(), "21/09/2020");
    }

    @AfterClass
    public void close() {
        driver.close();
    }
}

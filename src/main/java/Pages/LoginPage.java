package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void enterUsername() {
        getDriver().findElement(username).sendKeys("John Doe");
    }

    public void enterPassword() {
        getDriver().findElement(password).sendKeys("ThisIsNotAPassword");
    }

    public void login() {
        setUp();
        clearField(this.username);
        enterUsername();
        clearField(this.password);
        enterPassword();
    }

    public void clickLoginButton() {
        getDriver().findElement(loginButton).click();
    }


}

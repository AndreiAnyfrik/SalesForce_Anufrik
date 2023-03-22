package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;
@Log4j2
public class AccountsPage extends BasePage {

    public static final String ACCOUNTS_PAGE_PATH = "/lightning/o/Account/list?filterName=Recent";

    private By ACCOUNTS_TITLE_LOCATOR = By.xpath("//span[text()='Accounts' and @class='slds-var-p-right_x-small']");
    private By NEW_BTN_LOCATOR = By.xpath("//div[@title='New']");
    private By DELETE_OPTION_LOCATOR = By.xpath("//div[@title='Delete']");
    private static final Logger log = LogManager.getLogger(AccountsPage.class);

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url") + ACCOUNTS_PAGE_PATH);
        waitForPageLoaded();
        return this;
    }

    public AccountsPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNTS_TITLE_LOCATOR));
        return this;
    }

    public NewAccountModalPage createNewAccount() {
        driver.findElement(NEW_BTN_LOCATOR).click();
        return new NewAccountModalPage(driver);
    }

    public AccountsPage deleteAccount(String accountName) {
        log.info("Account {} will be deleted", accountName);
        WebElement showActionsArrow = this.driver.findElement(By.xpath(String.format("//a[text()='%s']//ancestor::tr//span[text()='Show Actions']", accountName)));
        this.jsClick(showActionsArrow);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.DELETE_OPTION_LOCATOR));
        WebElement deleteOption = this.driver.findElement(this.DELETE_OPTION_LOCATOR);
        this.jsClick(deleteOption);
        return this;
    }

    private void jsClick(WebElement element) {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].click();", new Object[]{element});
    }
}

package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.wrapper.FormattedText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage extends BasePage {

    private final By accCreationToastMsgLocator = By.xpath("//span[contains(@class,'toastMessage')]");
    private final By accName = By.xpath("//span[text()='Account Name']//ancestor::records-record-layout-item//lightning-formatted-text");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AccountDetailsPage waitForAccountCreationNotificationDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accCreationToastMsgLocator));
        return this;
    }

    public WebElement getAccountCreationNotification() {
        return driver.findElement(accCreationToastMsgLocator);
    }
    public AccountDetailsPage checkAccountsPage() {
        driver.findElement(By.xpath(String.valueOf((accName))));
        return this;
    }

    public String getAccountInformation(String label) {
        return new FormattedText(driver, label).getText();
    }
}

package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsPage extends BasePage {

    private final By contCreationToastMsgLocator = By.xpath("//span[contains(@class,'toastMessage')]");
    private final By accName = By.xpath("//span[text()='Account Name']//ancestor::records-record-layout-item//lightning-formatted-text");

    private final By lastName = By.xpath("//span[text()='Name']//ancestor::records-record-layout-item//span[contains(@class, 'test-id__field-value')]");
    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }
    public ContactDetailsPage waitForContactCreationNotificationDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contCreationToastMsgLocator));
        return this;
    }
    public ContactDetailsPage checkContactsPage() {
        driver.findElement(By.xpath(String.valueOf((accName))));
        return this;
    }

    public ContactDetailsPage checkContactsNamePage() {
        driver.findElement(By.xpath(String.valueOf(lastName);
        return this;
    }

    public WebElement getContactCreationNotification() {
        return driver.findElement(contCreationToastMsgLocator);
    }
}

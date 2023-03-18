package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class ContactPage extends BasePage {
    public static final String CONTACTS_PAGE_PATH = "/lightning/o/Contact/list?filterName=Recent";

    private By CONTACTS_TITLE_LOCATOR = By.xpath("//span[text()='Contacts' and @class='slds-var-p-right_x-small']");
    private By NEW_BTN_LOCATOR = By.xpath("//div[@title='New']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url") + CONTACTS_PAGE_PATH);
        waitForPageLoaded();
        return this;
    }

    public ContactPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACTS_TITLE_LOCATOR));
        return this;
    }

    public NewContactModalPage createNewContact() {
        driver.findElement(NEW_BTN_LOCATOR).click();
        return new NewContactModalPage(driver);
    }
}

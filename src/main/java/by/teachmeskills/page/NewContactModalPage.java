package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.wrapper.ComboBox;
import by.teachmeskills.wrapper.ContactLabel;
import by.teachmeskills.wrapper.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewContactModalPage extends BasePage {

    public static final By SAVE_BUTTON = By.xpath("//button[text()='Save']");
    public static final By CANCEL = By.xpath("//button[text()='Cancel']");
    public static final By SAVE_AND_NEW_BUTTON = By.xpath("//button[text()='Save & New']");

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }
    public ContactDetailsPage createNewContactWithRequiredFields(String accountName,String lastName) {
        new ContactLabel(driver, "Last Name").fillIn(lastName);
        new ComboBox(driver,"Account Name").select(accountName);
        driver.findElement(SAVE_BUTTON).click();
        return new ContactDetailsPage(driver);
    }
}

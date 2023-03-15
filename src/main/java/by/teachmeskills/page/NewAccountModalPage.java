package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.wrapper.DropDown;
import by.teachmeskills.wrapper.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends BasePage {

    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");
    public static final By CANCEL = By.xpath("//button[@title='Cancel']");
    public static final By SAVE_AND_NEW_BUTTON = By.xpath("//button[@title='Save & New']");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public AccountDetailsPage createNewAccountWithAccountName(String accountName) {
        new Input(driver, "Account Name").fillIn(accountName);
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
    public AccountDetailsPage createNewAccountWithAllFields(String accountName, String type, String industry, String phone) {
        new Input(driver, "Account Name").fillIn(accountName);
        new Input(driver, "Account Information").fillIn(phone);
        new DropDown(driver, "Type").select(type);
        new DropDown(driver, "Industry").select(industry);
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
}

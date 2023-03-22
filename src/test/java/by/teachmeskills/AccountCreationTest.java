package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.page.AccountDetailsPage;
import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.wrapper.Input;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountCreationTest extends BaseTest {

    @Test
    public void checkAccountCreation() {
        new LoginPage(driver).open()
                .login()
                .waitForPageOpening();
        String accountName = faker.name().fullName();
        AccountDetailsPage accDetailsPage = new AccountsPage(driver).open()
                .waitForPageOpening()
                .createNewAccount()
                .createNewAccountWithAccountName(accountName)
                .waitForAccountCreationNotificationDisplayed();
        WebElement accountCreationNotification = accDetailsPage.getAccountCreationNotification();
        assertThat(accountCreationNotification.isDisplayed()).as("Notification message should be shown after " +
                "account was created");

        String message = accountCreationNotification.getText();
        assertThat(message).as("Notification does not contain account name")
                .contains(accountName);

        String actualAccountName = accDetailsPage.getAccountName();
        assertThat(actualAccountName).as("").isEqualTo(accountName);
    }
    @Test
    public void createAccountWithAllFields() {

        Account expAccount = Account.builder()
                .accountName(faker.name().fullName())
                .phone(faker.phoneNumber().cellPhone())
                .build();
    }
}

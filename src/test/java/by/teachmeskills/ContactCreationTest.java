package by.teachmeskills;

import by.teachmeskills.page.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactCreationTest extends BaseTest{
    @Test
    public void checkContactCreationWithRequiredFields() {
        new LoginPage(driver).open()
                .login()
                .waitForPageOpening();
        String accountName = "a";
        String lastName = faker.name().lastName();
        ContactDetailsPage contactDetailsPage = new ContactPage(driver).open()
                .waitForPageOpening()
                .createNewContact()
                .createNewContactWithRequiredFields(accountName,lastName)
                .waitForContactCreationNotificationDisplayed();
        WebElement contactCreationNotification = contactDetailsPage.getContactCreationNotification();
        assertThat(contactCreationNotification.isDisplayed()).as("Notification message should be shown after"
                + "account was created");

        String message = contactCreationNotification.getText();
        assertThat(message).as("Notification does not contain contact name").contains(accountName);
    }
}

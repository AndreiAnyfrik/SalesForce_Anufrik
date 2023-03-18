package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactLabel {
    private WebDriver driver;
    private String inputLabel;
    private static final String LABEL_LOCATOR = "//label[text()='%s']//ancestor::lightning-input//input";

    public ContactLabel (WebDriver driver, String inputLabel) {
        this.driver = driver;
        this.inputLabel = inputLabel;
    }
    public void fillIn(String value) {
        driver.findElement(By.xpath(String.format(LABEL_LOCATOR, inputLabel))).sendKeys(value);
    }
}


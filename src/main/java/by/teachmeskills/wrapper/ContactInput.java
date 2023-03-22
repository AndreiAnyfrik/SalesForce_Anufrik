package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactInput {
    private WebDriver driver;
    private String inputLabel;
    private static final String INPUT_LOCATOR = "//label[text()='%s']//ancestor::div[@part='input-text']//input";

    public ContactInput (WebDriver driver, String inputLabel) {
        this.driver = driver;
        this.inputLabel = inputLabel;
    }
    public void fillIn(String value) {
        driver.findElement(By.xpath(String.format(INPUT_LOCATOR, inputLabel))).sendKeys(value);
    }
}


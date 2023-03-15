package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Div {
    private WebDriver driver;
    private String divLabel;
    private static final String DIV_LOCATOR = "//span[text()='%s']//ancestor::div[@class='form-element__row'] //input[@placeholder='%s']";

    public Div(WebDriver driver, String inputLabel) {
        this.driver = driver;
        this.divLabel = inputLabel;
    }
    public void fillIn(String value) {
        driver.findElement(By.xpath(String.format(DIV_LOCATOR, divLabel))).sendKeys(value);
    }
}

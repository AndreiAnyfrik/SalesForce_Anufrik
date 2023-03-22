package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By graph = By.xpath("//span[text()='Home']");
    private By account = By.xpath("//span[text()='Accounts']//ancestor::a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage waitForPageOpening() {
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(graph));
        return this;
    }
}

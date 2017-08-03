package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by marcelodiaz on 31/7/17.
 */
public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

}

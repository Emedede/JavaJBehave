package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by marcelodiaz on 31/7/17.
 */
public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
    }


    public void BasePage(WebDriver driver) {
        this.driver = driver;
    }
    ////div[@class="weather"]/div/a
}

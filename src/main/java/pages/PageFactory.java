package pages;
//import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


/**
 * Created by marcelodiaz on 31/7/17.
 */
public class PageFactory extends org.openqa.selenium.support.PageFactory {
    private WebDriver webDriver;
    private Properties properties;

    public PageFactory(WebDriver driver, Properties prop) {
        this.webDriver = driver;
        this.properties= prop;
    }

    public HomePage newHome() {
        return new HomePage(webDriver);
    }

}

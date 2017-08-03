package pages;
//import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;


/**
 * Created by marcelodiaz on 31/7/17.
 */
public class PageFactory {
    private final WebDriver webDriver;

    public PageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public HomePage newHome() {
        return new HomePage(webDriver);
    }

}

package steps;

import core.EnvironmentData;
import org.jbehave.core.annotations.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.PageFactory;

import java.util.Properties;
import static org.junit.Assert.assertTrue;

/**
 * Created by mdd_1 on 25/7/2017.
 */
public class Example {
    WebDriver driver = null;
    EnvironmentData env= new EnvironmentData();
    Properties data = new Properties();

    PageFactory pageFactory= new PageFactory(driver);
    //String browserList =

    @BeforeScenario
    public void scenarioSetup() {
        System.out.println(" >>>> This is the Before !!!!");
    }

    @After
    void quitDriverScenario() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }
    @AfterStory
    void quitDriverStory() {
        driver.close();
        driver.quit();
    }
    @Given("user $username with password $passcode is on product page $url")
    public void loadProduct(String username, String passcode, String url) {
        System.out.println(" >>>> This is the Given!, I'm on steps/Example");
        setEnvironment();
        String baseURL= this.data.getProperty("primaryURL");
        driver.get(baseURL);
    }

    @When("the user clicks add to wishlist")
    public void addToWishlist() {
        System.out.println(" >>>> This is the When !!!!");
        //driver.findElement(By.class("addToWishlist"));
        //.click();
    }

    @Then("the wish list page is displayed")
    public void isWishlistPage() {
        //assertTrue("Wishlist page", driver.getCurrentUrl().matches(".*/gp/registry/wishlist.*"));
        System.out.println(" >>>> This is the Then !!!!");
    }

    @Then("the product $title appears on the wish list")
    public void checkProduct(String title) {
        // check product entries
        // assert if product not found
        System.out.println(" >>>> This is the Then 222!!!!");
        quitDriverScenario();
    }

    public void setEnvironment(){
        this.data = this.env.setProperties(this.data);
        this.driver = this.env.createDriver();
    }

}

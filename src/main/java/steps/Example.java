package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.EnvironmentData;
import org.jbehave.core.annotations.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.PageFactory;

import java.util.Properties;
import static org.junit.Assert.assertTrue;

/**
 * Created by mdd_1 on 25/7/2017.
 */
public class Example {
    WebDriver driver = null;
    EnvironmentData env;
    Properties data;
    ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
    PageFactory pageFactory;
    private HomePage homePage;

    public Example(){
        env= new EnvironmentData();
        driver= env.doCreateWebDriver();
        data= env.getProperties();
        pageFactory= new PageFactory(driver,data);
        homePage = pageFactory.newHome();
        htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
    }
    @BeforeScenario
    public void scenarioSetup() {
        System.out.println(" >>>> This is the Before !!!!");
        // initialize ExtentReports and attach the HtmlReporter

    }

    @After
    void quitDriverScenario() {
        if (!(driver==null)) {
            driver.manage().deleteAllCookies();
            driver.close();
            //driver.quit();
        }
        // attach only HtmlReporter
        extent.attachReporter(htmlReporter);
    }
    @AfterStory
    public void tearDown(){
        if (!(driver==null)) {
            driver.manage().deleteAllCookies();
            //driver.close();
            driver.quit();
        }
    }
    @Given("user $username with password $passcode is on product page $url")
    public void loadProduct(String username, String passcode, String url) {
        System.out.println(" >>>> This is the Given!, I'm on steps/Example");
        //setEnvironment();

        String baseURL= data.getProperty("primaryURL");
        System.out.println("***> primaryURL: '"+baseURL+"'");
        //driver.get(baseURL);
        this.homePage.goToUrl(baseURL);
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
        //quitDriverScenario();
    }

    public void setEnvironment(){
        this.data = this.env.getProperties();
        //this.driver = this.env.createDriver();
    }

}

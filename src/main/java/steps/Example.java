package steps;//import org.apache.xpath.operations.String;
import org.jbehave.core.annotations.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by mdd_1 on 25/7/2017.
 */
public class Example {
        WebDriver driver = null;
        //String browserList =

        @BeforeScenario
        public void scenarioSetup() {
            System.out.println(" >>>> This is the Before !!!!");
            //driver = new FirefoxDriver();
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
            //doUserLogin(driver, username, passcode); // defined elsewhere
            System.out.println(" >>>> This is the Given !!!!");
            String myURL="http://www.montevideo.com.uy/index.html";
                    //"http://www.ovaciondigital.com.uy/";

            //System.setProperty("webdriver.edge.driver", "C:\\w\\FunctTest\\MicrosoftWebDriver.exe");
            //DesiredCapabilities capabilities = new DesiredCapabilities("MicrosoftEdge", "", Platform.WINDOWS);
            //driver = new EdgeDriver(capabilities);
                    //doCreateWebDriver("chrome"); //new InternetExplorerDriver();
                    //EdgeDriver();
                    //OperaDriver(); //
            driver = new FirefoxDriver();
                    //ChromeDriver();
            driver.get(myURL);
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
    protected static WebDriver doCreateWebDriver(String driverName) {
        //String driverName = System.getEnvVarOrSystemProperty(FABRIC8_WEBDRIVER_NAME);
        if (driverName != null) {
            //driverName = driverName.toString().toLowerCase();
            if (driverName.equals("chrome")) {
                return new ChromeDriver();
            } else if (driverName.equals("edge")) {
                return new EdgeDriver();
            } else if (driverName.equals("firefox")) {
                return new FirefoxDriver();
            } else if (driverName.equals("htmlunit")) {
                return new HtmlUnitDriver();
            } else if (driverName.equals("internetexplorer") || driverName.equals("ie")) {
                return new InternetExplorerDriver();
            } else if (driverName.equals("opera")) {
                return new OperaDriver();
            } else if (driverName.equals("phantomjs")) {
                return new PhantomJSDriver();
/*
            } else if (driverName.equals("remote")) {
                return new RemoteWebDriver();
*/
            } else if (driverName.equals("safari")) {
                return new SafariDriver();
            } else if (driverName.equals("htmlunit")) {
                return new HtmlUnitDriver();
            }
        }
        return new ChromeDriver();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by marcelodiaz on 31/7/17.
 */
public class HomePage  {
    WebDriver driver;
    private final String xpathButtonSuport = "//div[@id='homepage-hero-content']//a[@href='/customer-support/']";
    WebElement buttonSupport;
    /**
     * Method to create a new instance of HomePage
     * @param driver
     */
    public HomePage(WebDriver driver){
        this.driver= driver;
    }

    public boolean isLoad(){
        return buttonSupport.isDisplayed();
    }

    public void goToUrl(String url){

        driver.get(url);

        buttonSupport= driver.findElement(By.xpath(xpathButtonSuport));
        System.out.println("driver.getTitle(): '"+ this.driver.getTitle()+"'");

        // Check that we're on the right page.
        if (!"Edgenuity Inc. | Homepage".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the home page");
        }
    }
}

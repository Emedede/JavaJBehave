package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by marcelodiaz on 1/8/17.
 */
public class EnvironmentData {
    int env = 1;
    String[] listOperSystem = {"Windows", "Mac", "Linux"};
    //According to each environment, must be set 0=Win, 1=Mac, 2=Linux
    String currentSO = listOperSystem[env];
    Properties data = new Properties();


    public EnvironmentData(){
        data= setProperties(data);
    }

    public Properties setProperties(Properties prop){

        try{
            if (currentSO.equals("Windows")) {
                prop.load(new FileInputStream("C:\\w\\FunctTest\\src\\main\\resources\\data.properties"));

            } else if (currentSO.equals("Mac")) {
                prop.load(new FileInputStream("/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/resources/data.properties"));
            } else  {
                prop.load(new FileInputStream("/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/resources/data.properties"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.data = prop;
        return prop;
    }
    public WebDriver createDriver(){

        //System.setProperty("webdriver.edge.driver", "C:\\w\\FunctTest\\MicrosoftWebDriver.exe");
        //DesiredCapabilities capabilities = new DesiredCapabilities("MicrosoftEdge", "", Platform.WINDOWS);
        //driver = new EdgeDriver(capabilities);
        //doCreateWebDriver("chrome"); //new InternetExplorerDriver();
        //EdgeDriver();
        //OperaDriver(); //  //a[@href="/customer-support/"]
        //driver = new FirefoxDriver();
        return new ChromeDriver();
    }
    public WebDriver doCreateWebDriver() {
        String driverName = data.getProperty("defaultBrowser");

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
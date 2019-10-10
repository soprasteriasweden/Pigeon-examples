package se.soprasteria.automatedtesting.webdriver.twitter.sitemodel;

import org.openqa.selenium.WebDriver;
import se.soprasteria.automatedtesting.webdriver.api.utility.Errors;


import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;
import se.soprasteria.automatedtesting.webdriver.twitter.sitemodel.pages.loginpage.LoginPage;
import se.soprasteria.automatedtesting.webdriver.twitter.sitemodel.pages.loginpage.LoginPageWeb;
import se.soprasteria.automatedtesting.webdriver.twitter.sitemodel.pages.mainpage.MainPage;
import se.soprasteria.automatedtesting.webdriver.twitter.sitemodel.pages.mainpage.MainPageWeb;

public class TwitterPageFactory {

    public static LoginPage getLoginPage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new LoginPageWeb(driver);
        }
        if (driver.isAndroid()) {
            //return Android login page
        }
        if (driver.isIos()) {
            //return iOS login page
        }
        throw new RuntimeException(getInvalidDriverError(driver));
    }

    public static MainPage getMainPage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new MainPageWeb(driver);
        }
        if (driver.isAndroid()) {
            //return Android main page
        }
        if (driver.isIos()) {
            //return iOS main page
        }
        throw new RuntimeException(getInvalidDriverError(driver));
    }

    private static String getInvalidDriverError(WebDriver webDriver) {
        String[] fixes = {"Change webdriver configuration to a valid one for this project",
                "Implement support for webdriver: " + webDriver.toString()};
        return Errors.getErrorMessage("Tried to start unsupported webdriver", fixes);
    }

}

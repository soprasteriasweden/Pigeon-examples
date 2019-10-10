package se.soprasteria.automatedtesting.webdriver.twitter.sitemodel.pages.mainpage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class MainPageWeb extends BasePageObject implements MainPage {


    @FindBy(css = ".notranslate.public-DraftEditor-content") // from css: .notranslate.public-DraftEditor-content
    protected WebElement tweetBox;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div[3]")
    protected WebElement sendBtn;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[4]/div/div/section/div/div/div/div[1]/div/article/div/div[2]")
    protected WebElement newTweet;


    public MainPageWeb (AutomationDriver driver) {
        super(driver);
    }

    public void performTweet(String message) {
        elementHelper.sendKeysWithControlledSpeed(tweetBox, message, 20);
        elementHelper.clickWithinTime(sendBtn, 3000);
        elementHelper.isTextPresentInElementWithinTime(tweetBox, message, 4000);
        sleep(1000);    //Wait 1000ms for tweet to get posted
    }

    public boolean checkIfTweetHasBeenMade(String message){
        if(elementHelper.isTextPresentInElementWithinTime(newTweet, message, 4000)) {
            logger.info("The text inside of the new tweet box is = " + newTweet.getText() + "... just like its supposed to be");
            return true;
        }
        logger.info("The text inside of the new tweet box is = " + newTweet.getText() + "... which is Wrong");
        return false;
    }

    @Override
    public boolean isPageLoaded() {
        logger.info("Verifying that the MainPage is loaded by seeing if the tweetBox is currently shown.");
        boolean isLogoShown = elementHelper.isElementDisplayedWithinTime(tweetBox, 5000);
        if (isLogoShown) {
            logger.info("The tweetBox is shown, returning true");
            return true;
        }
        logger.info("The tweetBox is not shown, returning false");
        return false;
    }

}

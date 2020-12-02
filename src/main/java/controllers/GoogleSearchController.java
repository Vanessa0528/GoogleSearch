package controllers;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.GoogleSearchPage;

import java.util.concurrent.TimeUnit;

public class GoogleSearchController {

    private WebDriver driver;
    GoogleSearchPage googleSearchPage;

    public void openExplorer(){
        try {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }catch(Exception e){
            Assert.fail();
        }
    }

    public void visit(String url)
    {
        try {
            driver.get(url);
            googleSearchPage = new GoogleSearchPage(driver);
        }catch(Exception e){
            Assert.fail();
        }
    }

    public void closeBrowser()
    {
        try {
            driver.close();
        }catch(Exception e){
            Assert.fail();
        }
    }

    public void writeSentenceToSearch(String textToSearch){
        try {
            googleSearchPage.SentenceToSearch(textToSearch);
        }catch(Exception e){
            Assert.fail();
        }
    }

    public void clicInSearchBoton(){
        try {
            googleSearchPage.clicBotonSearchGoogle();
        }catch(Exception e){
            Assert.fail();
        }
    }

    public void validateMessageError(String msgErrorPage){
        try{
            String messageError = googleSearchPage.getMessageError();
            Assert.assertEquals("The messages are not equals",messageError,msgErrorPage);
        }catch (Exception e){
            Assert.fail();
        }
    }

    public void validateCurrentUrl(){
        try{
            String url = driver.getCurrentUrl();
            Assert.assertNotEquals("The Url is not equal",url,"https://www.google.com");
        }catch(Exception e){
            Assert.fail();
        }
    }

    public void validatePageResults(){
        try{
            Assert.assertTrue("The page not redirect",googleSearchPage.validateSearchResult());
        }catch (Exception e){
            Assert.fail();
        }
    }

    public void validateFirstResult(String destinationPage){
        try{
            Assert.assertEquals("The result found it is not the expected",destinationPage,googleSearchPage.getTextFirstResult());
        }catch (Exception e){
            Assert.fail();
        }
    }

    public void clicFirstResult(){
        try{
            googleSearchPage.selectFirstResult();
        }catch(Exception ex){
            Assert.fail();
        }
    }

    public void validateRedirectionPage(String destinationPage){
        try{
            Assert.assertEquals("the pages are not the same",destinationPage,driver.getTitle());
        }catch (Exception e){
            Assert.fail();
        }
    }

    public void validateListSuggestions(){
        try{
            Assert.assertTrue("The Suggestions not display",googleSearchPage.validateListSuggestions());
        }catch(Exception ex){
            Assert.fail();
        }
    }

    public void selectFirstSuggestion(){
        googleSearchPage.selectFirstSuggestion();
    }

}

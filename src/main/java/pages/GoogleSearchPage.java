package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage  {

    @FindBy(xpath = "//input[@name='q']")
    private  WebElement inputSearch;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement btnGoogleSearch;

    @FindBy(xpath = "(//div[@id='rso'])[1]/div[1]/div/div[1]//h3//span")
    private WebElement txtFirstResult;

    @FindBy(xpath = "//ul[@class='erkvQe']/li[1]")
    private WebElement listFirstResultSuggestion;

    @FindBy(xpath = "//div[@id='topstuff']/div/div/p[1]")
    private WebElement txtErrorMessage;

    public GoogleSearchPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void SentenceToSearch(String text)
    {
        inputSearch.sendKeys(text);
    }

    public void clicBotonSearchGoogle(){
        btnGoogleSearch.click();
    }

    public String getMessageError(){
        return txtErrorMessage.getText();
    }

    public boolean validateSearchResult(){
        return txtFirstResult.isDisplayed();
    }

    public String getTextFirstResult(){
        return txtFirstResult.getText();
    }


    public void selectFirstResult(){
        txtFirstResult.click();
    }

    public boolean validateListSuggestions(){
        return listFirstResultSuggestion.isDisplayed();
    }

    public void selectFirstSuggestion(){
        listFirstResultSuggestion.click();
    }



}

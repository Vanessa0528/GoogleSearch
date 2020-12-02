package stepdefinition;

import controllers.GoogleSearchController;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchStep {
    GoogleSearchController googleSearchController = new GoogleSearchController();

    @Before
    public void setUp(){
        googleSearchController.openExplorer();
    }

    @After
    public void tearDown()
    {
        googleSearchController.closeBrowser();
    }

    @Given("^user is on the Google homepage$")
    public void userIsOnTheGoogleHomepage() {
        googleSearchController.visit("https://www.google.com/");
    }

    @When("^User type \"([^\"]*)\" into the search field$")
    public void userTypeIntoTheSearchField(String sentenceToSearch) {
        googleSearchController.writeSentenceToSearch(sentenceToSearch);
    }

    @When("^User click the Google Search button$")
    public void userClickTheGoogleSearchButton() {
        googleSearchController.clicInSearchBoton();
    }

    @Then("^System to see a error messaje: \"([^\"]*)\"$")
    public void systemToSeeAErrorMessaje(String msgErrorPage) throws Throwable {
        googleSearchController.validateMessageError(msgErrorPage);
    }

    @Then("^The system stay in Google home page$")
    public void theSystemStayInGoogleHomePage() {
        googleSearchController.validateCurrentUrl();
    }

    @Then("^System redirect to search results page$")
    public void systemRedirectToSearchResultsPage() {
        googleSearchController.validatePageResults();
    }

    @Then("^the first result is \"([^\"]*)\"$")
    public void theFirstResultIs(String pageResult) {
        googleSearchController.validateFirstResult(pageResult);
    }

    @When("^I click on the first result link$")
    public void iClickOnTheFirstResultLink() {
        googleSearchController.clicFirstResult();
    }

    @Then("^System redirect to the \"([^\"]*)\" page$")
    public void systemRedirectToThePage(String destinationPage) {
        googleSearchController.validateRedirectionPage(destinationPage);
    }

    @When("^the suggestions list is displayed$")
    public void theSuggestionsListIsDisplayed() {
        googleSearchController.validateListSuggestions();
    }

    @When("^I click on the first suggestion in the list$")
    public void iClickOnTheFirstSuggestionInTheList() {
        googleSearchController.selectFirstSuggestion();
    }
}

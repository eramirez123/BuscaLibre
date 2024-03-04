package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginaInicial;
import pages.ResultPage;

public class BuscalibreSteps {
    
    PaginaInicial landingPage = new PaginaInicial();
    ResultPage results = new ResultPage();

    @Given("go to buscalibre page")
    public void goToBuscalibrePage(){
        landingPage.goToBuscalibre();
    }

    @When("^i search the book ([^\\\"]*)")
    public void searchBooks(String name){
        landingPage.searchBook(name);
        landingPage.clickSearchButton();
    }

    @Then("validate that any search results are found")
    public void ValidateSearchResults(){
        results.validateSearchResultsFound();
    }

    @Then("validate that no search results are found")
    public void validateResultsNotFound(){
        results.validateSearchResultsNotFound();
    }

    @Then("^validate that there are results for the author ([^\\\"]*)")
    public void validateAuthorSearchResults(String author){
        results.validateAuthorResults(author);
    }

    @And("the system enters a random product detail")
    public void selectRandomProduct(){
        results.clickOnRandomItem();
    }
}

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DetailsPage;
import pages.PaginaInicial;
import pages.ResultPage;

public class BuscalibreSteps {
    
    PaginaInicial landingPage = new PaginaInicial();
    ResultPage results = new ResultPage();
    DetailsPage details = new DetailsPage();

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
        details.selectRandomBook();
    }

    @Then("Valid that the price shown in the search result matches the price shown in the detail")
    public void validateMatches(){
        details.validateMatches();
    }
}

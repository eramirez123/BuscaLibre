package steps;

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
}

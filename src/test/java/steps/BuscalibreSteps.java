package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.PaginaInicial;

public class BuscalibreSteps {
    
    PaginaInicial landingPage = new PaginaInicial();

    @Given("go to buscalibre page")
    public void goToBuscalibrePage(){
        landingPage.goToBuscalibre();
    }

    @When("^i search the book ([^\\\"]*)")
    public void searchBooks(String name){
        landingPage.searchBook(name);
        landingPage.clickSearchButton();
    }
}

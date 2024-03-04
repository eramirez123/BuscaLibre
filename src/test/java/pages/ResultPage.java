package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultPage extends BasePage {
    private String pageResults = "//div[@class='cantidadProductos']//h2";
    private String pageResultsNotFound = "//section[@id='noEncontrado']/p[contains(text(),'Lo sentimos')]";
    private String expectedStringFound = "Encontramos ";
    private String expectedNotFound = "Lo sentimos, pero no encontramos lo que buscas:";
    private String authorFound = "//input[@name='fa' and @type ='checkbox' and @value = '%s']";
    private String filterResult = "//div[@class='div-pill']";
    private String listResults = "//div[contains(@class,'box-producto')]";
    private String listOfPrices = "//p[contains(@class, 'precio-ahora')]/strong";
    private String listOfNames = "//h3[contains(@class, 'nombre')]";
    
    

    public ResultPage(){
        super(driver);
    }

    //Metodo para validar los resultados
    private void validateResults(String xpathResults, String expectedString ){
        String foundResults = getPageText(xpathResults);
        assertTrue(foundResults.toLowerCase().contains(expectedString.toLowerCase())
        , "El valor mostrado (" + foundResults + "), no coincide con el valor esperado: (" + expectedString + ").");
    }

    //Validar cuando hay resultados encontrados
    public void validateSearchResultsFound(){
        validateResults(pageResults, expectedStringFound);
    }

    //Validar cuando no hay resultados encontrados
    public void validateSearchResultsNotFound(){
        validateResults(pageResultsNotFound, expectedNotFound);
    }

    //Filtra por autor y valida que haya resultados
    public void validateAuthorResults(String author){
        String xpathAuthor = String.format(authorFound, author.toLowerCase());
        clickElement(xpathAuthor);
        validateResults(filterResult, author);
        validateResults(pageResults, expectedStringFound);
    }

    public void clickOnRandomItem(){
        List<WebElement> bookList = createListOfWebElements(listResults);
        List<WebElement> prices = createListOfWebElements(listOfPrices);
        List<WebElement> names = createListOfWebElements(listOfNames);

        Random rand = new Random();
        int r = rand.nextInt(bookList.size());


        String expectedElement = bookList.get(r).getText();
        String expectedPrice = prices.get(r).getText();
        String expectedname = names.get(r).getText();
        WebElement clickeableTitle = names.get(r);
        clickeableTitle.click();

        System.out.println(expectedElement);
        System.out.println("****************************");
        
        System.out.println(expectedname);
        System.out.println(expectedPrice);
    }

}

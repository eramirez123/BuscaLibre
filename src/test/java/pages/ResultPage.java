package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultPage extends BasePage {
    private String pageResults = "//div[@class='cantidadProductos']//h2";
    private String pageResultsNotFound = "//section[@id='noEncontrado']/p[contains(text(),'Lo sentimos')]";
    private String expectedStringFound = "Encontramos ";
    private String expectedNotFound = "Lo sentimos, pero no encontramos lo que buscas:";
    private String authorFound = "//input[@name='fa' and @type ='checkbox' and @value = '%s']";
    private String filterResult = "//div[@class='div-pill']";
    
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

}

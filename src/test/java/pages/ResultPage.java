package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultPage extends BasePage {
    private String pageResults = "//div[@class='cantidadProductos']//h2";
    private String expectedStringFound = "Encontramos ";

    
    public ResultPage(){
        super(driver);
    }


    private void validateResults(String xpathResults, String expectedString ){
        String foundResults = getPageText(xpathResults);
        assertTrue(foundResults.toLowerCase().contains(expectedString.toLowerCase())
        , "El valor mostrado (" + foundResults + "), no coincide con el valor esperado: (" + expectedString + ").");
    }

    public void validateSearchResultsFound(){
        validateResults(pageResults, expectedStringFound);
    }


}

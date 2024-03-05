package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetailsPage extends BasePage{

    private String expectedName;
    private String expectedPrice;
    private String foundName;
    private String foundPrice;
    String nameLocator = "//p[@class='tituloProducto']";
    String priceLocator = "//p[contains(@class, 'precioAhora ')]/span";

    ResultPage result = new ResultPage();

    public DetailsPage(){
        super(driver);
    }

    public void selectRandomBook(){
        result.clickOnRandomItem();
    }

    private void getExpectedValues(){
        expectedName = result.getBookName();
        expectedPrice = result.getBookPrice();
    }

    private void getDetailsValues(){
        foundName = getPageText(nameLocator);
        foundPrice = getPageText(priceLocator);
    }

    public void validateMatches(){
        getExpectedValues();
        getDetailsValues();
        assertEquals(expectedName, foundName);
        assertEquals(expectedPrice, foundPrice);
    }
    
}

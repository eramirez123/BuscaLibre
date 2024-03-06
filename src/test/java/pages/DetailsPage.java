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

    //Constructor
    public DetailsPage(){
        super(driver);
    }

    //selecciona el item random
    public void selectRandomBook(){
        result.clickOnRandomItem();
    }

    //Trae los valores de la busqueda del item
    private void getExpectedValues(){
        expectedName = result.getBookName();
        expectedPrice = result.getBookPrice();
    }

    //Captura los valores del detalle
    private void getDetailsValues(){
        foundName = getPageText(nameLocator);
        foundPrice = getPageText(priceLocator);
    }


    //Compara los valores de la busqueda y detalle
    public void validateMatches(){
        getExpectedValues();
        getDetailsValues();
        assertEquals(expectedName, foundName);
        assertEquals(expectedPrice, foundPrice);
    }
    
}

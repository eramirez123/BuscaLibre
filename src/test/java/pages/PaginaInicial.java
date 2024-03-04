package pages;


public class PaginaInicial extends BasePage{
    
    String searchBox = "//input[@name='q' and not(@disabled)]";
    String buttonSearch = "//input[@name='q' and not(@disabled)]/following-sibling::*";

    public PaginaInicial(){
        super(driver);
    }

    //Ir a la página de Buscalibre colombia
    public void goToBuscalibre(){
        driver.manage().window().maximize();
        navigateTo("https://www.buscalibre.com.co/");
    }

    //Escribir el libro que se va a buscar
    public void searchBook(String bookName){
        write(searchBox, bookName);
    }

    //Click en botón buscar
    public void clickSearchButton(){
        clickElement(buttonSearch);
    }

}

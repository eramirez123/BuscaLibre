package pages;


public class PaginaInicial extends BasePage{
    
    String searchBox = "//input[@name='q' and not(@disabled)]";
    String buttonSearch = "//input[@name='q' and not(@disabled)]/following-sibling::*";

    public PaginaInicial(){
        super(driver);
    }

    public void goToBuscalibre(){
        driver.manage().window().maximize();
        navigateTo("https://www.buscalibre.com.co/");
    }

    public void searchBook(String bookName){
        write(searchBox, bookName);
    }

    public void clickSearchButton(){
        clickElement(buttonSearch);
    }

}

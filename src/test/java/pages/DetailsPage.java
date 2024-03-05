package pages;

public class DetailsPage extends BasePage{

    ResultPage result = new ResultPage();

    public DetailsPage(){
        super(driver);
    }

    public void selectRandomBook(){
        result.clickOnRandomItem();
    }
    

    public void getExpectedValues(){
        System.out.println(result.getBookName());
        System.out.println(result.getBookPrice());
    }
    
}

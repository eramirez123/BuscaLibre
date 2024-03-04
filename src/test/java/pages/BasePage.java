package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

    

    //Bloque para configuración del driver
    static{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Constructor de la clase
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    //Metodo para abrir el navegador
    public static void navigateTo(String url){
        driver.get(url);
    }

    //Metodo para cerrar el navegador
    public static void closeBrowser(){
        driver.quit();
    }

    //Metodo para buscar los elementos
    private WebElement find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }


    //Metodo para escribir en en elemento
    public void write(String locator, String keysToSend){
        find(locator).sendKeys(keysToSend);
    }

    public void clickElement(String locator){
        //find(locator).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
    }

    //Metodo para hacer click sobre un elemento
    public List<WebElement> createListOfWebElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public String getPageText(String locator){
        return find(locator).getText();
    }

}

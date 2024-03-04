package runner;



import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "steps"
)

public class BuscalibreRunner {
    @AfterClass
    public static void clear(){
        BasePage.closeBrowser();
    }
}

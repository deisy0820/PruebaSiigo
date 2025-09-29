package runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/pruebaapi.feature",
        glue = "stepdefinitons",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PruebaApiRunner {
}
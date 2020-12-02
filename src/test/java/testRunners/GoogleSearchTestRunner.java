package testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/main/resources/features",
        glue = "stepdefinition",
        snippets = SnippetType.CAMELCASE,
        tags= { })

public class GoogleSearchTestRunner {
}

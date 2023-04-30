package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/JSONReports/report.json"},
        features = "src/test/resources/features/Register.feature",
        tags = "@TestNavigation",
        glue = "stepdefinitions"
)
public class RegisterRunner {}

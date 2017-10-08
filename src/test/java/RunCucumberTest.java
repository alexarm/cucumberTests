import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"steps"},
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" })
public class RunCucumberTest extends AbstractTestNGCucumberTests{
}

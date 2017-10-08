import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" })
public class RunCucumberTest extends AbstractTestNGCucumberTests{
}

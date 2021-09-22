package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/" , glue = {"stepDefinitions"},
monochrome = true,
plugin = {"pretty","html:TestResults/HtmlReport.html","json:TestResults/JsonReport.json","junit:TestResults/JUnitReport.xml"}
)

public class RunJPMTest {

}

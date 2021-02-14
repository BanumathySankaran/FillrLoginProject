package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/Feature"
,glue= {"seleniumgluecode"},tags={"@RealEsSce2"}
)

public class testrunner {

}
 

package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		  features="src/test/java/features",
		  plugin ="json:target/jsonReports/cucumber-report.json",
		  glue= {"stepDefinations"},
		  "rerun:target/cucumber-reports/rerun.txt"
		  //tags= {"@"}  
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}

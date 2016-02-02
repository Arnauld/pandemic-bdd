package myapp.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
    tags = {"~@wip", "~@bugfix", "~@pending"})
public class RunCucumberTest {
}

package myapp.feature.hello;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class HelloSteps {

    @Given("^a nice day$")
    public void a_nice_day() throws Throwable {
        System.out.println("HelloSteps.a_nice_day");
    }
}

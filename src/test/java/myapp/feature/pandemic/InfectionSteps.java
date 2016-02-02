package myapp.feature.pandemic;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapp.pandemic.City;
import myapp.pandemic.InfectionLevels;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class InfectionSteps {

    private final World world;

    public InfectionSteps(World world) {
        this.world = world;
    }


    @Given("^(.+) is not infected$")
    public void city_is_not_infected(City city) throws Throwable {
        getInfectionLevels().removeInfectionMarkers(city);
    }

    private InfectionLevels getInfectionLevels() {
        return world.getInfectionLevels();
    }

    public static class InfectionLevelProto {
        public City city;
        public Integer level;
    }

    @Given("^the following levels of infection:$")
    public void the_following_levels_of_infection(List<InfectionLevelProto> protoList) throws Throwable {
        protoList.stream().forEach(p -> getInfectionLevels().setInfectionLevel(p.city, p.level));
    }

    @When("^(.+) is infected$")
    public void paris_is_infected(City city) throws Throwable {
        getInfectionLevels().infects(city);
    }

    @Then("^(.+)'s level of infection should be (\\d+)$")
    public void paris_s_level_of_infection_should_be(City city, int expectedLevel) throws Throwable {
        assertThat(getInfectionLevels().levelOf(city)).isEqualTo(expectedLevel);
    }


    @Then("^(.+) should outbreak$")
    public void paris_should_outbreak(City city) throws Throwable {
        assertThat(
                world.getMessages()
        ).contains(city);
    }


    @Then("^the levels of infection should be:$")
    public void the_levels_of_infection_should_be(List<InfectionLevelProto> expectedProto) throws Throwable {
        expectedProto.stream()
                .forEach(p -> assertThat(getInfectionLevels().levelOf(p.city))
                        .describedAs("Infection level of " + p.city)
                        .isEqualTo(p.level));
    }
}

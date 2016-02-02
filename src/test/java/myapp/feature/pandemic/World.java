package myapp.feature.pandemic;

import myapp.pandemic.City;
import myapp.pandemic.CityLinks;
import myapp.pandemic.InfectionLevels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class World {
    private CityLinks cityLinks = new CityLinks();
    private List<City> messages = new ArrayList<>();
    private InfectionLevels infectionLevels = new InfectionLevels(messages::add, cityLinks);

    public InfectionLevels getInfectionLevels() {
        return infectionLevels;
    }

    public List<City> getMessages() {
        return messages;
    }

    public CityLinks getCityLinks() {
        return cityLinks;
    }
}

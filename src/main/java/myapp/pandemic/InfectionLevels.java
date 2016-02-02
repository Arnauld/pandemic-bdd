package myapp.pandemic;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class InfectionLevels {

    private final Map<City, Integer> infectionLevels = new HashMap<>();
    private final OutbreakChannel channel;
    private final CityLinks cityLinks;

    public InfectionLevels(OutbreakChannel channel, CityLinks cityLinks) {
        this.channel = channel;
        this.cityLinks = cityLinks;
    }

    public void removeInfectionMarkers(City city) {
        infectionLevels.remove(city);
    }

    public void infects(City city) {
        Integer level = infectionLevels.getOrDefault(city, 0);
        if (level == 3) {
            channel.notifyOutbreak(city);

            Stream<City> stream = cityLinks.citiesConnectedTo(city);
            stream.forEach(this::infects);
        } else {
            infectionLevels.put(city, level + 1);
        }
    }

    public int levelOf(City city) {
        return infectionLevels.getOrDefault(city, 0);
    }

    public void setInfectionLevel(City city, Integer level) {
        infectionLevels.put(city, level);
    }
}

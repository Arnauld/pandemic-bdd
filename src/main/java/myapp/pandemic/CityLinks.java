package myapp.pandemic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CityLinks {
    private List<Link> links = new ArrayList<>();

    public void declareLink(City city1, City city2) {
        links.add(new Link(city1, city2));
    }

    public Stream<City> citiesConnectedTo(City city) {
        return links
                .stream()
                .filter(l -> l.connectedTo(city))
                .map(l -> l.otherCity(city));
    }

    public static class Link {
        public final City city1, city2;

        public Link(City city1, City city2) {
            this.city1 = city1;
            this.city2 = city2;
        }

        public boolean connectedTo(City city) {
            return city1 == city || city2 == city;
        }

        public City otherCity(City city) {
            if (city == city1)
                return city2;
            if (city == city2)
                return city1;
            throw new IllegalArgumentException("City not part of link [" + city1 + ",  " + city2 + "]");
        }
    }
}

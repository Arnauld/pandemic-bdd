package myapp.feature.pandemic;

import cucumber.api.java.Before;
import myapp.pandemic.CityLinks;

import static myapp.pandemic.City.*;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Hooks {

    private final World world;

    public Hooks(World world) {
        this.world = world;
    }

    @Before("@simplified_world")
    public void defineSimplifiedWorld() {
        CityLinks links = world.getCityLinks();
        links.declareLink(Paris, London);
        links.declareLink(Paris, Madrid);
        links.declareLink(Paris, Essen);
        links.declareLink(Paris, Algiers);
        links.declareLink(Paris, Milan);
        links.declareLink(NewYork, London);
        links.declareLink(NewYork, Madrid);
        links.declareLink(London, Essen);
        links.declareLink(Milan, Essen);
        links.declareLink(Madrid, Algiers);
    }
}

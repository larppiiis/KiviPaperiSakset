
package kivipaperisakset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Pelaaja-luokka, jossa määritetään pelaajan valinnat (kivi, paperi, sakset)
 * ja pidetään huolta pelaajan voitoista.
 * @author Laura Immonen
 */
public class Pelaaja {
    /**
     * Random-olio pelaajan valinnalle.
     */
    private final Random random = new Random();
    /**
     * Voittojen lukumäärä.
     */
    private int voitot;

    /**
     * Valitse randomilla kivi, paperi tai sakset listalta.
     * @return String kivi,paperi tai sakset
     */
    public String pelaajanValinta() {
        return setValinnat().get(random.nextInt(setValinnat().size()));
    }

    /**
     * Aseta kaikki mahdolliset pelaajan valinnat.
     *
     * @return List kaikki valinnat (kivi, paperi, sakset)
     */
    public List<String> setValinnat() {
        List<String> valinnat = new ArrayList<>();
        valinnat.add("kivi");
        valinnat.add("paperi");
        valinnat.add("sakset");
        return valinnat;
    }

    /**
     * Kasvatetaan voitto yhdellä.
     *
     * @return int kasvatettu voitto
     */
    public int kasvataVoitot() {
        return voitot++;
    }

    /**
     * Haetaan pelaajan voitot.
     *
     * @return int pelaajan kaikki kerrytetyt voitot.
     */
    public int getVoitot() {
        return (voitot);
    }
}

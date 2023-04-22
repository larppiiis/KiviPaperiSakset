package test;

import kivipaperisakset.Pelaaja;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Pelaaja-luokan testiluokka.
 */
public class PelaajaTest {
    /**
     * Pelaaja-olio testausta varten.     */
    private static final Pelaaja pelaaja = new Pelaaja();
    /**
     * Pelaajan valinta String-oliona.
     */
    private static String pValinta;
    /**
     * Kaikki valinnat listana.
     */
    private static List<String> valinnat;
    /**
     * Valintalistan koko.
     */
    private static final int VALINTALISTAN_KOKO = 3;

    /**
     * Luodaan kaikki pelaajan valinnat ja
     * asetetaan pelaajalla valinta.
     */
    @BeforeClass
    public static void createData() {
        pValinta = pelaaja.pelaajanValinta();
        valinnat = pelaaja.setValinnat();
    }

    /**
     * Testaa onko pelaaja tehnyt valinnan.
     */
    @Test
    public void valintaTehty() {
        Assert.assertNotNull("Valinta ei pitäisi olla tyhjä.", pValinta);
    }

    /**
     * Testaa onko listalla kaikki valinnat (kivi, paperi, sakset)
     * ja onko niitä oikea määrä.
     */
    @Test
    public void valinnatAsetettu() {
        Assert.assertEquals("Valintojen määrä on väärä.", VALINTALISTAN_KOKO, valinnat.size());
        Assert.assertEquals("Ensimmäinen valinta ei ole kivi.", "kivi", valinnat.get(0));
        Assert.assertEquals("Toinen valinta ei ole paperi.", "paperi", valinnat.get(1));
        Assert.assertEquals("Kolmas valinta ei ole sakset.", "sakset", valinnat.get(2));
    }
}

package test;

import kivipaperisakset.Peli;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Peli-luokan testiluokka.
 */
public class PeliTest {
    /**
     * Peli-olio testausta varten.
     */
    private static final Peli peli = new Peli();
    /**
     * Ensimmäisen pelaajan valinta.
     */
    private static String pValinta1;
    /**
     * Toisen pelaajan valinta.
     */
    private static String pValinta2;

    /**
     * Asetetaan pelaajien valinnat.
     */
    @BeforeClass
    public static void createData() {
        pValinta1 = "paperi";
        pValinta2 = "kivi";
    }

    /**
     * Testaa onko ensimmäinen pelaaja voittanut.
     */
    @Test
    public void pelaajan1PitaisiVoittaa() {
        Assert.assertTrue("Pelaaja 1 olisi pitänyt voittaa.", peli.pelaaja1Voittaa(pValinta1, pValinta2));
    }

    /**
     * Testaa onko pelattujen pelien määrä
     * sama, kuin kasvatettu muuttuja.
     */
    @Test
    public void pelattujenPelejenMaaraOnOikea() {
        int i = 0;
        while (!peli.peliPaattyy()) {
            peli.kaynnistaPeli();
            peli.tulostaTulokset();
            i++;
        }
        Assert.assertEquals(i, peli.getPelatutPelit());
    }
}

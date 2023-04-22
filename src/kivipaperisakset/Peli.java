package kivipaperisakset;

/**
 * Peli-luokka, jossa seurataan pelaajien valintoja ja
 * pidetään yllä pelin tilanteet (tasapelien, voittojen määrä)
 * @author Laura Immonen
 */

public class Peli {
    /**
     * Ensimmäinen Pelaaja-olio.
     */
    private final Pelaaja pelaaja1 = new Pelaaja();
    /**
     * Toinen Pelaaja-olio.
     */
    private final Pelaaja pelaaja2 = new Pelaaja();
    /**
     * Tasapelien lukumäärä.
     */
    private int tasapelit = 0;

    /** Pelattujen pelien lukumäärä. */

    private int pelatutPelit = 0;
    /**
     * Ensimmäisen pelaajan valinta.
     */
    private String p1Valinta;
    /**
     * Toisen pelaajan valinta.
     */
    private String p2Valinta;
    /**
     * Voitetettuun peliin vaaditut voittojen määrät.
     */
    private static final int VOITETTU_PELI = 3;

    /**
     * Yksittäisen pelin käynnistys asettamalla
     * pelaajien valinnat ja kasvattamalla voittojen,
     * tasapelejen ja pelattujen pelejen määrää.
     */
    public void kaynnistaPeli() {
        setPelaajanValinnat();
        if (p1Valinta.equals(p2Valinta)) {
            kasvataTasapelit();
        } else if (pelaaja1Voittaa(p1Valinta, p2Valinta)) {
            pelaaja1.kasvataVoitot();
        } else {
            pelaaja2.kasvataVoitot();
        }
        kasvataPelatutPelit();
    }

    /**
     * Haetaan kaikki pelatut pelit.
     *
     * @return int pelatut pelit yhteensä
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    /**
     * Kasvatetaan tasapelien määrää.
     *
     * @return kasvatettu tasapalien määrä
     */
    public int kasvataTasapelit() {
        return tasapelit++;
    }

    /**
     * Kasvatetaan pelattujen pelejen määrää.
     *
     * @return kasvatettu pelattujen pelejen määrä
     */
    public int kasvataPelatutPelit() {
        return pelatutPelit++;
    }

    /**
     * Asetetaan pelaajien valinnat muuttujiin.
     */
    public void setPelaajanValinnat() {
        p1Valinta = pelaaja1.pelaajanValinta();
        p2Valinta = pelaaja2.pelaajanValinta();
    }

    /**
     * Käydään läpi kaikki mahdolliset tilanteet,
     * kun pelaaja 1 voi voittaa.
     *
     * @param valinta1 String pelaajan 1 valinta
     * @param valinta2 String pelaajan 2 valinta
     * @return boolean, true, jos pelaaja 1 voittaa
     */
    public boolean pelaaja1Voittaa(final String valinta1, final String valinta2) {
        String sakset = "sakset";
        String kivi = "kivi";
        String paperi = "paperi";
        if (valinta1.equals(kivi) && valinta2.equals(sakset)) {
            return true;
        }
        if (valinta1.equals(paperi) && valinta2.equals(kivi)) {
            return true;
        }
        return valinta1.equals(sakset) && valinta2.equals(paperi);
    }

    /**
     * Seurataan, milloin jommalla kummalla pelaaajalla tulee
     * 3 voittoa täyteen.
     *
     * @return boolean, jos peli päättynyt palautetaan true
     */
    public boolean peliPaattyy() {
        final boolean pelaaja1Voitti = pelaaja1.getVoitot() >= VOITETTU_PELI;
        final boolean pelaaja2Voitti = pelaaja2.getVoitot() >= VOITETTU_PELI;

        if ((pelaaja1Voitti) || (pelaaja2Voitti)) {
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            return true;
        }
        return false;
    }

    /**
     * Tulostetaan jokaisen pelin jälkeen pelin tulokset.
     */
    public void tulostaTulokset() {
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
        System.out.println("Pelaaja 1: " + p1Valinta
                + "\n\t Pelaaja 1:llä koossa " + pelaaja1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + p2Valinta
                + "\n\t Pelaaja 2:lla koossa " + pelaaja2.getVoitot() + " voittoa.");
    }
}

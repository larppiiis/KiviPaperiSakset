package kivipaperisakset;

/**
 * Main-luokka, jossa ajetaan "Kivi paperi sakset"-peliä,
 * kunnes jompi kumpi pelaajista voittaa.
 * @author Laura Immonen
 */
public class Main {

    public static void main(String args[]) {
        Peli peli = new Peli();
        while (!peli.peliPaattyy()) {
            peli.kaynnistaPeli();
            peli.tulostaTulokset();
        }
    }
}

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Tervetuloa pelaamaan kivi-paperi-sakset peliä!");

        Peli peli = new Peli();
        peli.kysyVaikeusTaso();

        Random rnd = new Random();
        //Arvotaan numero: 1 = käyttäjä aloittaa, 2 = tietokone aloittaa.
        int aloitus = rnd.nextInt(2) + 1;

        if (aloitus == 1) {
            System.out.println("Sinä aloitat!");
            peli.pelaaPelia(false);
        } else {
            System.out.println("Minä aloitan!");
            peli.pelaaPelia(true);
        }
    }
}
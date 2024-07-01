import java.util.Scanner;
import java.util.Random;
public class Peli {
    private int vaikeusTaso;
    private Random rnd;

    public Peli() {
        this.rnd = new Random();
    }
    //Kysytään käyttäjältä vaikeustaso.
    public void kysyVaikeusTaso() {
        Scanner in = new Scanner(System.in);
        System.out.print("Valitse vaikeustaso (1=helppo, 2=keskivaikea, 3=vaikea): ");
        vaikeusTaso = haeVaikeusTaso(in);
    }
    //Tämä funktio määrittelee pelin kulun.
    public void pelaaPelia(boolean tietokoneenAloitus) {
        if (tietokoneenAloitus) {
            int tietokoneenLiike = haeTietokoneenLiike(-1); //Tietokoneen aloitus, ei ole vielä pelaajan vuoro.
            System.out.println("Valitsin liikeen, sun vuoro!");
            Pelaaja pelaaja = new Pelaaja();
            int pelaajanLiike = pelaaja.haePelaajanLiike();
            System.out.println("Valitsit " + Liikkeet.haeLiikkeenNimi(pelaajanLiike));
            System.out.println("Valitsin " + Liikkeet.haeLiikkeenNimi(tietokoneenLiike));
            haeVoittaja(pelaajanLiike, tietokoneenLiike); //Päätellään, kumpi voitti pelin.
        } else {
            //Pelaajan aloitus
            Pelaaja pelaaja = new Pelaaja();
            int pelaajanLiike = pelaaja.haePelaajanLiike();
            int tietokoneenLiike = haeTietokoneenLiike(pelaajanLiike);
            System.out.println("Valitsit " + Liikkeet.haeLiikkeenNimi(pelaajanLiike));
            System.out.println("Valitsin " + Liikkeet.haeLiikkeenNimi(tietokoneenLiike));
            haeVoittaja(pelaajanLiike, tietokoneenLiike); //Päätellään, kumpi voitti pelin.
        }
    }
    //Tämä funktio asettaa pelin vaikeustason.
    private int haeVaikeusTaso(Scanner in) {
        while (true) {
            try {
                int taso = in.nextInt();
                if (taso < 1 || taso > 3) {
                    System.out.println("Valitse vaikeustaso väliltä 1-3");
                } else {
                    return taso;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Etkö osaa numeroita...Valitse vaikeutaso 1-3");
                in.next();
            }
        }
    }
    //Tämä funktio määrittää tietokoneen liikkeen vaikeustason perusteella.
    private int haeTietokoneenLiike(int pelaajanLiike) {
        switch (vaikeusTaso) {
            case 1:
                //Jos pelaajan vuoro on ensimmäisenä, pelaajan voittaa. Jos tietokoneen vuoro on ensimmäisenä, arvotaan liike.
                return pelaajanLiike == -1 ? rnd.nextInt(3) + 1 : Liikkeet.haeHaviavaLiike(pelaajanLiike);
            case 2:
                //Keskivaikea: Arvotaan satunnaisesti liike aloitusvuorosta riippumatta.
                return rnd.nextInt(3) + 1;
            case 3:
                //Jos pelaajan vuoro on ensimmäisenä, tietokone voittaa. Jos tietokoneen vuoro on ensimmäisenää, arvotaan liike.
                return pelaajanLiike == -1 ? rnd.nextInt(3) + 1 : Liikkeet.haeVoittavaLiike(pelaajanLiike);
            default:
                throw new RuntimeException("Väärä vaikeustaso");
        }
    }

    //Tässä funktiossa päätellään, kuka on pelin voittaja. Liikkeet kuvataan Liikkeet-luokassa.
    private void haeVoittaja(int pelaajanLiike, int tietokoneenLiike) {
        if (pelaajanLiike == tietokoneenLiike) {
            System.out.println("Peli on tasan! Pelataan toistekin.");
        } else if ((pelaajanLiike == 1 && tietokoneenLiike == 3) ||
                (pelaajanLiike == 2 && tietokoneenLiike == 1) ||
                (pelaajanLiike == 3 && tietokoneenLiike == 2)) {
            System.out.println("Jaha...sä voitit. Onneksi olkoon!");
        } else {
            System.out.println("Haha, mä voitin!");
        }
    }
}

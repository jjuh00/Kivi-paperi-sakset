//Tässä luokassa määritellään pelin logiikka.
public class Liikkeet {

    //Tämä funktio määrittää liikkeille nimet
    public static String haeLiikkeenNimi(int liike) {
        switch (liike) {
            case 1:
                return "Kivi";
            case 2:
                return "Paperi";
            case 3:
                return "Sakset";
            default:
                return "Tuntematon liike";
        }
    }
    //Tämä funktio määrittää tietokoneelle voittavan liikeen.
    public static int haeVoittavaLiike(int pelaajanLiike) {
        switch (pelaajanLiike) {
            case 1:
                return 2; //Paperi voittaa kiven jne.
            case 2:
                return 3;
            case 3:
                return 1;
            default:
                throw new RuntimeException("Tuntematon liike");
        }
    }
    //Tämä funtkio määrittää tietokoneelle häviävän liikeen.
    public static int haeHaviavaLiike(int pelaajanLiike) {
        switch (pelaajanLiike) {
            case 1:
                return 3; //Sakset häviää kivelle jne.
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                throw new RuntimeException("Tuntematon liike");
        }
    }
}

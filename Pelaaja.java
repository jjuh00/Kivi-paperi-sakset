import java.util.Scanner;
public class Pelaaja {
    //Tämä funktio määrittää pelaajan vuoron kulun.
    public int haePelaajanLiike() {
        Scanner in = new Scanner(System.in);
        System.out.print("Valitse liike (1=kivi, 2=paperi, 3=sakset): ");
        while (true) {
            try {
                int liike = in.nextInt();
                if (liike < 1 || liike > 3) {
                    System.out.print("Valitse liike väliltä 1-3: ");
                } else {
                    return liike;
                }
            } catch (NumberFormatException ex) {
                System.out.print("Etkö osaa kirjoittaa...Valitse numero 1-3: ");
                in.next();
            }
        }
    }
}

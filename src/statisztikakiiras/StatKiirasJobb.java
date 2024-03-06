package statisztikakiiras;

import java.util.Random;
import java.util.Scanner;

public class StatKiirasJobb {

    static Random rnd = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int db;
        do {
            System.out.print("Hányszor szeretnél dobni?: ");
            db = sc.nextInt();
        } while (db < 0 || db == 0);

        final int OLDAL = 13;
        int[] dobasLehetosegek = new int[OLDAL];

        for (int i = 0; i < db; i++) {
            int dobas = rnd.nextInt(2, OLDAL);
            dobasLehetosegek[dobas]++;
        }

        int m = 0;
        for (int i = 1; i < OLDAL; i++) {
            if (dobasLehetosegek[m] < dobasLehetosegek[i]) {
                m = i;
            }
        }

        final int MAX_CSILLAG = 40;
        for (int i = 2; i < OLDAL; i++) {

            double aktCsillagSzam;
            aktCsillagSzam = (double) dobasLehetosegek[i] / (double) dobasLehetosegek[m];
            aktCsillagSzam *= MAX_CSILLAG;
            aktCsillagSzam = Math.round(aktCsillagSzam);

            String csillagok = "";
            for (int j = 0; j < aktCsillagSzam; j++) {
                csillagok += "*";
            }
            if (dobasLehetosegek[i] > 0) {
                System.out.printf("%2d %s (%d db)\n", i, csillagok, dobasLehetosegek[i]);
            }
        }
    }

}

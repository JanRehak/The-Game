package cz.brumlamachine.deskovaHra;
import java.util.Scanner;

public class TahovyBoj {

    public static void main(String[] args) {

        Kostka kostka = new Kostka(10);

        boolean debug = false;
        int maxPoints = 40;
        String jmeno1;
        int utok1;
        String jmeno2;
        int utok2;
        int obrana1;  //= maxPoints - utok1;
        int obrana2; // = maxPoints - utok2;

        if (!debug) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Vitej v arene!");
            System.out.println("Jmeno Tveho Bojovnika?");
            jmeno1 = scanner.nextLine();
            System.out.println("Hodnota tveho utoku? Vyber si v rozmezi 0 - 40.");
            utok1 = scanner.nextInt();
            obrana1 = maxPoints - utok1;
            System.out.println("Hodnota tve obrany je: " + obrana1);
            System.out.println("Jmeno Tveho soupere?");
            jmeno2 = scanner.next();
            System.out.println("Hodnota tveho utoku? Vyber si v rozmezi 0 - 40.");

            utok2 = scanner.nextInt();
            obrana2 = maxPoints - utok2;
            System.out.println("Hodnota tve obrany je: " + obrana2);

        } else {

            jmeno1 = "A";
            utok1 = 40;
            jmeno2 = "B";
            utok2 = 20;
            obrana1 = maxPoints - utok1;
            obrana2 = maxPoints - utok2;
        }


        Bojovnik Ilidanis = new Bojovnik(jmeno1, 100, utok1, obrana1, kostka);
        Bojovnik Gandalf = new Bojovnik(jmeno2, 100, utok2,obrana2, kostka);
        Arena arena = new Arena(Ilidanis, Gandalf, kostka);



        arena.zapas();

    }

}









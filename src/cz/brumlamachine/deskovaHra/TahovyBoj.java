package cz.brumlamachine.deskovaHra;
import java.util.Scanner;

public class TahovyBoj {

    public static void main(String[] args) {

        Kostka kostka = new Kostka(10);
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Vitej v arene!");
//        System.out.println("Jmeno Tveho Bojovnika?");
//        String jmeno1 = scanner.nextLine();
//        System.out.println("Hodnota tveho utoku? Vyber si v rozmezi 0 - 40.");
//        int utok1 = scanner.nextInt();
//        int obrana1 = 40 - utok1;
//        System.out.println("Hodnota tve obrany je: " + obrana1);
//        System.out.println("Jmeno Tveho soupere?");
//        String jmeno2 = scanner.next();
//        System.out.println("Hodnota tveho utoku? Vyber si v rozmezi 0 - 40.");
//
//        int utok2 = scanner.nextInt();
//        int obrana2 = 40 - utok2;
//        System.out.println("Hodnota tve obrany je: " + obrana2);

        Bojovnik Ilidanis = new Bojovnik("Ilidanis",100, 25, 20, kostka);
        Bojovnik Gandalf = new Mag("Gandalf the White", 100, 10, 15, kostka, 10, 100, 150);
        Arena arena = new Arena(Ilidanis, Gandalf, kostka);

        arena.zapas();

    }

}









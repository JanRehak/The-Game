package cz.brumlamachine.deskovaHra;
import java.util.Random;
import java.util.Scanner;

public class TahovyBoj {

    public static void main(String[] args) {
        /** volim si pocet sten kostky */
        Kostka kostka = new Kostka(10);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxPoints = 40;
        String jmeno1;
        int utok1;
        String jmeno2;
        int utok2;
        int obrana1;  //= maxPoints - utok1;
        int obrana2; // = maxPoints - utok2;

        System.out.println("Vitej v arene! \n 1, Pro boj s pocitacem zadej 1 \n 2, Pro boj s druhym hracem zadej 2\n 3, Pro simulaci souboje terminatora" +
                "a Karlose Vemoly zadej 3");
        switch (scanner.nextInt()) {

             case 1:
               System.out.println("Jmeno Tveho Bojovnika?");
               jmeno1 = scanner.next();
                System.out.println("Hodnota tveho utoku? Vyber si v rozmezi 0 - 40.");
                utok1 = scanner.nextInt();
                obrana1 = maxPoints - utok1;
                System.out.println("Hodnota tve obrany je: " + obrana1);
                jmeno2 = "Kyborg.pocitac";
                utok2 = random.nextInt(40);
                obrana2 = maxPoints - utok2;
                    Bojovnik Ilidanis = new Bojovnik(jmeno1, 100, utok1, obrana1, kostka);
                    Bojovnik Gandalf = new Bojovnik(jmeno2, 100, utok2,obrana2, kostka);
                Arena arena = new Arena(Ilidanis, Gandalf, kostka);
                /** spousti zapas*/
                arena.zapas();
                break;
            case 2:
                System.out.println("Jmeno Tveho Bojovnika?");
                jmeno1 = scanner.next();
                System.out.println("Hodnota tveho utoku? Vyber si v rozmezi 0 - 40.");
                utok1 = scanner.nextInt();
                obrana1 = maxPoints - utok1;
                System.out.println("Hodnota tve obrany je: " + obrana1);
                System.out.println("Druhy hraci, jake je jmeno Tveho bojovnika?");
                jmeno2 = scanner.next();
                System.out.println("A hdnota tveho utoku? Vyber si v rozmezi 0 - 40.");
                utok2 = scanner.nextInt();
                obrana2 = maxPoints - utok2;
                System.out.println("Hodnota tve obrany je: " + obrana2);
                Bojovnik B1 = new Bojovnik(jmeno1, 100, utok1, obrana1, kostka);
                Bojovnik B2 = new Bojovnik(jmeno2, 100, utok2,obrana2, kostka);
                Arena arena1 = new Arena(B1, B2, kostka);
                arena1.zapas();
                break;

            case 3:
                Bojovnik P1 = new Bojovnik("Terminator", 100, 20, 20, kostka);
                Bojovnik P2 = new Bojovnik("KarlosVemola", 100, 20,20, kostka);
                Arena arena2 = new Arena(P1, P2, kostka);
                arena2.zapas();
                break;

            default :
                System.out.println("Musis zadat 1,2 nebo 3. Hrej znovu a spravne, nebo vubec!");




    }

}
}









package cz.brumlamachine.deskovaHra;

public class Arena {
    private Bojovnik bojovnik1;
    private Bojovnik bojovnik2;
    private Kostka kostka;

    public Arena(Bojovnik bojovnik1, Bojovnik bojovnik2, Kostka kostka) {
        this.bojovnik1 = bojovnik1;
        this.bojovnik2 = bojovnik2;
        this.kostka = kostka;
    }
    private void vykresli() {
        System.out.println("\n-------------- Zacatek kola-------------- \n");
        System.out.println("Bojovnici: \n");
        vypisBojovnika(bojovnik1);
        vypisBojovnika(bojovnik2);
    }
    private void vypisBojovnika(Bojovnik a) {
        System.out.println(a);
        System.out.print("Zivot: ");
        System.out.println(a.grafickyZivot());
        if (a instanceof Mag) {
            System.out.print("Mana: ");
            System.out.println(((Mag) a).grafickyMana());
        }
    }
    private void vypisZpravu(String zprava) {
        System.out.println(zprava);
        /** zpozdi to */
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            System.err.println("Chyba, nepovedlo se uspat vlákno");
        }
    }
    public void zapas() {
        /** původní pořadí */
        Bojovnik b1 = bojovnik1;
        Bojovnik b2 = bojovnik2;
        System.out.println("Vítejte v aréně!");
        System.out.printf("Dnes se utkají %s s %s! \n\n", bojovnik1, bojovnik2);
        // prohození bojovníků
        boolean zacinaBojovnik2 = (kostka.hod() <= kostka.vratPocetSten() / 2);
        if (zacinaBojovnik2) {
            b1 = bojovnik2;
            b2 = bojovnik1;
        }
        System.out.printf("Začínat bude bojovník %s! \n\nZápas může začít...", b1);

        /** cyklus s bojem */
        while (b1.nazivu() && b2.nazivu()) {
            b1.utoc(b2);
            vykresli();
            vypisZpravu(b1.vratPosledniZpravu()); // zpráva o útoku
            vypisZpravu(b2.vratPosledniZpravu()); // zpráva o obraně
            System.out.println("-------------- Konec kola -------------- \n");
            System.out.println("Write your bets!");
            if (b2.nazivu()) {
                b2.utoc(b1);
                vykresli();
                vypisZpravu(b2.vratPosledniZpravu()); // zpráva o útoku
                vypisZpravu(b1.vratPosledniZpravu()); // zpráva o obraně
            }
            System.out.println();
            System.out.println("-------------- Konec kola -------------- \n");
        }
    }
}

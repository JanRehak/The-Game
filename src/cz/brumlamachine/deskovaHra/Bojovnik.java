package cz.brumlamachine.deskovaHra;

import java.util.Scanner;

public class Bojovnik {

    Scanner scanner = new Scanner(System.in);

    /** Jméno bojovníka */
    protected String jmeno;
    /** Život v HP */
    protected int zivot;
    /** Maximální zdraví */
    protected int maxZivot;
    /** Útok v HP */
    protected int utok;
    /** Obrana v HP */
    protected int obrana;
    /** Instance hrací kostky */
    protected Kostka kostka;
    private String zprava;

    public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka) {
        this.jmeno = jmeno;
        this.zivot = zivot;
        this.maxZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
    }

    @Override
    public String toString() {
        return jmeno;
    }

    public boolean nazivu() {
        /** funkce boolean (true or false)
         * vrati bud true , pokud zivotu vice nez nula, nebo vrati false, pokud zivotu mene nebo rovno nule
         * zkraceny zapis ifu, protoze v zavorce uz je podminka*/
        return (zivot > 0);
    }

    protected String grafickyUkazatel(int aktualni, int maximalni) {
        String s = "[";
        int celkem = 20;
        double pocet = Math.round(((double)aktualni / maximalni) * celkem);
        if ((pocet == 0) && (nazivu())) {
            pocet = 1;
        }
        for (int i = 0; i < pocet; i++) {
            s += "#"; // s= s + "#"
        }
        for (int i = 0; i < celkem - pocet; i++) {
            s += " "; // s= s + " "
        }
        s += "]";
        return s;
    }

    public String grafickyZivot () {
        return grafickyUkazatel(zivot, maxZivot);
    }

    public void branSe(int uder) {
        /** nova promenna zraneni - je to uder minus obrana plus nahodny hod kostkou*/
        int zraneni = uder - (obrana + kostka.hod());
        /** jestli je zraneni vetsi nez nula, tak nova hodnota zivotu je zivot minus zraneni, pokud je vysledny zivot mensi
         * nez nula, dorovname na nulu. v tomto pripade se nam nic nedeje, pokud je zraneni v zapornem (jinak by se to pricitalo) */
        if (zraneni > 0) {
            zivot -= zraneni;
            zprava = String.format("%s utrpěl poškození %s hp", jmeno, zraneni);
            if (zivot <= 0) {
                zivot = 0;
                zprava += " a zemřel.";
            }
        }
            else {
            zprava = String.format("%s odrazil útok", jmeno);
        }
            nastavZpravu(zprava);
    }

    /** metoda utoc, parametr je instance Bojovnika
      */
    public void utoc(Bojovnik souper) {
        int hod = kostka.hod();
        int uder = utok + hod;
        nastavZpravu(String.format("%s útočí s úderem za %s hp", jmeno, uder));
        souper.branSe(uder);
    }
    protected void nastavZpravu(String zprava) {
        this.zprava = zprava;
    }
    public String vratPosledniZpravu() {
        return zprava;
    }
}

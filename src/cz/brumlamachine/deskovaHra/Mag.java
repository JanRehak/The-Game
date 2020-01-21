package cz.brumlamachine.deskovaHra;

public class Mag extends Bojovnik {
    /** Mana v mp (mana points) */
    private int mana;
    /** Maximalni mana, hodnota plne many */
    private int maxMana;
    /** Magicky utok v HP */
    private int magickyUtok;

    public Mag(String jmeno, int zivot, int utok, int obrana, Kostka kostka, int mana, int maxMana, int magickyUtok) {
        super(jmeno, zivot, utok, obrana, kostka);
        this.mana = mana;
        this.maxMana = maxMana;
        this.magickyUtok = magickyUtok;
    }
    @Override
    public void utoc(Bojovnik souper) {
        int uder = 0;
        // Mana není naplněna - pricte se 10
        if (mana < maxMana) {
            mana += 10;
            /** pokud se pricetlo vice nez je maxMana, tak se hodnoty dorovnaji*/
            if (mana > maxMana) {
                mana = maxMana;
            }
            /** misto znovu napsani metody jsem zavolal starou metodu utoc, kterou dedim z predka, tedy Bojovnika*/
            super.utoc(souper);
        }
        else { // Magický útok
            uder = magickyUtok + kostka.hod();
            nastavZpravu(String.format("%s použil magii za %s hp", jmeno, uder));
            mana = 0;
        }
        souper.branSe(uder);
    }

    public String grafickyMana() {
        return grafickyUkazatel(mana, maxMana);
    }
}

package cz.brumlamachine.deskovaHra;

public class GrafickyUkazatel {

    private static final int DELKA_UKAZATELE = 20;
    private final int aktualni;
    private final int celkovy;

    public static void main(String[] args) {
        System.out.println(new GrafickyUkazatel(0,40));
        System.out.println(new GrafickyUkazatel(1,40));
        System.out.println(new GrafickyUkazatel(20,40));
        System.out.println(new GrafickyUkazatel(40,40));
    }

    public GrafickyUkazatel(int aktualni, int celkovy) {
        if(aktualni > celkovy) {
            throw new IllegalArgumentException("Chybne zadani");
        }
        this.aktualni = aktualni;
        this.celkovy = celkovy;
    }

    public int vypoctiPocetDilku() {
        final int dilku = (int) Math.ceil(DELKA_UKAZATELE * ((float) aktualni / (float) celkovy));
        return dilku;
    }

    @Override
    public String toString() {
        int dilku = vypoctiPocetDilku();
        int prazdnych = DELKA_UKAZATELE - dilku;
        return "[" + ("#".repeat(dilku)) + (" ".repeat(prazdnych)) + "]";
    }

}

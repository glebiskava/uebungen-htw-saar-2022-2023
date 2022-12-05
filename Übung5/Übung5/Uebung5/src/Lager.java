import java.util.Scanner;

public class Lager {

    private final int MAX_ANZAHL         = 10;
    private static Artikel[] lager;

    public Lager () {

        lager = new Artikel[MAX_ANZAHL];
    }

    public Lager (int artikelMaxAnzahl) {
        ErrorCheck.checkArrayGroesse(artikelMaxAnzahl);

        lager = new Artikel[artikelMaxAnzahl];
    }



    public static void legeAnArtikel (Artikel artikel) {
        //checks
        for (int x = 0; x <= lager.length; x++) {
            if (lager[x] == null) {
                lager[x] = artikel;
                break;
            }
        }
    }

    public static void entferneArtikel (int artikelNr) {
        //checks
        for (int x = 0; x <= lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x] = null;
                break;
            }
        }
    }

    public static void bucheZugang (int artikelNr, int zugang) {
        //checks
        for (int x = 0; x <= lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].bucheZugang(zugang);
                break;
            }
        }
    }

    public static void bucheAbgang (int artikelNr, int abgang) {
        //checks
        for (int x = 0; x <= lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].bucheAbgang(abgang);
                break;
            }
        }
    }

    public static void aenderePreisEinesArtikels (int artikelNr, double prozent) {
        //checks
        for (int x = 0; x < lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].setPreis(lager[x].getPreis() * (1.0 + prozent / 100.0));
                break;
            }
        }
    }

    public static void aenderePreisAllerArtikel (double prozent) {
        //checks
        for (int x = 0; x <= lager.length; x++) {
            if (lager[x] != null) {
                lager[x].setPreis(lager[x].getPreis() * (1.0 + prozent / 100));
            }
        }
    }

    public static Artikel getArtikel(int index) {
        // checks
        return lager[index];
    }

    public String toString(){
        String output = "";

        for (int i = 0; i < lager.length; i++) {
            output = output + "(Position" + i + ": ";
            if (lager[i] == null) {
                output = output + "null" + ")\n";
            } else {
                output = output + lager[i].toString() + "]\n";
            }
        }
        return output;
    }

    public static int getArtikelAnzahl() {
        // checks
        int anzahl = 0;

        for (int x = 0; x <= lager.length; x++) {
            if (lager[x] != null) {
                anzahl += 1;
            }
        } return anzahl;
    }

    public static int getLagerGroesse() {
        return lager.length;
    }


}
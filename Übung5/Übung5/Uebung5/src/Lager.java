import java.util.Scanner;

public class Lager {

    private final int MAX_ANZAHL         = 10;
    private Artikel[] lager;

    public void Lager (int artikelMaxAnzahl) {
        ErrorCheck.checkArrayGroesse(artikelMaxAnzahl);

        lager = new Artikel[artikelMaxAnzahl];

    }

    public void Lager () {

        lager = new Artikel[MAX_ANZAHL];
    }

    public void legeAnArtikel (Artikel artikel) {

        for (int x = 0; x <= lager.length; x++) {
            if (lager[x] == null) {
                lager[x] = artikel;
                break;
            }
        }
    }

    /*public void entferneArtikel (int artikelNr) {
        for (int x = 0; x <= lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {

            }
        }
    }*/

    public void bucheZugang (int artikelNr, int zugang) {

        for (int x = 0; x <= lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].bucheZugang(zugang);
                break;
            }
        }
    }

    public void bucheAbgang (int artikelNr, int abgang) {

        for (int x = 0; x <= lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].bucheAbgang(abgang);
                break;
            }
        }
    }

    public void aenderePreisEinesArtikels (int artikelNr, double prozent) {
        for (int x = 0; x < lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].setPreis(lager[x].getPreis() * (1.0 + prozent / 100.0));
                break;
            }
        }
    }

    public void aenderePreisEinesArtikels (double prozent) {
        for (int x = 0; x < lager.length; x++) {
            if (lager[x] != null) {
                lager[x].setPreis(lager[x].getPreis() * (1.0 + prozent / 100));
            }
        }
    }


}
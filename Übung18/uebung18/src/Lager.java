import java.util.Scanner;
/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class Lager {

    public static Artikel[] lager;

    /**
     * zwei konstruktoren --> einer mit waehlbarer Laenge des Arrays und ein Standardkonstruktor
     */
    public Lager () {

        int MAX_ANZAHL = 10;
        lager = new Artikel[MAX_ANZAHL];
    }

    public Lager (int artikelMaxAnzahl) {
        ErrorCheck.checkArrayGroesse(artikelMaxAnzahl);

        lager = new Artikel[artikelMaxAnzahl];
    }


    /**
     * diese Methode dient dazu ein vorher angelegtes Artikel-Objekt in das Artikel-Array
     * des Lagers einzufuegen
     * Prueft auf fehlerhafte Eingaben
     * @param artikel das angelegte objekt
     */
    public static void legeAnArtikel (Artikel artikel) {
        ErrorCheck.checkObLagerVoll(lager);

        for (int x = 0; x < lager.length; x++) {
            if (lager[x] == null) {
                lager[x] = artikel;
                break;
            }
        }
    }


    /**
     * Diese Methode dient zuk Entfernen eines Artikels aus dem Lager
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     */
    public static void entferneArtikel (int artikelNr) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelNr, lager);
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkLagerLeer(lager);

        for (int x = 0; x < lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x] = null;
                break;
            }
        }
    }

    /**
     * dient dazu Zugang zu buchen fuer einen Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     * @param zugang wie viel zugebucht werden soll
     */
    public static void bucheZugang (int artikelNr, int zugang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelNr, lager);
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkLagerLeer(lager);

        for (int x = 0; x < lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].bucheZugang(zugang);
                break;
            }
        }
    }

    /**
     * dient dazu Abgang zu buchen fuer einen Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     * @param abgang wie viel abgebucht werden soll
     */
    public static void bucheAbgang (int artikelNr, int abgang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelNr, lager);
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkLagerLeer(lager);

        for (int x = 0; x < lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].bucheAbgang(abgang);
                break;
            }
        }
    }

    /**
     * Andert den Preis fuer einen einzigen Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     * @param prozent wie viel abgebucht werden soll
     */
    public static void aenderePreisEinesArtikels (int artikelNr, double prozent) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelNr, lager);
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkLagerLeer(lager);

        for (int x = 0; x < lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                lager[x].setPreis(lager[x].getPreis() * (1.0 + prozent / 100.0));
                break;
            }
        }
    }

    /**
     * Andert den Preis fuer alle Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param prozent um wei viel prozent der Preis erhoeht oder erniedrigt werden soll
     */
    public static void aenderePreisAllerArtikel (double prozent) {
        ErrorCheck.checkLagerLeer(lager);

        for (Artikel artikel : lager) {
            if (artikel != null) {
                artikel.setPreis(artikel.getPreis() * (1.0 + prozent / 100));
            }
        }
    }

    /**
     * Ermittelt einen Artikel an einer bestimmten Stelle im Lager
     * Prueft auf fehlerhafte Eingaben
     * @param index position im Lager
     */
    public static Artikel getArtikel(int index) {
        ErrorCheck.checkLagerLeer(lager);
        ErrorCheck.checkNullIndex(lager, index);
        ErrorCheck.checkRangeOfIndex(index, lager.length);

        return lager[index];
    }

    /**
     * gibt ein Objekt als String aus
     */
    public String toString(){
        ErrorCheck.checkLagerLeer(lager);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < lager.length; i++) {
            output.append("(Position").append(i).append(": ");
            if (lager[i] == null) {
                output.append("null").append(")\n");
            } else {
                output.append(lager[i].toString()).append(")\n");
            }
        }
        return "[" + output + "]";
    }

    /**
     * Bestimmt die aktuelle Anzahl der Artikel im Lager
     * Prueft auf fehlerhafte Eingaben
     */
    public static int getArtikelAnzahl() {
        ErrorCheck.checkLagerLeer(lager);

        int anzahl = 0;

        for (Artikel artikel : lager) {
            if (artikel != null) {
                anzahl += 1;
            }
        }
        return anzahl;
    }

    /**
     * Bestimmt die Anzahl der Artikel, die ins Lager gelegt werden koennen
     */
    public static int getLagerGroesse() {
        return lager.length;
    }


}
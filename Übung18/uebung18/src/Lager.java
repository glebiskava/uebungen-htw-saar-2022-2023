
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class Lager {

    public static Artikel[] lager;
    private int lagerLength = 0;

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
    public void legeAnArtikel(Artikel artikel) {
        ErrorCheck.checkObLagerVoll(lager);

        for (int x = 0; x < lager.length; x++) {
            if (lager[x] == null) {
                lager[x] = artikel;
                lagerLength++;
                break;
            }
        }
    }


    /**
     * Diese Methode dient zuk Entfernen eines Artikels aus dem Lager
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     */
    public  void entferneArtikel (int artikelNr) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelNr, lager);
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkLagerLeer(lager);

        for (int x = 0; x < lager.length; x++) {
            if (artikelNr == lager[x].getArtikelNr()) {
                for (int y = x; y < lager.length - 1; y++) {
                    lager[y] = lager[y + 1];
                }
                lager[lager.length - 1] = null;
                lagerLength--;
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
    public  void bucheZugang (int artikelNr, int zugang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelNr, lager);
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkLagerLeer(lager);

        for (Artikel artikel : lager) {
            if (artikelNr == artikel.getArtikelNr()) {
                artikel.bucheZugang(zugang);
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
    public  void bucheAbgang (int artikelNr, int abgang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelNr, lager);
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkLagerLeer(lager);

        for (Artikel artikel : lager) {
            if (artikelNr == artikel.getArtikelNr()) {
                artikel.bucheAbgang(abgang);
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
    public  void aenderePreisEinesArtikels (int artikelNr, double prozent) {
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
    public  void aenderePreisAllerArtikel (double prozent) {
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
    public  Artikel getArtikel(int index) {
        ErrorCheck.checkLagerLeer(lager);
        ErrorCheck.checkNullIndex(lager, index);
        ErrorCheck.checkRangeOfIndex(index, lager.length);

        return lager[index];
    }

    /**
     * Methode, welche die Artikel im Lager als sortiertes Array
     * zurückgibt
     * @param sortCrit Sortier-Kriterium
     * @return sortiertes Array
     */

    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> sortCrit) {

        for(int i = 0; i < lagerLength; i++) {
            for(int j = 0; j < lagerLength - 1; j++) {
                if(sortCrit.test(lager[j + 1], lager[j])) {
                    Artikel temp = lager[j];
                    lager[j] = lager[j + 1];
                    lager[j + 1] = temp;
                }
            }
        }
        return lager;
    }
    

    /**
     * Methode die eine an die Methode übergebene
     * Operation auf alle Artikel im Lager anwendet
     * @param operation Operation die angewendet wird
     */
    public void applyToArticles(Consumer<Artikel> operation) {
        for (Artikel artikel : lager) {
            if (artikel != null) {
                operation.accept(artikel);
            }
        }
    }

    

    /**
     * Methode, die eine Operation auf die Artikel
     * anwendet, welche ein bestimmtes Kriterium erfüllen
     * @param filterCrit filter kriterium
     * @param operation operation die angewendet wird
     */
    public void applyToSomeArticles(Predicate<Artikel> filterCrit, Consumer<Artikel> operation) {
        for (Artikel artikel : lager) { // boucle sur tous les articles
            if (artikel != null && filterCrit.test(artikel)) { // si l'article match le critère
                operation.accept(artikel); 
            }
        }
    }

    /**
     * Methode, die eine sortierte Liste der Artikel zurück-
     * gibt, welche ein bestimmtes Suchkriterium erfüllen
     * @param searchCrit such kriterium
     * @param sortCrit sortier kriterium
     * @return array mit gematchten Artikeln
     */
    public List<Artikel> getArticles(Predicate<Artikel> searchCrit, Comparator<Artikel> sortCrit) {
        List<Artikel> matchingArticles = new ArrayList<>();

        for (Artikel artikel : lager) {
            if (searchCrit.test(artikel)) {
                matchingArticles.add(artikel);
            }
        }

        matchingArticles.sort(sortCrit);

        return matchingArticles;
    }

     /**
     * Methode die alle Artikel des Lagers zurückgibt,
     * welche ein bestimmtes Filterkriterium erfüllen
     * @param filterCrit Filter Kriterium
     * @return gefiltertes Array
     */
    public Artikel[] filter(Predicate<Artikel> filterCrit, Artikel[] filteredArticles) {
        int count = 0;

        for (int i = 0; i < filteredArticles.length; i++) {
            if (filterCrit.test(filteredArticles[i])) {
                count++;
            }
        }

        Artikel[] filteredArray = new Artikel[count];
        int index = 0;

        for (int i = 0; i < filteredArticles.length; i++) {
            if (filterCrit.test(filteredArticles[i])) {
                filteredArray[index] = filteredArticles[i];
                index++;
            }
        }

        return filteredArray;
    }

    /**
     * Methode, die eine beliebige Menge an Filterkriterien als
     * Parameter entgegennimmt und die Artikel des Lagers zurückgibt, die alle Filterkriterien er-
     * füllen
     * @param filterCrit filterkriterien als argumenten variablen Parameterliste
     * @return array mit gematchten Artikeln
     */
    public Artikel[] filterAll(Predicate<Artikel>... filterCrit) {
        Artikel[] filteredArticles = this.lager;

        for (Predicate<Artikel> crit : filterCrit) {
            filteredArticles = filter(crit, filteredArticles);
        }

        return filteredArticles;
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
    public  int getArtikelAnzahl() {
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
    public  int getLagerGroesse() {
        return lager.length;
    }


}
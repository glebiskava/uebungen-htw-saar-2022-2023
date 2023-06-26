
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

    /**
     * Map die die Artikel verwaltet
     */
    private Map<Integer, Artikel> artikelMap;

    /**
     * Standardkonstruktor
     */
    public Lager () {
        artikelMap = new LinkedHashMap<>();
    }

    /**
     * diese Methode dient dazu ein vorher angelegtes Artikel-Objekt in das Artikel-Array
     * des Lagers einzufuegen
     * Prueft auf fehlerhafte Eingaben
     * @param artikel das angelegte objekt
     */
    public void legeAnArtikel(Artikel artikel) {
            ErrorCheck.checkAlreadyInLager(artikelMap, artikel);
            artikelMap.put(artikel.getArtikelNr(), artikel);
    }

    /**
     * Diese Methode dient zuk Entfernen eines Artikels aus dem Lager
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     */
    public void entferneArtikel (int artikelNr) {
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);

        artikelMap.remove(artikelNr);
    }

    /**
     * dient dazu Zugang zu buchen fuer einen Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     * @param zugang wie viel zugebucht werden soll
     */
    public  void bucheZugang (int artikelNr, int zugang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        artikelMap.get(artikelNr).bucheZugang(zugang);
    }

    /**
     * dient dazu Abgang zu buchen fuer einen Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     * @param abgang wie viel abgebucht werden soll
     */
    public void bucheAbgang (int artikelNr, int abgang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        artikelMap.get(artikelNr).bucheAbgang(abgang);
    }

    /**
     * Andert den Preis fuer einen einzigen Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktion des Artikels
     * @param prozent wie viel abgebucht werden soll
     */
    public void aenderePreisEinesArtikels (int artikelNr, double prozent) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        artikelMap.get(artikelNr).setPreis(artikelMap.get(artikelNr).getPreis() * (1.0 + prozent / 100.0));
    }

    /**
     * Andert den Preis fuer alle Artikel
     * Prueft auf fehlerhafte Eingaben
     * @param prozent um wei viel prozent der Preis erhoeht oder erniedrigt werden soll
     */
    public void aenderePreisAllerArtikel (double prozent) {
        for (Artikel artikel : artikelMap.values()) {
            artikel.setPreis(artikel.getPreis() * (1.0 + prozent / 100));
        }
    }

    /**
     * Ermittelt einen Artikel an einer bestimmten Stelle im Lager
     * Prueft auf fehlerhafte Eingaben
     * @param artikelNr identifiaktionnummer des Artikels
     */
    public Artikel getArtikel(int artikelNr) { //changed argument from index to artikelNr
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        return artikelMap.get(artikelNr);
    }
    

    /**
     * Methode die eine an die Methode übergebene
     * Operation auf alle Artikel im Lager anwendet
     * @param operation Operation die angewendet wird
     */
    public void applyToArticles(Consumer<Artikel> operation) {
        for (Artikel artikel : artikelMap.values()) {
            operation.accept(artikel);
        }
    }

    

    /**
     * Methode, die eine Operation auf die Artikel
     * anwendet, welche ein bestimmtes Kriterium erfüllen
     * @param filterCrit filter kriterium
     * @param operation operation die angewendet wird
     */
    public void applyToSomeArticles(Predicate<Artikel> filterCrit, Consumer<Artikel> operation) {
        for (Artikel artikel : artikelMap.values()) {
            if (filterCrit.test(artikel)) {
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

        for (Artikel artikel : artikelMap.values()) {
            if (searchCrit.test(artikel)) {
                matchingArticles.add(artikel);
            }
        }

        matchingArticles.sort(sortCrit);
        return matchingArticles;
    }

    /**
     * gibt die Anzahl der Artikel im Lager zurück mit artikeln info
     * @Override toString() in class Object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double gesamtWert = 0;
        
        sb.append(String.format("%-6s%-43s%-9s%-9s%6s", "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt"));
        sb.append("\n");
        sb.append("---------------------------------------------------------------------------");
        sb.append("\n");
        
        for (Artikel artikel : artikelMap.values()) {
            if (artikel != null) {
                int artNr = artikel.getArtikelNr();
                String art = artikel.getArt();
                double preis = artikel.getPreis();
                int bestand = artikel.getBestand();
                double gesamtPreis = preis * bestand;
                gesamtWert += gesamtPreis;

                sb.append(String.format("%-6d%-43s%-9s%-9d%-6s", artNr, art, preis, bestand, gesamtPreis));
                sb.append("\n");
            }
        }
    
        sb.append("---------------------------------------------------------------------------");
        sb.append("\n");
        sb.append(String.format("Gesamtwert%62s", gesamtWert));
        
        return sb.toString();
    }

    /**
     * Bestimmt die aktuelle Anzahl der Artikel im Lager
     * Prueft auf fehlerhafte Eingaben
     */
    public int getArtikelAnzahl() {
        return artikelMap.size();
    }

    /**
     * Gibt die ArtikelMap zurueck
     */
    public Map<Integer, Artikel> getArtikelMap() {
        return artikelMap;
    }

    public static void main(String[] args){
        Lager lager = new Lager();
        System.out.println("Ein neues Lager wurde erstellt");

        CD Cd = new CD(1111, 1, 1, "ja", "1", 1);
        lager.legeAnArtikel(Cd);
        System.out.println("Ein neuer Cd Artikel wurde erstellt");

        Video Video = new Video(2222, 2, 2, "artikelTitel", 2, 2000);
        lager.legeAnArtikel(Video);
        System.out.println("Ein neuer Video Artikel wurde erstellt");

        Buch Buch = new Buch(3333, 3, 3, "artikelTitel", "artikelAuthor", "verlag");
        lager.legeAnArtikel(Buch);
        System.out.println("Ein neuer Buch Artikel wurde erstellt");

        Artikel artikel = new Artikel(4444, "art", 4, 4);
        lager.legeAnArtikel(artikel);
        System.out.println("Ein neuer Artikel wurde erstellt");

        lager.entferneArtikel(2222);
        System.out.println("Der Artikel mit der Artikelnummer 2222 wurde entfernt");

        lager.bucheZugang(1111, 1);
        System.out.println("Der Artikel mit der Artikelnummer 1111 wurde um 1 erhoeht");

        lager.bucheAbgang(3333, 1);
        System.out.println("Der Artikel mit der Artikelnummer 3333 wurde um 1 erniedrigt");

        lager.aenderePreisEinesArtikels(4444, 10);
        System.out.println("Der Artikel mit der Artikelnummer 4444 wurde um 10% erhoeht");

        lager.aenderePreisAllerArtikel(10);
        System.out.println("Alle Artikel wurden um 10% erhoeht");

        System.out.println("Die Anzahl der Artikel im Lager betraegt: " + lager.getArtikelAnzahl());
    
        System.out.println(lager.toString());

        lager.entferneArtikel(1111);
        System.out.println("Der Artikel mit der Artikelnummer 1111 wurde entfernt");
        lager.entferneArtikel(3333);
        System.out.println("Der Artikel mit der Artikelnummer 3333 wurde entfernt");
        lager.entferneArtikel(4444);
        System.out.println("Der Artikel mit der Artikelnummer 4444 wurde entfernt");

        System.out.println("Die Anzahl der Artikel im Lager betraegt: " + lager.getArtikelAnzahl());

        System.out.println(lager.toString());
        
    }
}
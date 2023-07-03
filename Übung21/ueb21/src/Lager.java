import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public Lager() {
        artikelMap = new LinkedHashMap<>();
    }

    /**
     * diese Methode dient dazu ein vorher angelegtes Artikel-Objekt in das Artikel-Array
     * des Lagers einzufuegen
     * Prueft auf fehlerhafte Eingaben
     *
     * @param artikel das angelegte objekt
     */
    public void legeAnArtikel(Artikel artikel) {
        ErrorCheck.checkAlreadyInLager(artikelMap, artikel);
        artikelMap.put(artikel.getArtikelNr(), artikel);
    }

    /**
     * Diese Methode dient zuk Entfernen eines Artikels aus dem Lager
     * Prueft auf fehlerhafte Eingaben
     *
     * @param artikelNr identifiaktion des Artikels
     */
    public void entferneArtikel(int artikelNr) {
        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);

        artikelMap.remove(artikelNr);
    }

    /**
     * dient dazu Zugang zu buchen fuer einen Artikel
     * Prueft auf fehlerhafte Eingaben
     *
     * @param artikelNr identifiaktion des Artikels
     * @param zugang    wie viel zugebucht werden soll
     */
    public void bucheZugang(int artikelNr, int zugang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        artikelMap.get(artikelNr).bucheZugang(zugang);
    }

    /**
     * dient dazu Abgang zu buchen fuer einen Artikel
     * Prueft auf fehlerhafte Eingaben
     *
     * @param artikelNr identifiaktion des Artikels
     * @param abgang    wie viel abgebucht werden soll
     */
    public void bucheAbgang(int artikelNr, int abgang) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        artikelMap.get(artikelNr).bucheAbgang(abgang);
    }

    /**
     * Andert den Preis fuer einen einzigen Artikel
     * Prueft auf fehlerhafte Eingaben
     *
     * @param artikelNr identifiaktion des Artikels
     * @param prozent   wie viel abgebucht werden soll
     */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        artikelMap.get(artikelNr).setPreis(artikelMap.get(artikelNr).getPreis() * (1.0 + prozent / 100.0));
    }

    /**
     * Andert den Preis fuer alle Artikel
     * Prueft auf fehlerhafte Eingaben
     *
     * @param prozent um wei viel prozent der Preis erhoeht oder erniedrigt werden soll
     */
    public void aenderePreisAllerArtikel(double prozent) {
        for (Artikel artikel : artikelMap.values()) {
            artikel.setPreis(artikel.getPreis() * (1.0 + prozent / 100));
        }
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

    // --------------------------------- hinzugefügte Methoden aus Uebung 18 ---------------------------------

    /**
     * Gibt ein Array von Artikel-Objekten zurück, das basierend auf dem angegebenen Sortierkriterium sortiert ist.
     *
     * @param sortCriterion Das Sortierkriterium, das durch ein BiPredicate definiert
     *                      wird und zwei Artikel-Objekte vergleicht.
     * @return Das sortierte Array von Artikel-Objekten.
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> sortCriterion) {
        return artikelMap.values().stream()
                .sorted(Comparator.comparing((Artikel artikel) -> artikel, (a1, a2) -> {
                    if (sortCriterion.test(a1, a2)) {
                        return -1;
                    } else if (sortCriterion.test(a2, a1)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }))
                .toArray(Artikel[]::new);
    }

    /**
     * Wendet die angegebene Operation auf alle Artikel-Objekte im Lager an.
     *
     * @param operation Die Operation, die auf jedes Artikel-Objekt angewendet werden soll.
     */
    public void applyToArticles(Consumer<Artikel> operation) {
        for (Artikel artikel : artikelMap.values()) {
            operation.accept(artikel);
        }
    }

    /**
     * Ruft das Artikel-Objekt mit der angegebenen artikelNr aus dem Lager ab.
     *
     * @param artikelNr Die Identifikationsnummer des Artikel-Objekts.
     * @return Das Artikel-Objekt mit der angegebenen artikelNr.
     */
    public Artikel getArtikel(int artikelNr) {
        ErrorCheck.checkIfNotAlreadyInLager(artikelMap, artikelNr);
        ErrorCheck.checkArtikelNr(artikelNr);

        return artikelMap.get(artikelNr);
    }

    /**
     * Filtert und gibt eine Liste von Artikel-Objekten zurück, die das angegebene Filterkriterium erfüllen.
     *
     * @param filterCriterion Das Filterkriterium, das durch ein Predicate definiert wird und jedes Artikel-Objekt testet.
     * @return Die gefilterte Liste von Artikel-Objekten.
     */
    public List<Artikel> filter(Predicate<Artikel> filterCriterion) {
        return artikelMap.values().stream()
                .filter(filterCriterion)
                .collect(Collectors.toList());
    }

    /**
     * Wendet die angegebene Operation auf die Artikel-Objekte an, die das angegebene Filterkriterium erfüllen.
     *
     * @param filterCriterion Das Filterkriterium, das durch ein Predicate definiert wird und jedes Artikel-Objekt testet.
     * @param operation       Die Operation, die auf die passenden Artikel-Objekte angewendet werden soll.
     */
    public void applyToSomeArticles(Predicate<Artikel> filterCriterion, Consumer<Artikel> operation) {
        artikelMap.values().stream()
                .filter(filterCriterion)
                .forEach(operation);
    }

    /**
     * Ruft eine sortierte Liste von Artikel-Objekten ab, die das angegebene Suchkriterium erfüllen.
     *
     * @param searchCriterion Das Suchkriterium, das durch ein Predicate definiert wird und jedes Artikel-Objekt testet.
     * @param sortCriterion   Das Sortierkriterium, das durch ein Comparator definiert wird und Artikel-Objekte vergleicht.
     * @return Die sortierte Liste der passenden Artikel-Objekte.
     */
    public List<Artikel> getArticles(Predicate<Artikel> searchCriterion, Comparator<Artikel> sortCriterion) {
        return artikelMap.values().stream()
                .filter(searchCriterion)
                .sorted(sortCriterion)
                .toList();
    }

    /**
     * Filtert und gibt eine Liste von Artikel-Objekten zurück, die alle angegebenen Filterkriterien erfüllen.
     *
     * @param filterCriteria Die Filterkriterien, die durch ein Array von Predicates definiert werden und jedes Artikel-Objekt testen.
     * @return Die gefilterte Liste von Artikel-Objekten.
     */
    public List<Artikel> filterAll(Predicate<Artikel>[] filterCriteria) {
        return artikelMap.values().stream()
                .filter(article -> Arrays.stream(filterCriteria).allMatch(criteria -> criteria.test(article)))
                .toList();
    }

    /**
     * gibt die Anzahl der Artikel im Lager zurück mit artikeln info
     *
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

                String formatPreis = String.format("%.2f", preis);
                String formatGesamtpreis = String.format("%.2f", gesamtPreis);

                sb.append(String.format("%-6d%-43s%-9s%-9d%-6s", artNr, art, formatPreis, bestand, formatGesamtpreis));
                sb.append("\n");
            }
        }

        sb.append("---------------------------------------------------------------------------");
        sb.append("\n");
        sb.append(String.format("Gesamtwert: %.2f", gesamtWert ));

        return sb.toString();
    }
}
import java.util.function.BiPredicate;

/**
 * <p>Diese Klasse ist eine Fassade, hinter der Sie Ihre Loesung verstecken. Der Test ruft nur die hier definierten
 * Schnittstellenmethoden auf. Loeschen Sie bitte keine Methoden. Wenn Sie eine Methode nicht implementieren
 * moechten, lassen Sie bitte die leere Implementierung stehen. Innerhalb der Methoden und in allen anderen Klassen,
 * die Sie noch benoetigen, haben Sie alle Freiheiten.</p>
 *
 * <p>Wenn Sie Ihre Loesung mit JUnit testen moechten, testen Sie diese Schnittstellenmethoden.</p>
 * @author christopher
 *
 */
public class Ueb18Fassade {
    /**
     * Loest die Aufgabe (c) i.
     * <br />
     * Sortierung nach den folgenden Kriterien:
     * <ol>
     * 	<li>Unterkategorie (alphabetisch)</li>
     * 	<li>Bestand</li>
     * 	<li>Preis</li>
     * </ol>
     * @param lager Das Lager mit der unsortierten Artikelliste.
     * @return Die sortierte Artikelliste.
     */
    public Artikel[] aufgabe_c_i(Lager lager) {

        BiPredicate<Artikel, Artikel> Art = (artikel1, artikel2) ->{
             return (artikel1.getArt()).compareTo(artikel2.getArt()) < 0;};
        // (artikel1.getArt()).compareTo(artikel2.getArt()) renvoie un int, si il est négatif alors artikel1 est plus petit que artikel2 
        // cela est ensuite converti en boolean (<0 = true, >0 = false)
        // cela compare les deux articles sous forme de string et retourne true si artikel1 est plus petit que artikel2

        BiPredicate<Artikel, Artikel> Bestand = (artikel1, artikel2) ->{ return (artikel1.getBestand()) < (artikel2.getBestand());};

        BiPredicate<Artikel, Artikel> Preis = (artikel1, artikel2) ->{ return (artikel1.getPreis()) < (artikel2.getPreis());};

        BiPredicate<Artikel, Artikel> Sort = (artikel1, artikel2) -> {
            // System.out.println("Nr " + artikel1.getArtikelNr() + ", Nr2 " + artikel2.getArtikelNr() + "\n");
            return Art.test(artikel1, artikel2) ? true : 
            Bestand.test(artikel1, artikel2) ? true : 
            Preis.test(artikel1, artikel2) ? true : false;
        };

        return lager.getSorted(Sort);
        }

    /**
     * Loest die Aufgabe (c) ii.
     * <br />
     * Der Preis aller Artikel wird um 10% reduziert.
     * @param lager Das Lager mit den Artikeln, deren Preise geaendert werden sollen.
     */
    public void aufgabe_c_ii(Lager lager) {
        lager.applyToArticles(artikel -> {
            double neuerPreis = artikel.getPreis() * 0.9; // 10% Rabatt
            artikel.setPreis(neuerPreis);
        });

    }

    /**
     * Loest die Aufgabe (c) iii.
     * <br />
     * An alle Artikelbezeichnungen wird das Suffix (Sonderangebot) angehaengt.
     * @param lager Das Lager mit den Artikeln, deren Bezeichnungen geaendert werden sollen.
     */
    public void aufgabe_c_iii(Lager lager) {
        lager.applyToArticles(artikel -> {
            String neueBeschreibung = artikel.getArt() + " (Sonderangebot)";
            artikel.setArt(neueBeschreibung);
        });
    }

    /**
     * Loest die Aufgabe (c) iv.
     * <br />
     * Die beiden Operatoren aus den Aufgabenteilen ii und iii werden konkateniert, d.h. alle Preise werden
     * um 10 % reduziert und alle Bezeichnungen werden um das Suffix (Sonderangebot) erweitert.
     * @param lager Das Lager mit den Artikeln, deren Preise und Bezeichnungen geaendert werden sollen.
     */
    public void aufgabe_c_iv(Lager lager) {
        aufgabe_c_ii(lager);
        aufgabe_c_iii(lager);
        // lager.applyToArticles(artikel -> {
        //     double neuerPreis = artikel.getPreis() * 0.9; // 10% Rabatt
        //     artikel.setPreis(neuerPreis);

        //     String neueBeschreibung = artikel.getArt() + " (Sonderangebot)";
        //     artikel.setArt(neueBeschreibung);
        // });
    }

    /**
     * Loest die Aufgabe (h) i.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_i(Lager lager) {
        // lager.applyToSomeArticles(a -> a instanceof CD, a -> a.aenderePreis(10));
        // faut pas plutôt mettre ça ? : a -> a.setPreis(a.getPreis() * (1 + 10/100)) // +10%
        // ou bien on fait une fonction lambda qui fait les % mais jsp comment faire lol
    }

    /**
     * Loest die Aufgabe (h) ii.
     * <br />
     * Der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_ii(Lager lager) {
        // lager.applyToSomeArticles(a -> a.getBestand() <= 2, a -> a.aenderePreis(-5));
    }

    /**
     * Loest die Aufgabe (h) iii.
     * <br />
     * Der Preis der Buecher eines bestimmten Autors wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     * @param gesuchterAutor Der Autor, dessen Buecher guenstiger werden sollen.
     */
    public void aufgabe_h_iii(Lager lager, String gesuchterAutor) {
        // lager.applyToSomeArticles(a -> a instanceof Buch && ((Buch) a).getAuthor().equals(gesuchterAutor), a -> a.aenderePreis(-5));
    }

    /**
     * Loest die Aufgabe (h) iv.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht und der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_iv(Lager lager) {
        aufgabe_h_i(lager);
        aufgabe_h_ii(lager);
        // lager.applyToSomeArticles(a -> a instanceof CD, a -> a.aenderePreis(10));
        // lager.applyToSomeArticles(a -> a.getBestand() <= 2, a -> a.aenderePreis(-5));
    }

    /**
     * Loest die Aufgabe (h) v.
     * <br />
     * @param lager Das Lager mit den Artikeln.
     * @return Eine Liste mit allen Buechern, sortiert nach den Namen der Autoren.
     */
    public Artikel[] aufgabe_h_v(Lager lager) {
        
        return null;
    }

    /**
     * Loest die Aufgabe (h) vi.
     * <br />
     * @param lager Das Lager, dessen Artikel gefiltert werden sollen.
     * @param gesuchterAutor Der Autor, nach dem gefiltert werden soll.
     * @param minPreis Der kleinste Preis, den die zu filternden Buecher haben sollen.
     * @param maxPreis Der hoechste Preis, den die zu filternden Buecher haben sollen.
     * @return Alle Buecher vom Autor autor und mit einem Preis, der zwischen minPreis und maxPreis liegt.
     */
    public Artikel[] aufgabe_h_vi(Lager lager, String gesuchterAutor, double minPreis, double maxPreis) {
        return null;
    }
}
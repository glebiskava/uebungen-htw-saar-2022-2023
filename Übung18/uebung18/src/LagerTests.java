
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * dies ist eine Klasse zum testen der klasse lager
 */
public class LagerTests {
//    @BeforeEach
//    public void setup(){
//        // Before each test ein Lager Groesse 10 anlegen (default value)
//        Lager lager = new Lager();
//    }

    /**
     * Test für den ersten Konstruktor und ob die korrekte Lagergroesse uebergeben wurde
     */
    @Test
    public void test_erster_Konstruktor_And_Check_For_Lagergroesse_sollte_korrekt_sein() {
        // Erstellen eines neuen Lagerobjekt mithilfe des ersten Konstruktors
        Lager lager = new Lager(5);

        // Pruefen, ob die Attribute des Objekts korrekt gesetzt sind
        assertEquals(5, lager.getLagerGroesse());
    }

    /**
     * Test fuer den Konstruktor und ob die korrekte Lagergroesse uebergeben wurde
     * wenn kein Uebergabe aufgerufen wird
     */
    @Test
    public void test_zweiten_Konstruktor_And_Check_For_Lagergroesse_sollte_korrekt_sein() {
        // Pruefen, ob die Attribute des Objekts korrekt gesetzt sind
        Lager lager = new Lager(5);
        assertEquals(5, lager.getLagerGroesse());

    }

    /**
     * Test prueft ob ein Artikel richtig ins Lager steht
     */
    @Test
    public void test_lege_Artikel_ins_Lager_sollte_korrekt_sein() {
        Lager lager = new Lager(5);
        // Artikel anlegen
        Artikel artikel = new Artikel(9999, "Test artikel", 1000, 10.0);

        //Artikel ins Lager legen
        lager.legeAnArtikel(artikel);

        // Verwenden der Methode getArtikel, mit der attribut 0 der der Index repräs
        assertEquals(artikel, lager.getArtikel(0));
    }

    /**
     * Test prueft ob ein Artikel richtig ins Lager steht und dann ,dass der 
     * Artikel richtig gelöscht wird
     */
    @Test
    public void test_entferne_Artikel_ins_Lager_sollte_korrekt_sein() {
        Lager lager = new Lager(5);
        // Zwei Artikel anlegen mit verschiedene ArtikelNr
        Artikel artikel = new Artikel(1021, "Test artikel", 10, 10.0);
        Artikel artikel2 = new Artikel(1001, "Test artikel", 1, 10.0);

        // Beide Artikel ins Lager legen
        lager.legeAnArtikel(artikel);
        lager.legeAnArtikel(artikel2);

        // Verwenden der Methode getArtikel, mit der attribut 0 der der Index repräsentiert.
        // Um sicher zu sein, dass der Lager nicht Lehr ist
        assertEquals(artikel, lager.getArtikel(0));

        // Artikel von Lager löschen
        lager.entferneArtikel(1021);

        // Prüft ob der artikel gut geloescht ist
        assertEquals(1, lager.getArtikelAnzahl());
    }

    /**
     * Test fuer korrekten Zugang
     */
    @Test
    public void test_Buche_Zugang_sollte_korrekt_sein() {
        Lager lager = new Lager(5);
        // Artikel anlegen neues Artikel-Objekt mit Artikel-Startbestand von 10
        Artikel artikel = new Artikel(1210, "Test artikel", 10, 10.0);

        //Artikel ins Lager legen
        lager.legeAnArtikel(artikel);

        // Verwenden der Methode bucheZugang, um den Lagerbestand um 5 zu erhöhen
        lager.bucheZugang(1210, 5);

        // Feststellen, dass der neue Lagerbestand gleich 15 ist
        assertEquals(15, artikel.getBestand());
    }

    /**
     * Test erhoehung der Preis eines Artikels
     */
    @Test
    public void test_Preis_Eines_Artikels_Erhoehen_sollte_korrekt_sein() {
        Lager lager = new Lager(5);
        // Artikel anlegen neues Artikel-Objekt mit Artikel-Startbestand von 10
        Artikel artikel = new Artikel(1000, "Test artikel", 10, 10.0);

        //Artikel ins Lager legen
        lager.legeAnArtikel(artikel);

        // Verwenden der Methode aenderePreisEinesArtikels, um den Preis um 10% zu erhöhen
        lager.aenderePreisEinesArtikels(1000, 10);

        // Feststellen, dass der neue Lagerbestand gleich 15 ist
        assertEquals(11.0, artikel.getPreis());
    }

    /**
     * Test erhoehung der Preis eines Artikels
     */
    @Test
    public void test_Preis_Aller_Artikel_Erhoehen_sollte_korrekt_sein() {
        Lager lager = new Lager(5);
        // Artikel anlegen neues Artikel-Objekt mit Artikel-Startbestand von 10
        Artikel artikel = new Artikel(1000, "Test artikel", 10, 10.0);

        //Artikel ins Lager legen
        lager.legeAnArtikel(artikel);

        // Verwenden der Methode aenderePreisAllerArtikel, um den Preis um 10% zu erhöhen
        lager.aenderePreisAllerArtikel(10);

        // Feststellen, dass der neue Lagerbestand gleich 15 ist
        assertEquals(11.0, artikel.getPreis());
    }


    /**
     * Test um eine ungueltige lagergroesse zu prüfen
     */
    @Test
    public void test_ungueltige_lagergroesse_exception_erwartet() {
        // Lager anlegen neues Lager-Objekt mit ungueltiger Lagergroesse
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Lager mit negativer Groesse Anlegen versuchen
            Lager lager = new Lager(-1);
        });
    }

    /**
     * Test ein Artikel legen, der bereits im Lager existiert
     */
    @Test
    public void test_Artikel_legen_mit_Artikelnummer_bereits_existiert_erwartet_Exception() {
        Lager lager = new Lager(5);
        // Artikel anlegen neues Artikel-Objekt mit ungueltiger Artikelnummer
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            // Erste Artikel schaffen und im Lager anlegen
            Artikel artikel = new Artikel(1001, "Test artikel 1000", 10, 10.0);
            lager.legeAnArtikel(artikel);

            // Zweite Artikel schaffen und im Lager anlegen
            Artikel artikelBis = new Artikel(1001, "Test artikel 1000bis", 10, 10.0);
            lager.legeAnArtikel(artikelBis);
        });
    }

    /**
     * Test Artikel anlegen wenn das Lager bereits voll ist
     */
    @Test
    public void test_Artikel_anlegen_wenn_Lager_voll_erwartet_Exception() {
        // Artikel anlegen neues Artikel-Objekt mit ungueltigem Bestand
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Klein Lager Anlegen, damit einfacher zu prüfen
            Lager lager = new Lager(1);

            // Erste Artikel schaffen und im Lager anlegen
            Artikel artikel = new Artikel(1012, "Test artikel", 10, 10.0);
            lager.legeAnArtikel(artikel);

            // Zweite Artikel schaffen und im Lager anlegen
            Artikel artikelBis = new Artikel(1000, "Test artikel bis", 10, 10.0);
            lager.legeAnArtikel(artikelBis);
        });
    }

    /**
     * Test Preisaenderung wird den Preis negativ machen
     */
    @Test
    public void test_preisaenderung_wird_preis_negativ_machen_erwartet_Exception() {
        Lager lager = new Lager(5);
        // Artikel anlegen neues 
        Artikel artikel = new Artikel(1021, "Test artikel", 10, 10.0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Probiert mit ein negativ Prozent Groesser als -100
            lager.aenderePreisAllerArtikel(-101);
        });
    }


}
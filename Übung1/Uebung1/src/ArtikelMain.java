public class ArtikelMain {
    public static void main(String[] args) {

        /**
         * Testen aller Methoden, Getter und Setter für die zwei ersten Objekten, die mit
         * dem ersten Konstruktor erstellt worden sind
         */

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen aller Methoden, Getter und Setter für die zwei ersten Objekte, die mit \ndem ersten Konstruktor erstellt worden sind");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
        
        // Objekt Erstellung mit ersten Konstruktor
        Artikel Artikel1 = new Artikel(1, "Ball", 1);
        Artikel Artikel2 = new Artikel(2, "Buch", 3);


        // Testen der Methoden
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Methoden für das Objekt Artikel1: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel1:
        System.out.println(Artikel1.toString() + "\n");
        // Änderung der Bestandsmenge
        Artikel1.bucheZugang(20);
        System.out.println("Bestand erhöht: " + Artikel1.getBestand() + "\n");
        Artikel1.bucheAbgang(10);
        System.out.println("Bestand vermindert: " + Artikel1.getBestand() + "\n");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Methoden für das Objekt Artikel2: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel2
        System.out.println(Artikel2.toString() + "\n");
        // Änderung der Bestandsmenge
        Artikel2.bucheZugang(20);
        System.out.println("Bestand erhöht: " + Artikel2.getBestand() + "\n");
        Artikel2.bucheAbgang(10);
        System.out.println("Bestand vermindert: " + Artikel2.getBestand() + "\n");


        // Testen der Getter für jedes Objekt
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Getter für das Objekt Artikel1: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel1:
        System.out.println("Artikelnummer Artikel1: " + Artikel1.getArtikelNr() + "\n");
        System.out.println("Artikelart Artikel1: " + Artikel1.getArt() + "\n");
        System.out.println("Artikelbestand Artikel1: " + Artikel1.getBestand() + "\n");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Getter für das Objekt Artikel2: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel2: 
        System.out.println("Artikelnummer Artikel2: " + Artikel2.getArtikelNr() + "\n");
        System.out.println("Artikelart Artikel2: " + Artikel2.getArt() + "\n");
        System.out.println("Artikelbestand Artikel2: " + Artikel2.getBestand() + "\n");
        
        
        // Testen der Setter für jedes Objekt
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Setter für das Objekt Artikel1: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel1:
        System.out.println("Artikelnummer Artikel1: " + Artikel1.getArtikelNr() + "\n");
        Artikel1.setArtikelNr(5);
        System.out.println("Artikelnummer aktualisiert: " + Artikel1.getArtikelNr() + "\n");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Setter für das Objekt Artikel2: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
        
        // Artikel2:
        System.out.println("Artikelnummer Artikel2: " + Artikel2.getArtikelNr() + "\n");
        Artikel2.setArtikelNr(6);
        System.out.println("Artikelnummer aktualisiert: " + Artikel2.getArtikelNr() + "\n");

        
        
        /**
         * Testen aller Methoden, Getter und Setter für die zwei anderen Objekten, die mit
         * dem zweiten Konstruktor erstellt worden sind
         */

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen aller Methoden, Getter und Setter für die zwei anderen Objekten, die mit \ndem zweiten Konstruktor erstellt worden sind");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        //Objekt Erstellung mit zweiten Konstruktor
        Artikel Artikel3 = new Artikel(3, "Seil");
        Artikel Artikel4 = new Artikel(4, "Hose");


        // Testen der Methoden
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Methoden für das Objekt Artikel3: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel3:
        System.out.println(Artikel3.toString() + "\n");
        // Änderung der Bestandsmenge
        Artikel3.bucheZugang(20);
        System.out.println("Bestand erhöht: " + Artikel3.getBestand() + "\n");
        Artikel3.bucheAbgang(10);
        System.out.println("Bestand vermindert: " + Artikel3.getBestand() + "\n");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Methoden für das Objekt Artikel4: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel4
        System.out.println(Artikel4.toString() + "\n");
        // Änderung der Bestandsmenge
        Artikel4.bucheZugang(20);
        System.out.println("Bestand erhöht: " + Artikel4.getBestand() + "\n");
        Artikel4.bucheAbgang(10);
        System.out.println("Bestand vermindert: " + Artikel4.getBestand() + "\n");


        // Testen der Getter für jedes Objekt
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Getter für das Objekt Artikel3: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel3:
        System.out.println("Artikelnummer Artikel3: " + Artikel3.getArtikelNr() + "\n");
        System.out.println("Artikelart Artikel3: " + Artikel3.getArt() + "\n");
        System.out.println("Artikelbestand Artikel3: "  + Artikel3.getBestand() + "\n");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Getter für das Objekt Artikel4: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel4: 
        System.out.println("Artikelnummer Artikel4: " + Artikel4.getArtikelNr() + "\n");
        System.out.println("Artikelart Artikel4: " + Artikel4.getArt() + "\n");
        System.out.println("Artikelbestand Artikel4: " + Artikel4.getBestand() + "\n");


        // Testen der Setter für jedes Objekt
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Setter für das Objekt Artikel3: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel3:
        System.out.println("Artikelnummer Artikel3: " + Artikel3.getArtikelNr() + "\n");
        Artikel3.setArtikelNr(5);
        System.out.println("Artikelnummer aktualisiert: " + Artikel3.getArtikelNr() + "\n");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Testen der Setter für das Objekt Artikel4: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");

        // Artikel4:
        System.out.println("Artikelnummer Artikel4: " + Artikel4.getArtikelNr() + "\n");
        Artikel4.setArtikelNr(6);
        System.out.println("Artikelnummer aktualisiert: " + Artikel4.getArtikelNr() + "\n");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Tests fertig!");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
        
    }
}
public class Main {
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
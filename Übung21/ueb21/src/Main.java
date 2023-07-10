import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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

        // Sort articles by increasing price
        Artikel[] sortedByPrice = lager.getSorted((a1, a2) -> a1.getPreis() < a2.getPreis());
        System.out.println("Articles sorted by increasing price:");
        for (Artikel artikel1 : sortedByPrice) {
            System.out.println(artikel);
        }

        System.out.println(lager.toString());


        // Sort articles by decreasing stock
        Artikel[] sortedByStock = lager.getSorted((a1, a2) -> a1.getBestand() > a2.getBestand());
        System.out.println("Articles sorted by decreasing stock:");
        for (Artikel artikel1 : sortedByStock) {
            System.out.println(artikel);
        }

        System.out.println(lager.toString());


        // Sort articles alphabetically by description
        Artikel[] sortedByDescription = lager.getSorted((a1, a2) -> a1.getBeschreibung().compareTo(a2.getBeschreibung()) < 0);
        System.out.println("Articles sorted alphabetically by description:");
        for (Artikel artikel1 : sortedByDescription) {
            System.out.println(artikel);
        }

        System.out.println(lager.toString());

        // Print the details of each article
        lager.applyToArticles(System.out::println);

        System.out.println(lager.toString());

        // Increase the stock of each article by 5
        lager.applyToArticles(article -> article.bucheZugang(5));

        System.out.println(lager.toString());

        // Update the price of each article by reducing it by 10%
        lager.applyToArticles(article -> article.setPreis(article.getPreis() * 0.9));

        System.out.println(lager.toString());

        // Get article with articleNr = 1111
        Artikel artikel1 = lager.getArtikel(1111);
        System.out.println("Article with articleNr 1111: " + artikel1);

        // Get article with articleNr = 3333
        Artikel artikel3 = lager.getArtikel(3333);
        System.out.println("Article with articleNr 3333: " + artikel3);

        // Filter articles with price greater than 100
        List<Artikel> expensiveArticles = lager.filter(article -> article.getPreis() > 100);
        System.out.println("Expensive articles:");
        for (Artikel article : expensiveArticles) {
            System.out.println(artikel);
        }

        System.out.println(lager.toString());

        // Filter articles with stock less than 10
        List<Artikel> lowStockArticles = lager.filter(article -> article.getBestand() < 10);
        System.out.println("Articles with low stock:");
        for (Artikel article: lowStockArticles) {
            System.out.println(artikel);
        }

        System.out.println(lager.toString());

        // Filter articles with description containing "DVD"
        List<Artikel> dvdArticles = lager.filter(article -> article.getBeschreibung().contains("DVD"));
        System.out.println("DVD articles:");
        for (Artikel article : dvdArticles) {
            System.out.println(artikel);
        }

        System.out.println(lager.toString());

        // Increase the stock of CDs by 3
        lager.applyToSomeArticles(article -> article instanceof CD, article -> article.bucheZugang(3));

        System.out.println(lager.toString());

        // Reduce the price of videos by 20%
        lager.applyToSomeArticles(article -> article instanceof Video, article -> article.setPreis(article.getPreis() * 0.8));

        System.out.println(lager.toString());

        //Set the description of articles with stock less than 5 to "Low stock"
        lager.applyToSomeArticles(article -> article.getBestand() < 5, article -> article.setArt("Low stock"));

        System.out.println(lager.toString());

        // Get articles with price greater than 200, sorted by decreasing price
        List<Artikel> expensiveSortedArticles = lager.getArticles(article -> article.getPreis() > 200, Comparator.comparing(Artikel::getPreis).reversed());
        System.out.println("Expensive articles sorted by decreasing price:");
        for (Artikel article1: expensiveSortedArticles) {
            System.out.println(artikel);
        }

        // Get articles with stock greater than 10, sorted by increasing stock
        List<Artikel> highStockSortedArticles = lager.getArticles(article -> article.getBestand() > 10, Comparator.comparing(Artikel::getBestand));
        System.out.println("Articles with high stock sorted by increasing stock:");
        for (Artikel article1 : highStockSortedArticles) {
            System.out.println(artikel);
        }

        // Get articles with description containing "book", sorted alphabetically by description
        List<Artikel> bookSortedArticles = lager.getArticles(article -> article.getBeschreibung().toLowerCase().contains("book"), Comparator.comparing(Artikel::getBeschreibung));
        System.out.println("Book articles sorted alphabetically by description:");
        for (Artikel article1 : bookSortedArticles) {
            System.out.println(artikel);
        }

        // Filter articles with price greater than 100 and stock less than 5
        Predicate<Artikel> priceFilter = article -> article.getPreis() > 100;
        Predicate<Artikel> stockFilter = article -> article.getBestand() < 5;
        Predicate<Artikel>[] filterCriteria = new Predicate[]{priceFilter, stockFilter};
        List<Artikel> filteredArticles1 = lager.filterAll(filterCriteria);
        System.out.println("Articles filtered by price > 100 and stock < 5:");
        for (Artikel artikel4 : filteredArticles1) {
            System.out.println(artikel);
        }

        // Filter articles with description containing "DVD" and author "John"
        Predicate<Artikel> descriptionFilter = article -> article.getBeschreibung().contains("DVD");
        Predicate<Artikel> authorFilter = article -> article instanceof Buch && ((Buch) article).getAutor().equals("John");
        Predicate<Artikel>[] filterCriteria2 = new Predicate[]{descriptionFilter, authorFilter};
        List<Artikel> filteredArticles2 = lager.filterAll(filterCriteria2);
        System.out.println("Articles filtered by description containing 'DVD' and author 'John':");
        for (Artikel artikel4: filteredArticles2) {
            System.out.println(artikel);
        }

        // Filter articles with price greater than 200, stock less than 10, and description containing "book"
        Predicate<Artikel> priceFilter2 = article -> article.getPreis() > 200;
        Predicate<Artikel>[] filterCriteria3 = new Predicate[]{priceFilter2, stockFilter, descriptionFilter};
        List<Artikel> filteredArticles3 = lager.filterAll(filterCriteria3);
        System.out.println("Articles filtered by price > 200, stock < 10, and description containing 'book':");
        for (Artikel artikel4 : filteredArticles3) {
            System.out.println(artikel);
        }

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
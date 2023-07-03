import java.util.Map;

public class ErrorCheck {


    /**
     * Checks for faulty input in article type.
     * @param art Description of the article.
     */
    public static void checkArt(String art) {
        if (art.isBlank()) {
            throw new IllegalArgumentException("Do not enter blank spaces!");
        }
    }

    /**
     * Checks the maximum size of the array.
     * @param maxGroesse Maximum size.
     */
    public static void checkArrayGroesse(int maxGroesse) {
        if (maxGroesse < 1) {
            throw new IllegalArgumentException("The inventory must contain at least 1 item.");
        }
    }

    /**
     * Checks if stock quantity is greater than 0.
     * @param bestand Quantity of articles.
     */
    public static void checkBestand(int bestand) {
        if (bestand < 1) {
            throw new IllegalArgumentException("Enter a number higher than 0!");
        }
    }

    /**
     * Checks if article price is greater than 0.
     * @param preis Price of the article.
     */
    public static void checkPreis(double preis) {
        if (preis <= 0.0) {
            throw new IllegalArgumentException("Enter a number higher than 0!");
        }
    }

    /**
     * Checks if the article number is four digits long.
     * @param artikelNr Number of the article.
     */
    public static void checkArtikelNr(int artikelNr) {
        if (String.valueOf(artikelNr).length() != 4 || artikelNr < 1000) {
            throw new IllegalArgumentException("Invalid input. Enter a positive four-digit number starting with 1.");
        }
    }

    /**
     * Checks if the quantity to be added is positive.
     * @param menge Quantity to be added.
     */
    public static void checkBucheZugang(int menge) {
        if (menge < 0) {
            throw new IllegalArgumentException("Invalid input! Enter a positive value.");
        }
    }

    /**
     * Checks if the quantity to be deducted is positive and if the difference between stock and quantity remains positive.
     * @param bestand Current quantity available.
     * @param menge Quantity to be deducted.
     */
    public static void checkBucheAbgang(int bestand, int menge) {
        if (menge < 0 || (bestand - menge) < 0) {
            throw new IllegalArgumentException("Invalid input! The difference between stock and quantity is negative.");
        }
    }

    /**
     * Checks if the inventory is empty.
     * @param lager Array with objects.
     */
    public static void checkLagerLeer(Lager lager) {
        Map<Integer, Artikel> map = lager.getArtikelMap();
        if (map.size() == 0) {
            throw new IllegalArgumentException("The inventory is empty. Create an article first!");
        }
    }

    /**
     * Checks if an object already exists in the inventory.
     * @param artikelMap
     * @param artikel Object
     */
    public static void checkAlreadyInLager(Map<Integer, Artikel> artikelMap, Artikel artikel) {
        if (artikelMap.get(artikel.getArtikelNr()) != null) {
            throw new IllegalArgumentException("An article with this number already exists.");
        }
    }

    /**
     * Checks if an object does not yet exist in the inventory.
     * @param artikelNr Article number
     * @param artikelMap  Object Map
     */
    public static void checkIfNotAlreadyInLager(Map<Integer, Artikel> artikelMap, int artikelNr) {
        if (artikelMap.get(artikelNr) == null) {
            throw new IllegalArgumentException("An article with this number does not exist.");
        }
    }

    /**
     * Checks if the index is null.
     * @param artikelMap Map with objects.
     * @param artikel Desired article.
     */
    public static void checkNullIndex(Map<Integer, Artikel> artikelMap, Artikel artikel) {
        if (artikelMap.get(artikel.getArtikelNr()) == null) {
            throw new IllegalArgumentException("There is no article at this position.");
        }
    }

    /**
     * Checks if there is already an existing inventory.
     * @param lager Array with objects.
     */
    public static void checkSchonLager(Lager lager) {
        if (lager != null) {
            throw new IllegalArgumentException("There is already an inventory. Use it!");
        }
    }

    /**
     * Checks if there is no existing inventory yet.
     * @param lager Array with objects.
     */
    public static void checkLagerExistiert(Lager lager) {
        if (lager == null) {
            throw new IllegalArgumentException("There is no inventory yet. Create one!");
        }
    }

    /**
     * Checks if the string is not empty.
     * @param string String
     */
    public static void checkStringNichtLeer(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("The string is empty. Provide a value.");
        }
    }

    /**
     * Checks if the value is greater than zero.
     * @param zahl Value being passed.
     */
    public static void checkGroesserAlsNull(int zahl) {
        if (zahl <= 0) {
            throw new IllegalArgumentException("The number must be greater than 0.");
        }
    }

    /**
     * Checks if the year is between 1900 and 2022.
     * @param zahl Value being passed.
     */
    public static void checkZwischen1900und2022(int zahl) {
        if (1900 > zahl || zahl > 2022) {
            throw new IllegalArgumentException("The number must be greater than 1900 and less than 2022.");
        }
    }

// Check for exercise 18
    /**
     * Checks if (special offer) has already been added to the article or not.
     * @param art Value being passed.
     */
    public static void checkSonderangebot(String art) {
        if (art.contains("(Sonderangebot)")) {
            throw new IllegalArgumentException("The special offer has already been added to the article.");
        }
    }
}
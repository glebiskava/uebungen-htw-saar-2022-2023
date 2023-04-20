/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine Klasse die rekursiv berechnet, ob ein Wort ein Palindrom ist
 */
class PalindromRekursiv implements Palindrom {
    @Override
    public boolean istPalindrom(String wort) {
        if (wort.length() <= 1) {
            return true;
        } else if (wort.charAt(0) == wort.charAt(wort.length() - 1)) {
            return istPalindrom(wort.substring(1, wort.length() - 1));
        } else {
            return false;
        }
    }
}
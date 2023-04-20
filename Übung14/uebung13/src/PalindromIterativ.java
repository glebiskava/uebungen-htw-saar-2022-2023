/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine Klasse die iterativ berechnet, ob ein Wort ein Palindrom ist
 */
class PalindromIterativ implements Palindrom {
    @Override
    public boolean istPalindrom(String wort) {
        int i = 0;
        int j = wort.length() - 1;
        while (i < j) {
            if (wort.charAt(i) != wort.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

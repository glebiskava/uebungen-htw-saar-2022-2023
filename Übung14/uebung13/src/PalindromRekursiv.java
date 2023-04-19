class PalindromRekursiv implements Palindrom {
    @Override
    public boolean istPalindrom(String wort) {
        wort.toLowerCase();
        if (wort.length() <= 1) {
            return true;
        } else if (wort.charAt(0) == wort.charAt(wort.length() - 1)) {
            return istPalindrom(wort.substring(1, wort.length() - 1));
        } else {
            return false;
        }
    }
}
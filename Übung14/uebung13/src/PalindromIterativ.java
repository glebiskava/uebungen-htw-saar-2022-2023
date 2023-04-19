class PalindromIterativ implements Palindrom {
    @Override
    public boolean istPalindrom(String wort) {
        wort.toUpperCase();
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

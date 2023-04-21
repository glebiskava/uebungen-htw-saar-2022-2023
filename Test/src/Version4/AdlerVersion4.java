package Version4;

public final class AdlerVersion4 extends TierVersion4 {

    private boolean inDerLuftUnterwegs;

    public AdlerVersion4(int hunger) {
        super(hunger);
    }

    public void starten() {
        inDerLuftUnterwegs = true;
    }

    public void landen() {
        inDerLuftUnterwegs = false;
    }

    public boolean istUnterwegs() {
        return inDerLuftUnterwegs;
    }

    @Override
    public final String toString() {
        String adlerAlsString = "Ich bin ein Adler und ";

        if(istUnterwegs()) {
            adlerAlsString += "fliege gerade";
        } else {
            adlerAlsString += "bin am Boden";
        }
        return adlerAlsString;
    }
}

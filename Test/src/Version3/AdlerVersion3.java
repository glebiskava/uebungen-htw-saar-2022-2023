package Version3;

public class AdlerVersion3 extends TierVersion3 {

    private boolean inDerLuftUnterwegs;

    public void starten() {
        inDerLuftUnterwegs = true;
    }

    public void landen() {
        inDerLuftUnterwegs = false;
    }

    public boolean istUnterwegs() {
        return inDerLuftUnterwegs;
    }
}

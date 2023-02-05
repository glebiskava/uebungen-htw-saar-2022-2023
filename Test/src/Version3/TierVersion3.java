package Version3;

public class TierVersion3 {

    private int hunger;

    public void fressen() {
        hunger--;
    }

    public void laufen() {
        hunger++;
    }

    public int getHunger() {
        return hunger;
    }
}

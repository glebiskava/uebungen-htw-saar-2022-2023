package Version4;

public class TierVersion4 {

    private int hunger;

    public TierVersion4 (int hunger) {
        this.hunger = hunger;
    }

    public final void fressen() {
        hunger--;
    }

    public final void laufen() {
        hunger++;
    }

    public final int getHunger() {
        return hunger;
    }

    /**
     * not overwritten so no final
     */
    public void geraeuscheMachen() {

        System.out.println("Ich bin ein Tier und mache ein Geraeusch");
    }
}

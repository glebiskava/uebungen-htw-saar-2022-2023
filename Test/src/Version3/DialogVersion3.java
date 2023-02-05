package Version3;

public class DialogVersion3 {

    public static void main(String args[]) {
        TierVersion3 tier = new TierVersion3();
        tier.laufen();
        tier.laufen();
        System.out.println(tier);

        HundVersion3 hund = new HundVersion3();
        hund.laufen();
        hund.stoeckchenHolen();
        hund.stoeckchenHolen();
        System.out.println(hund);

        KatzeVersion3 katze = new KatzeVersion3();
        katze.laufen();
        katze.maeuseFangen();
        System.out.println(katze);
    }
}
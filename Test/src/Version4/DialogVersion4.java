package Version4;

public class DialogVersion4 {

    public static void main(String args[]) {
        /*TierVersion4 tier = new TierVersion4();
        tier.laufen();
        tier.laufen();
        System.out.println(tier);

        HundVersion4 hund = new HundVersion4();
        hund.laufen();
        hund.stoeckchenHolen();
        hund.stoeckchenHolen();
        System.out.println(hund);

        KatzeVersion4 katze = new KatzeVersion4();
        katze.laufen();
        katze.maeuseFangen();
        System.out.println(katze);*/

        TierVersion4 tier = new TierVersion4(3);
        tier.geraeuscheMachen();
        tier.laufen();
        System.out.println(tier);

        KatzeVersion4 katze = new KatzeVersion4(3);
        katze.geraeuscheMachen();
        katze.laufen();
        System.out.println(katze);

        HundVersion4 hund = new HundVersion4(3);
        hund.geraeuscheMachen();
        hund.laufen();
        System.out.println(hund);

        AdlerVersion4 adler = new AdlerVersion4(4);
        adler.geraeuscheMachen();
        adler.starten();
        System.out.println(adler);
        adler.landen();
        System.out.println(adler);

    }
}
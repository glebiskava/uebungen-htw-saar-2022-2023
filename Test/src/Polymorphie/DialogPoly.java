package Polymorphie;

public class DialogPoly {

    public static void main(String main[]) {

        TierVersion4 tier = new TierVersion4(3);
        /*tier.geraeuscheMachen();*/

        HundVersion4 hund = new HundVersion4(10);
        /*hund.geraeuscheMachen();*/

        TierVersion4 hundAlsTier = new HundVersion4(2);
        /*hundAlsTier.geraeuscheMachen();*/


        TierVersion4[] tiere = new TierVersion4[5];
        TierVersion4 katzeAlsTier = new KatzeVersion4(10);
        TierVersion4 adlerAlsTier = new AdlerVersion4(10);
        tiere[0] = tier;
        tiere[1] = hund;
        tiere[2] = hundAlsTier;
        tiere[3] = katzeAlsTier;
        tiere[4] = adlerAlsTier;

        /**
         * for each schleife um auf jedes Tier (Hund oder Katze) die Methode geraeuscheMachen auszufuehren
         */
        for (TierVersion4 einTier : tiere) {
            if(einTier instanceof HundVersion4) {
                HundVersion4 einHund = (HundVersion4)einTier;
                einHund.stoeckchenHolen();
                System.out.println(einHund);
            } else if(einTier instanceof KatzeVersion4) {
                KatzeVersion4 eineKatze = (KatzeVersion4)einTier;
                eineKatze.maeuseFangen();
                System.out.println(eineKatze);
            }
        }

        mitCastsExperimentieren();
    }

    /**
     * ERROR: Exception in thread "main" java.lang.ClassCastException: class Polymorphie.TierVersion4 cannot be
     * cast to class Polymorphie.KatzeVersion4 (Polymorphie.TierVersion4 and Polymorphie.KatzeVersion4 are in
     * unnamed module of loader 'app')
     *
     * LOESUNG:
     * siehe unten im Code
     */
    public static void mitCastsExperimentieren() {

        HundVersion4 hund = new HundVersion4(4);
        TierVersion4 hundAlsTier = hund;

        TierVersion4 tier = new TierVersion4(4);
        /*KatzeVersion4 katze = (KatzeVersion4)tier;*/
        KatzeVersion4 katze = new KatzeVersion4(4);
        TierVersion4 katzeAlsTier = katze;
        KatzeVersion4 nochEineKatze = (KatzeVersion4)katzeAlsTier;

        System.out.println(hundAlsTier);
        System.out.println(katze);
        System.out.println(katzeAlsTier);
    }
}

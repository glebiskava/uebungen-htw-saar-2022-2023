package Tests;

public class Parkplatz {
    private Auto[] autos;

    private int anzahlStrafzettel;
    private int anzahlAbgeschleppt;
    private int anzahlGeparkteAutos;
    private int anzahlAutos;

    @Override
    public String toString() {
        System.out.println("Autos auf dem Parkplatz");
        for (int i = 1; i < autos.length; i++) {
            System.out.println(i + ": Kennzeichen " + autos[i].getKennzeichen() + " bis" + autos[i].getParkzeitEnde() +
                    " Uhr. Strafzettel: " + autos[i].hatStrafzettel(zeit);
        }
    }

    public String strafzettelSchreiben(int zeit) {
        String sb = "";
        for (int i = 0; i < autos.length; i++) {
            if (autos[i].getParkzeitEnde() <= zeit) {
                sb += "nein";
            } else {
                sb += "ja";
            }
        } return sb;
    }

    public int getAnzahlStrafzettel() {
        return anzahlStrafzettel;
    }

    public int getAnzahlAbgeschleppt() {
        return anzahlAbgeschleppt;
    }

    public int getAnzahlGeparkteAutos() {
        return anzahlGeparkteAutos;
    }

    public int getAnzahlAutos() {
        return anzahlAutos;
    }

    public void setAnzahlStrafzettel(int anzahlStrafzettel) {
        this.anzahlStrafzettel = anzahlStrafzettel;
    }

    public void setAnzahlAbgeschleppt(int anzahlAbgeschleppt) {
        this.anzahlAbgeschleppt = anzahlAbgeschleppt;
    }

    public void setAnzahlGeparkteAutos(int anzahlGeparkteAutos) {
        this.anzahlGeparkteAutos = anzahlGeparkteAutos;
    }

    public void setAnzahlAutos(int anzahlAutos) {
        this.anzahlAutos = anzahlAutos;
    }
}

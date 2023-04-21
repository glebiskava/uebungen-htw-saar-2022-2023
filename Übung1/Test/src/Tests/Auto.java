package Tests;

public class Auto {

    private String kennzeichen;
    private int parkzeitEnde;
    private boolean strafzettel;

    public Auto(String kennzeichen, int parkzeitEnde) {
        super();
        this.kennzeichen = kennzeichen;
        this.parkzeitEnde = parkzeitEnde;
    }

    public boolean hatStrafzettel(int zeit) {
        if (zeit <= getParkzeitEnde()) {
            return false;
        } return true;
    }

    public boolean isStrafzettel() {
        return strafzettel;
    }

    public void setStrafzettel(boolean strafzettel) {
        this.strafzettel = strafzettel;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public int getParkzeitEnde() {
        return parkzeitEnde;
    }

    public void setKennzeichen() {
        this.kennzeichen = kennzeichen;
    }

    public void setParkzeitEnde() {
        this.parkzeitEnde = parkzeitEnde;
    }




}

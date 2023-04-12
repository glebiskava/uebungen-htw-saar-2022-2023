public class Uhrzeit {

    private int stunde;
    private int minute;

    public Uhrzeit(int stunde, int minute) {
        this.stunde = stunde;
        this.minute = minute;
    }

    public int getStunde() {
        return stunde;
    }

    public void setStunde(int stunde) {
        this.stunde = stunde;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }



    @Override
    public String toString() {
        return stunde + ":" + minute + " Uhr";
    }
}


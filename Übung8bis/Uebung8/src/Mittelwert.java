public class Mittelwert {
    private double mittelwert;
    private double nahesterWert;
    private double entferntesterWert;

    public Mittelwert(double mittelwert,double nahesterWert, double entferntesterWert){
        this.mittelwert = mittelwert;
        this.nahesterWert = nahesterWert;
        this.entferntesterWert = entferntesterWert;
    }
    public double get_mittelwert(){
        return mittelwert;
    }
    public double get_nahesterWert(){
        return nahesterWert;
    }
    public double get_entferntesterWert(){
        return entferntesterWert;
    }
}

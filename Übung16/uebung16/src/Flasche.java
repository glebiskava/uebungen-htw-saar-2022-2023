public class Flasche <T> extends Getraenk{
    // private T flasche;
    private T inhalt;

    Flasche(){
        this.inhalt = null;
    }

    public void fuellen(T Getraenk){
        this.inhalt = Getraenk;
    }

    public void leeren(){
        this.inhalt = null;
    }

    public T getInhalt() {
        return inhalt;
    }

    public void setInhalt(T inhalt){
        this.inhalt = inhalt;
    }

    @Override
    public String toString(){
        if(this.inhalt == null){
            return "leeresFlasche";
        } else {
            return "vollesFlasche"; 
        }
    }
}

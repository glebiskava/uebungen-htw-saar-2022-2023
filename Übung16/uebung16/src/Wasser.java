public class Wasser extends AlkoholfreiesGetraenk{
    private String quelle;

    Wasser(String hersteller, String Quelle){
        super(hersteller);
        this.quelle = Quelle;
    }
 
    public String getZuckergehalt(){
        return quelle;
    }
}

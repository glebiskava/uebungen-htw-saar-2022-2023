public class Wasser extends AlkoholfreiesGetraenk{
    private String quelle;

    Wasser(String hersteller, String Quelle){
        super(hersteller);
        this.quelle = Quelle;
    }
 
    public String getQuelle(){
        return quelle;
    }

    public void setQuelle(String Quelle){
        this.quelle = Quelle;
    }

    @Override
    public void setHersteller(String Hersteller) {
        super.setHersteller(Hersteller);
    }
}

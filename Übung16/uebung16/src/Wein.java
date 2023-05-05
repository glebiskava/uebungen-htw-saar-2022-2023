public class Wein extends AlkoholischesGetraenk{
    private String weingut;

    Wein(float alkoholgehalt, String Weingut){
        super(alkoholgehalt);
        this.weingut = Weingut;
    }
 
    public String getWeingut(){
        return weingut;
    }
    public void setWeingut(String Weingut){
        this.weingut = Weingut;
    }

    @Override
    public void setAlkoholgehalt(float alkoholgehalt) {
        super.setAlkoholgehalt(alkoholgehalt);
    }
    
}

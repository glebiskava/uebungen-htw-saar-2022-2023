public class Softdrink extends AlkoholfreiesGetraenk{
    private float zuckergehalt;

    Softdrink(String hersteller, float Zuckergehalt){
        super(hersteller);
        this.zuckergehalt = Zuckergehalt;
    }
 
    public float getZuckergehalt(){
        return zuckergehalt;
    }
}

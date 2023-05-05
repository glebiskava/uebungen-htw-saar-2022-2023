public class Weisswein extends Wein{
    Weisswein(float Alkoholgehalt, String Weingut){
        super(Alkoholgehalt, Weingut);
    }

    @Override
    public void setAlkoholgehalt(float alkoholgehalt) {
        super.setAlkoholgehalt(alkoholgehalt);
    }
    @Override
    public void setWeingut(String weingut) {
        super.setWeingut(weingut);
    }
}

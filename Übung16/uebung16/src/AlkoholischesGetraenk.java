abstract class AlkoholischesGetraenk extends Getraenk{
    private float alkoholgehalt;

    AlkoholischesGetraenk(float Alkoholgehalt){
        this.alkoholgehalt = Alkoholgehalt;
    }

    public float getAlkoholgehalt(){
        return alkoholgehalt;
    }
 }

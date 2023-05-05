public class Bier extends AlkoholischesGetraenk{
    private String brauerei;

    Bier(float alkoholgehalt, String Brauerei){
        super(alkoholgehalt);
        this.brauerei = Brauerei;
    }
 
    public String getBrauerei(){
        return brauerei;
    }
    public void setBrauerei(String Brauerei){
        this.brauerei = Brauerei;
    }

    @Override
    public void setAlkoholgehalt(float alkoholgehalt) {
        super.setAlkoholgehalt(alkoholgehalt);
    }
}


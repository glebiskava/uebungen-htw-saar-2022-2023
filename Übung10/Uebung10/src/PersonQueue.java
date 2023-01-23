public class PersonQueue extends QueueClass{
    private String vorname;
    private String nachname;
    public PersonQueue(int Groesse){
        super(Groesse);
    }
    public PersonQueue(){
        super();
    }
    public void setVorname(String vorname){
        //check
        this.vorname = vorname;
    }
    public void setNachname(String nachname){
        //check
        this.nachname = nachname;
    }
    public String getVorname(){
        return vorname;
    }
    public String getNachname(){
        return nachname;
    }
}

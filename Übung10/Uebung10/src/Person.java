public class Person {
    private String vorname;
    private String nachname;
    public Person(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public void setVorname(){
        //check
        this.vorname = vorname;
    }
    public void setNachname(){
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

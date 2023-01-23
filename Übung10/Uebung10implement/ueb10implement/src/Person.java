public class Person {
    private String vorname;
    private String nachname;
    public Person(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public void setVorname(String vorname){
        //check
        this.vorname = vorname;
    }
    public void setNachname(String nachname){
        //check
        this.nachname = nachname;
    }
    public String getVorname() {
        return vorname;
    }
    public String getNachname(){
        return nachname;
    }

    @Override
    public String toString(){
        return vorname + " " + nachname;
    }

}

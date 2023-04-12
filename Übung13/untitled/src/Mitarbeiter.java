public class Mitarbeiter extends Person {

    private String email;

    public Mitarbeiter(String vorname, String nachname, String email) {
        super(vorname, nachname);
        this.email = email;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getVorname() + " " + getNachname() + " (" + email + ")";
    }
}
abstract class AlkoholfreiesGetraenk extends Getraenk{
    private String hersteller;

    AlkoholfreiesGetraenk(String Hersteller) {
        this.hersteller = Hersteller;
    }
    public String getHersteller() {
        return hersteller;
    }
    public void setHersteller(String Hersteller) {
        this.hersteller = Hersteller;
    }

}

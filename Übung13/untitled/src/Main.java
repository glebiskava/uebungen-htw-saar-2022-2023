public class Main {

    public static void main(String[] args) {
        Mitarbeiter m = new Mitarbeiter("Max", "Mustermann", "max.mustermann@email.com");
        Uhrzeit u = new Uhrzeit(12 ,54);
        Raum r = new Raum(18, 0, 1);

        System.out.println(m);
        System.out.println(u);
        System.out.println(r);
    }
}

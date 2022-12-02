import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Flächeninhalt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Flächeninhalt
{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie eine Laenge ein : ");
        float length = input.nextFloat();

        System.out.println("Geben Sie eine Breite ein : ");
        float width = input.nextFloat();

        //Formeln

        float Flaecheninhalt = length*width;
        float Umfang = 2*length + 2*width;

        System.out.println("Laenge der Seite a: " + length + " cm");
        System.out.println("Laenge der Seite b : "+ width + " cm");

        System.out.println("Das Rechteck hat folgende Seiten: \n a = " + length + "\n b = " + width);
        System.out.println("Flaecheninhalt A = " + Flaecheninhalt + " qcm");
        System.out.println("Umfang U = " + Umfang + " cm");
    }
}

import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Age.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Age
{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Name : ");
        String vorname = input.next();

        System.out.println("name");
        String name = input.next();

        System.out.println("Geburtsjahr: ");
        int year = input.nextInt();

        int thisYear = 2022;

        int age = thisYear-year;

        System.out.println("Sie heißen : " + name + ", " + vorname);
        System.out.println("Sie sind " + age + " Jahre alt");

    }
}

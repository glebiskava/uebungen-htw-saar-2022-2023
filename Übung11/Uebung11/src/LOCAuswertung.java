import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

/**
 * Dies ist eine Klasse das die sogenannten "Lines of Code" (LOC) zählt.
 * Der Benutzer gibt der Klasse einige datei ein, und der code gibt das zahl aus.
 * @author Elisee Brand, Leopold Mittelberger
 */
public class LOCAuswertung {
    private int linieAnzahl = 0;
    private int totalLinieAnzahl = 0;
    private int sizeArgs = 0;
    private int sizeLesbarDateien = 0;
    List<String> lesbarDateien = new ArrayList<String>();
    Pattern regexCommentLinie = Pattern.compile("^\s*//");
    Pattern regexLeereLinie= Pattern.compile("^\s*$");

    /**
     * Hauptschleife, die zum Starten des Programms benutzt ist.
     * Fehlerhafte Eingaben werden hier aufgefangen
     * @param args ist ein Array die die Argumente des anruf lagert (datei.en)
     */
    public void start(String[] args){
        sizeArgs = args.length;
        try {
            //check, ob mindestens eine Datei gibt
            if(sizeArgs == 0) {
                throw new LOCExceptions("Es gibt keine Datei als Argument");
            }
            for(int i = 0; i < sizeArgs; i++){
                //check, ob das Datei existiert.
                //Wenn die Datei nicht existiert, prüft man nicht, ob es eine java Datei ist oder nicht
                File file = new File(args[i]);
                if(!file.exists()){
                    System.out.println("Datei: " + args[i] + " existiert nicht");
                } else if(!args[i].endsWith(".java")){
                    //check, ob es eine Java Datei ist
                    System.out.println("Datei: " + args[i] + " ist kein java datei");
                } else {
                        //datei ist lesbar, man addiert ihn in einer array ein
                        lesbarDateien.add(args[i]);
                        sizeLesbarDateien = lesbarDateien.size();
                    }
            }


            if(sizeLesbarDateien > 0){
                System.out.println("Auswertung Lines of Code (LOC)");
                for(int i = 0; i < sizeLesbarDateien; i++){
                    File file = new File(lesbarDateien.get(i));
                    System.out.println(file + ": " + gegebeneDatei(file) + " LOC");
                }
            }
        } catch (LOCExceptions e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            if(sizeLesbarDateien > 0){
                System.out.println("Gesamt: ");
                System.out.println(sizeLesbarDateien + " Dateien: " + totalLinieAnzahl + " LOC");
            }
        }
    }

    /**
     * Function die zählt wie viel Linie es, in der Code gibt.
     * Sie entscheidet auch welche Linie nicht zählbar ist, z.B. eine Comment linie
     * @param file ist der datei die zu analysieren ist
     */
    public int gegebeneDatei(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String linie = reader.readLine();
            linieAnzahl = 0;
            while(linie != null){
                Matcher matcherCommentLinie = regexCommentLinie.matcher(linie);
                Matcher matcherLeereLinie = regexLeereLinie.matcher(linie);

                if(!matcherCommentLinie.find() && !matcherLeereLinie.find()){
                    linieAnzahl++;
                }
                linie = reader.readLine();
            }
            totalLinieAnzahl += linieAnzahl;
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        } finally{
            return linieAnzahl;
        }
    }


    /**
     * Funktion zum Starten des Programms
     * @param args ist ein Array die die Argumente des anruf lagert (datei.en)
     */
    public static void main(String[] args){
        new LOCAuswertung().start(args);
    }
}
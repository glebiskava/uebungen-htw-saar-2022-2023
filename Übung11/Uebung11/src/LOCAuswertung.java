import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOCAuswertung {
    private int linieAnzahl = 0;
    private int totalLinieAnzahl = 0;

    Pattern regexCommentLinie = Pattern.compile("^\s*//");
    Pattern regexLeereLinie= Pattern.compile("^\s*$");
    public void start(String[] args) {
        try {
            for(int i = 0; i < args.length; i++){
                //checkJavaDatei
                if(!args[i].endsWith(".java")){
                    System.out.println("Datei: " + args[i] + " ist kein java datei");
                }
                //checkDateiExistiert
                File file = new File(args[i]);
                if(!file.exists()){
                    System.out.println("Datei: " + args[i] + " existiert nicht");
                }
                //checkSelbeDatei
                for(int j = 0; j < args.length; j++){
                    if(args[i] == args[j]){
                        System.out.println("Datei: " + args[i] + " ist verdoppelt");
                    }
                }
            }
            //checkMindestensEinDatei
            if(args.length == 0) {
                throw new LOCExceptions("Es gibt als Argument kein Datei");
            }
            System.out.println("Auswertung Lines of Code (LOC)");
            for(int i = 0; i < args.length; i++){
                File file = new File(args[i]);
                System.out.println(file + ": " + gegebeneDatei(file) + " LOC");
            }
        } catch (LOCExceptions e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            System.out.println("Gesamt: ");
            System.out.println(args.length + " Dateien: " + totalLinieAnzahl + " LOC");
        }
    }

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
     * Funktion zum Starten des Dialogs
     * @param args
     */
    public static void main(String[] args) {
        new LOCAuswertung().start(args);
    }
}
    //java LOCAuswertung datei1.java datei2.java datei3.java
    //Au moins un fichier doit être transmis. Le nombre total de fichiers transmis est quelconque.
    //Les fichiers à traiter doivent être contrôlés quant aux propriétés "fichier normal" et "lisibilité". Bien entendu,
    //les fichiers à traiter doivent également exister avant qu'un traitement puisse démarrer.
    //        - Les exceptions éventuelles doivent être traitées. Définissez pour cela vos propres classes d'exceptions.
    //        - En cas d'erreur de lecture dans un fichier, il faut passer au fichier suivant.
    //        - Il faut compter toutes les lignes non vides qui ne sont pas des lignes de commentaire.
    //        - Les lignes vides peuvent tout à fait avoir une longueur supérieure à 0.
    //        - Pour simplifier, nous ne considérons comme lignes de commentaires que celles qui commencent par la chaîne "//".
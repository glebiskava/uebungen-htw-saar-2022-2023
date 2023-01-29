import java.io.*;
import java.util.regex.Pattern;

public class LOCAuswertung {
    private int linieAnzahl = 0;
    private int totalLinieAnzahl = 0;

    Pattern regexCommentLine= Pattern.compile("^//");
    public void start(String[] args) {
        try {
            datei1.test(5);
            LOCExceptions.checkJavaDatei(args); //idk c'est quoi le pb avec LOCExceptions
            LOCExceptions.checkSelbeDatei(args);
            LOCExceptions.checkMindestensEinDatei(args);
            LOCExceptions.checkDateiExistiert(args);
            //check if datei leer ??? j'ai testé ça fonctionne, idk s'il faut tester

            System.out.println("Auswertung Lines of Code (LOC)");
            for(int i = 0; i < args.length; i++){
                File file = new File(args[i]);
                System.out.println(file + ": " + gegebeneDatei(file) + " LOC");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        } catch(Exception e) {
            System.out.println(e);
            e.printStackTrace(System.out);
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
                if(linie != null && linie.length() > 0 && !regexCommentLine.matcher(linie.trim()).find()){
                    linieAnzahl++;
                }
                linie = reader.readLine();
            }
            totalLinieAnzahl += linieAnzahl;
            return linieAnzahl;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
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

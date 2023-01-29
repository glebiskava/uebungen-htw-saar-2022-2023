import java.io.BufferedReader;
import java.io.File;
import java.util.InputMismatchException;

public class loc {
    private int test = 0;
    public void start(String[] args) {
        do {
            test++;
            try {
                gegebeneDatei(args);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while(test < 50);
    }

    public void gegebeneDatei(String[] args){

    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args
     */
    public static void main(String[] args) {
        new loc().start(args);
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.JFreeChart;
// import org.jfree.data.category.DefaultCategoryDataset;


// import com.panayotis.gnuplot.*;

public class Main {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("ma fenetre");
        
        String wort;
        // GnuPlotProcess gp = new GnuPlotProcess();
        // Création d’un fileWriter pour écrire dans un fichier
        FileWriter fileWriter = new FileWriter("messungen.txt", false);

        // Création d’un bufferedWriter qui utilise le fileWriter
        BufferedWriter writer = new BufferedWriter (fileWriter);

        if (args.length > 0) {
            // Eingabestring als Argument übergeben
            wort = args[0];
        } else {
            // Eingabestring aus Datei lesen
            String dateiname = "input.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
                while((wort = br.readLine()) != null){

                    Palindrom palindromRek = new PalindromRekursiv();
                    Palindrom palindromIte = new PalindromIterativ();

                    long nanoTime1Rek = System.nanoTime();
                    Boolean palindromeRekursive = palindromRek.istPalindrom(wort);
                    long nanoTime2Rek = System.nanoTime();
                        
                    long zeitRekNanoSecond = nanoTime2Rek - nanoTime1Rek;
                    System.out.println("Zeit brauch um mit den Rekursive funktion zu berechen : " + zeitRekNanoSecond + " nano seconds");

                    long nanoTime1Ite = System.nanoTime();
                    Boolean palindromeIterative = palindromIte.istPalindrom(wort);
                    long nanoTime2Ite = System.nanoTime();
                        
                    long zeitIteNanoSecond = nanoTime2Ite - nanoTime1Ite;
                    System.out.println("Zeit brauch um mit den Iterative funktion zu berechen : " + zeitIteNanoSecond + " nano seconds");

                    if (palindromeRekursive && palindromeIterative) {
                        System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist ein Palindrom.");
                        System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist ein Palindrom.\n");
                    } else {
                        System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist kein Palindrom.");
                        System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist kein Palindrom.\n");
                    }

                    // ajout d’un texte à notre fichier
                    writer.write(wort + " : " + zeitRekNanoSecond + ", " + zeitIteNanoSecond);

                    // Retour à la ligne
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
            }

            writer.close();

        }
    }
    // public void plot2d() {
    //     JGnuplot jg = new JGnuplot();
    //     Plot plot = new Plot("") {
    //         {
    //             xlabel = "x";
    //             ylabel = "y";
    //         }
    //     };
    //     double[] x = { 1, 2, 3, 4, 5 }, y1 = { 2, 4, 6, 8, 10 }, y2 = { 3, 6, 9, 12, 15 };
    //     DataTableSet dts = plot.addNewDataTableSet("2D Plot");
    //     dts.addNewDataTable("y=2x", x, y1);
    //     dts.addNewDataTable("y=3x", x, y2);
    //     jg.execute(plot, jg.plot2d);
    // }
    
}
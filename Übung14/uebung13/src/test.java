// import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.FileReader;
import java.io.FileWriter;
// import java.io.IOException;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        int number = 1;

        FileWriter fileWriter = new FileWriter("a.txt", false);

        // Création d’un bufferedWriter qui utilise le fileWriter
        BufferedWriter writer = new BufferedWriter (fileWriter);


        while(number < 5000){

            for(int i = 0; i < number; i++){
                // ajout d’un texte à notre fichier
                writer.write("a");
            }
             

            // Retour à la ligne
            writer.newLine();
            number++;
        }
        writer.close();
    }
}

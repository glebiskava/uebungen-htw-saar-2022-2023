import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Bitte geben Sie entweder 'FIFO' oder 'SORT' als Parameter an.");
            return;
        }

        String parameter = args[0];
        /**
         * Compares this String to another String, ignoring case considerations.
         * Two strings are considered equal ignoring case if they are of the same length and corresponding
         * Unicode code points in the two strings are equal ignoring case
         */
        boolean isFIFO = parameter.equalsIgnoreCase("FIFO");

        /**
         * Erzeugen aller nötigen Objekte/Listen etc.
         */
        List<Integer> arrayList = new ArrayList<>();
        Producer producer = new Producer(arrayList);
        Consumer consumer = new Consumer();
        Random ran = new Random();

        for (int i = 0; i < 10000; i++) {
            if (ran.nextInt(2) > 0) {
                int number = producer.produce();
                // Speichern des erzeugten Integers in der Collection
                arrayList.add(number);
            } else {
                consumer.consume();
                // Entnehmen eines Integers aus der Collection und Berechnung der Quersumme
                if (!arrayList.isEmpty()) {
                    int number;
                    if (isFIFO) {
                        number = arrayList.remove(0);
                    } else {
                        number = arrayList.remove(arrayList.size() - 1);
                    }
                    int sum = consumer.calculateDigitSum(number);
                    System.out.println("Quersumme: " + sum);
                }
            }
        }
    }
}

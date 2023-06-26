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
        Consumer consumer = new Consumer(producer);
        Random ran = new Random();

        // wenn ran.nextInt() größer null also 1, dann produce wenn nicht dann consume
        for (int i = 0; i < 10; i++) {
            int randomInt = ran.nextInt(2);

            if (randomInt > 0) { //zufaelliger Int bis 2 also 0 oder 1
                System.out.println("Random Integer : " + randomInt + " --> Produce");
                int number = producer.produce();
                // Speichern des erzeugten Integers in der Collection
                arrayList.add(number);
            } else {
                System.out.println("Random Integer : " + randomInt + " --> Consume");
                // Entnehmen eines Integers aus der Collection und Berechnung der Quersumme
                if (!arrayList.isEmpty()) {
                    int number;
                    if (isFIFO) {
                        number = arrayList.get(0);
                        consumer.consume(number);
                    } else {
                        number = arrayList.get(arrayList.size() - 1);
                        consumer.consume(number);
                    }
                    int sum = consumer.calculateDigitSum(number);
                    System.out.println("Quersumme: " + sum);
                }
            }
        }

        System.out.println("Ende der Schleife");

        System.out.println("\n\n\nNumber of different results: " + consumer.numberOfDifferentResults());
        System.out.println("Number of occurrences for number 8: " + consumer.numberOfOccurrences(8));
        System.out.println("Cross total ascending: " + consumer.getCrossTotalsAscending());
        System.out.println("Cross total descending: " + consumer.getCrossTotalsDescending());
        System.out.println("Timestamps for result 14: " + consumer.getTimestampsForResult(14));

    }
}

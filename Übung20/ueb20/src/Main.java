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
        for (int i = 0; i < 10000; i++) {
            int randomInt = ran.nextInt(2); //zufaelliger Int bis 2 also 0 oder 1

            if (randomInt > 0) {
                System.out.println("Random Integer : " + randomInt + " --> Produce");
                int number = producer.produce();
                arrayList.add(number);
            } else {
                System.out.println("Random Integer : " + randomInt + " --> Consume");
                if (!arrayList.isEmpty()) {
                    int number;
                    if (isFIFO) {
                        number = arrayList.remove(0);
                    } else {
                        number = arrayList.get(arrayList.size() - 1);
                        arrayList.remove(arrayList.size() - 1);
                    }

                    consumer.consume(number);

                } else {
                    System.out.println("ArrayList is empty. Cannot consume.");
                }
            }
        }

        System.out.println("Ende der Schleife");

        System.out.println("\n\n\nNumber of different results: "  + consumer.numberOfDifferentResults());

        System.out.println("Cross total ascending: "    + consumer.getCrossTotalsAscending());

        System.out.println("Cross total descending: "   + consumer.getCrossTotalsDescending());

        System.out.println("Number of occurrences for number 8: "       + consumer.numberOfOccurrences(8));
        System.out.println("Number of occurrences for number 13: "      + consumer.numberOfOccurrences(13));
        System.out.println("Number of occurrences for number -12: "     + consumer.numberOfOccurrences(-12));
        System.out.println("Number of occurrences for number 14: "      + consumer.numberOfOccurrences(14));
        System.out.println("Number of occurrences for number 16: "      + consumer.numberOfOccurrences(16));
        System.out.println("Number of occurrences for number 4: "       + consumer.numberOfOccurrences(4));
        System.out.println("Number of occurrences for number 11: "      + consumer.numberOfOccurrences(11));
        System.out.println("Number of occurrences for number 10: "      + consumer.numberOfOccurrences(10));

        System.out.println("Timestamps for result 1: "                  + consumer.getTimestampsForResult(1));
        System.out.println("Timestamps for result 12: "                 + consumer.getTimestampsForResult(12));
        System.out.println("Timestamps for result 10: "                 + consumer.getTimestampsForResult(10));
        System.out.println("Timestamps for result 7: "                  + consumer.getTimestampsForResult(7));
        System.out.println("Timestamps for result -5: "                 + consumer.getTimestampsForResult(-5));
        System.out.println("Timestamps for result 3: "                  + consumer.getTimestampsForResult(3));
        System.out.println("Timestamps for result 13: "                 + consumer.getTimestampsForResult(13));
        System.out.println("Timestamps for result 11: "                 + consumer.getTimestampsForResult(11));

    }
}

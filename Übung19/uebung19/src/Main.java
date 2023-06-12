public class Main {

    public static void main(String[] args) {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        int sizeTest = 0;

        //test fuer add()
        list.add(1);
        sizeTest++;
        System.out.println("1 wurde addiert " + list);

        list.add(2);
        sizeTest++;
        System.out.println("2 wurde addiert " + list);

        list.add(3);
        sizeTest++;
        System.out.println("3 wurde addiert " + list);

        list.add(4);
        sizeTest++;
        System.out.println("4 wurde addiert " + list);

        System.out.println("Integer Liste : " + list);

        //test fuer size();
        System.out.println("\ntest size() : " + (list.size() == sizeTest ? "Anzahl ist korekt" : "Size() funktionniert nicht") +
                "\nKlasse DoppeltVerketteteListe : " + list.size() + " elemente" +
                "\nKlasse MeinVerketteteListe : " + sizeTest + " elemente");

        //test fuer remove()
        System.out.println("\ntest remove() : " + list.remove(2) + " element an der 2. index wurde entfernt");
        sizeTest--;
        System.out.println("Integer Liste : " + list);

        //test fuer contains()
        System.out.println("\ntest contains() : " + (list.contains(2) ? "2 ist in der Liste" : "2 ist nicht in der Liste"));
        System.out.println("test contains() : " + (list.contains(3) ? "3 ist in der Liste" : "3 ist nicht in der Liste"));

        //test fuer unlink()
        // System.out.println("\ntest unlink() : " + list.unlink() + "element an der 3. index wurde entfernt");

        //test fuer get()
        System.out.println("\ntest get() : erste element an der 0. index ist " + list.get(0) + " und sollte 1 sein");

        //test fuer set()
        System.out.println("\ntest set() : " + list.set(0, 5) + " element an der 0. index wurde geaendert und ist jetzt 5 " +  list);

        //test fuer add()
        list.add(0, 10);
        System.out.println("\ntest add(int, E) : 10 wurde an der 0. Index addiert " +  list);
        list.add(2, 11);
        System.out.println("\ntest add(int, E) : 11 wurde an der 2. Index addiert " +  list);

        //test fuer clear()
        list.clear();
        sizeTest = 0;
        System.out.println("\ntest clear() : " + list);

        //test fuer isEmpty();
        System.out.println("\ntest isEmpty() : " + list.isEmpty());
        System.out.println("Integer Liste : " + list);

    }
}
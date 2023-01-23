public class StringQueue implements Queue {
    private String[] queue;
    private int size;
    private int maxSize;

    public StringQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new String[maxSize];
        this.size = 0;
    }

    public void addLast(Object o) {
        if (o instanceof String) {
            if (!full()) {
                queue[size] = (String) o;
                size++;
            } else {
                System.out.println("Die Queue ist voll");
            }
        } else {
            System.out.println("Invalid input, input must be of type String");
        }
    }

    public Object removeFirst() {
        if (!empty()) {
            String item = queue[0];
            for (int i = 0; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            size--;
            return item;
        } else {
            System.out.println("Die Queue ist leer");
            return null;
        }
    }

    public Object get(int i) {
        if (i >= 0 && i < size) {
            return queue[i];
        } else {
            System.out.println("Index out of bounds");
            return null;
        }
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean full() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }
}

class PersonQueue implements Queue {
    private Person[] queue;
    private int size;
    private int maxSize;

    public PersonQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new Person[maxSize];
        this.size = 0;
    }

    public void addLast(Object o) {
        if (o instanceof Person) {
            if (!full()) {
                queue[size] = (Person) o;
                size++;
            } else {
                System.out.println("Queue is full");
            }
        } else {
            System.out.println("Invalid input, input must be of type Person");
        }
    }

    public Object removeFirst() {
        if (!empty()) {
            Person item = queue[0];
            for (int i = 0; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            size--;
            return item;
        } else {
            System.out.println("Queue is empty");
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

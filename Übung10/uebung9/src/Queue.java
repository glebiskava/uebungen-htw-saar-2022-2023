public interface Queue {
    public void addLast (Object o);
    public Object removeFirst();
    public Object get (int i);
    public boolean empty();
    public boolean full();
    public int size();
}

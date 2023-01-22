public class QueueClass implements Queue{

    private Object[] queue;
    private int Groesse;
    private int Size = 0;
    private static final int default_groesse = 10;
    public QueueClass(int Groesse){
        //check groesser als 0 / 1 ? ou bien a mettre ailleurs
        this.Groesse = Groesse;
        queue = new Object[Groesse];
        Size = 0;
    }
    public QueueClass(){
        queue = new Object[default_groesse]; //this(default_groesse)
    }


    @Override
    public void addLast(Object o) {
        //selon l'énoncé, il faut prüfen pour que ce soit que des string ou des person
        queue[Size] = o;
        Size++;
    }

    @Override
    public Object removeFirst() {
        Object output = queue[0];
        queue[0] = null;

        for(int i = 0; i+1 < Size; i++){
            queue[i] = queue[i+1];
            System.out.println("queue[i] : "+ queue[i]);
        }
        Size--;
        return output;
    }

    @Override
    public Object get(int i) {
        Object output = queue[i];
        return output;
    }

    @Override
    public boolean empty() {
        if(Size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean full() {
        if(Size == Groesse){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return Size;
    }

    //rajoutée

    @Override
    public Object queueZeigen(Queue q, int index){
        return queue[index];
    }

}

public class QueueClass implements Queue{

    private Object[] queue;
    private int Groesse;
    private int Size;
    private static final int default_groesse = 10;
    public QueueClass(int Groesse){
        //check groesser als 0 / 1 ? ou bien a mettre ailleurs
        this.Groesse = Groesse;
        queue = new Object[Groesse];
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
        for(int i = 0; i < Size; i++){
            queue[i] = queue[i+1];
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
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        int output = Groesse - Size;
        return output;
    }
}

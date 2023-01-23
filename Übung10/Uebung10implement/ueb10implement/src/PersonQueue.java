public class PersonQueue implements Queue{
    private String vorname;
    private String nachname;
    public PersonQueue(int Groesse){
        super(Groesse);
    }
    public PersonQueue(){
        super();
    }
    public void setVorname(String vorname){
        //check
        this.vorname = vorname;
    }
    public void setNachname(String nachname){
        //check
        this.nachname = nachname;
    }
    public String getVorname(){
        return vorname;
    }
    public String getNachname(){
        return nachname;
    }

    @Override
    public void addLast(Object o) {

    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void print(Queue q) {

    }

    @Override
    public Object queueZeigen(Queue q, int index) {
        return null;
    }
}

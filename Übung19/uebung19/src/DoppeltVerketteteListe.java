import java.util.*;

public class DoppeltVerketteteListe<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Gibt die grosse der Liste zurueck
     * @return grosse der Liste
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Pruft ob die Liste leer ist
     * @return true wenn die Liste leer ist, false wenn nicht
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Pruft ob die Liste ein bestimmtes Element enthaelt
     * @param o das Element das gesucht wird
     * @return true wenn die Liste das Element enthaelt, false wenn nicht
     */
    @Override
    public boolean contains(Object o) {
        // if(isEmpty()){
        //     throw new IllegalArgumentException ("Liste ist leer");
        // }
        return indexOf(o) >= 0;
    }

    /**
     * 
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Erstelle ein neues Array mit dem korrekten Typ
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size); 
            a = newArray;
        }
        Object[] result = a;
        Node<E> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            result[index++] = currentNode.element;
            currentNode = currentNode.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }


    /**
     * Addiert ein Element am Ende der Liste
     * @param e das Element das hinzugefuegt wird
     * @return true wenn das Element hinzugefuegt wurde, false wenn nicht
     */
    @Override
    public boolean add(E e) {
        if(e == null){
            throw new NullPointerException("Element must not be null");
        }
        if (isEmpty()) {
            head = new Node<>(e, null, null);
            tail = head;
        } else {
            Node<E> newNode = new Node<>(e, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Entfernt ein bestimmtes Element aus der Liste
     * @param o das Element das entfernt wird
     * @return true wenn das Element entfernt wurde, false wenn nicht
     */
    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (Objects.equals(currentNode.element, o)) {
                unlink(currentNode);
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Addiert alle Elemente einer Collection am Ende der Liste
     * @param c die Collection die hinzugefuegt wird
     * @return true wenn die Collection hinzugefuegt wurde, false wenn nicht
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            add(element);
            modified = true;
        }
        return modified;
    }

    /**
     * Entfernt alle Elemente einer Liste
     */
    @Override
    public void clear() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            Node<E> nextNode = currentNode.next;
            currentNode.prev = null;
            currentNode.next = null;
            currentNode.element = null;
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * Gibt ein Element an einem bestimmten Index zurueck
     * @param index der Index des Elements
     * @return das Element an dem Index
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> currentNode = getNode(index);
        return currentNode.element;
    }

    /**
     * Plaziert ein Element an einem bestimmten Index
     * @param index der Index an dem das Element plaziert wird
     * @param element das Element das plaziert wird
     * @return das Element das vorher an dem Index war
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> currentNode = getNode(index);
        E oldElement = currentNode.element;
        currentNode.element = element;
        return oldElement;
    }

    /**
     * Fuegt ein Element an einem bestimmten Index hinzu
     * @param index der Index an dem das Element hinzugefuegt wird
     * @param element das Element das hinzugefuegt wird
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) {
            add(element);
        } else {
            Node<E> nextNode = getNode(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(element, prevNode, nextNode);
            nextNode.prev = newNode;
            if (prevNode != null) {
                prevNode.next = newNode;
            } else {
                head = newNode;
            }
            size++;
        }
    }

    /**
     * Entfernt ein Element an einem bestimmten Index
     * @param index der Index an dem das Element entfernt wird
     * @return das Element das entfernt wurde
     */
    @Override
    public E remove(int index) {
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> currentNode = getNode(index);
        E removedElement = currentNode.element;
        unlink(currentNode);
        return removedElement;
    }
    
    /**
     * Loescht die verbindung zu einem Node
     * @param node der Node zu dem die Verbindung geloescht wird
     */
    private void unlink(Node<E> node) {
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }

        node.prev = null;
        node.next = null;

        size--;
    }

    /**
     * Gibt den Index eines bestimmten Elements zurueck
     * @param o das Element dessen Index zurueckgegeben wird
     * @return der Index des Elements
     *        -1 wenn das Element nicht in der Liste ist
     */
    @Override
    public int indexOf(Object o) {
        if (isEmpty()) {
            return -1;
        }
        int index = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (Objects.equals(currentNode.element, o)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    /**
     * Hilfsmethode zum Abrufen des Knotens an einer bestimmten Position
     * @param index die Position des Knotens
     * @return der Knoten an der Position
     */
    private Node<E> getNode(int index) {
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }
    
    /**
     * toString Methode zum Ausgeben der Liste
     * @return String
     */
    @Override
    public String toString() {
        String s = "[";
        Node<E> currentNode = head;
        while (currentNode != null) {
            s += currentNode.element;
            currentNode = currentNode.next;
            if (currentNode != null) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

    //Aufgabe2
    // @Override
    // public ListIterator<E> listIterator(int index) {
    //     return new DoppeltVerketteteListeIterator(index);
    // }

    // @Override
    // public Iterator<E> iterator() {
    //     return new DoppeltVerketteteListeIterator();
    // }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }
    
}


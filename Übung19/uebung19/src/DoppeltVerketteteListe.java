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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(isEmpty()){
            throw new IllegalArgumentException ("Liste ist leer");
        }
        return indexOf(o) >= 0;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Erstelle ein neues Array mit dem korrekten Typ
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size); // récupère le type ds éléments du tableau
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

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            add(element);
            modified = true;
        }
        return modified;
    }

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

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> currentNode = getNode(index);
        return currentNode.element;
    }

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
    

    //faire une toString qui montre le tableau 
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


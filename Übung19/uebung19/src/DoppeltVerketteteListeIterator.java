import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import java.util.*;


public class DoppeltVerketteteListeIterator<E> implements ListIterator<E> {

    private DoppeltVerketteteListe.Node<E> currentNode;

    private Node<E> nextNode;
    private Node<E> lastReturnedNode;
    private int nextIndex;

    public DoppeltVerketteteListeIterator() {
        this.nextNode = head;
        this.lastReturnedNode = null;
        this.nextIndex = 0;
    }

    public DoppeltVerketteteListeIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == size) {
            // Wenn der Index gleich der Größe ist, befindet sich der Iterator am Ende der Liste
            this.nextNode = null;
        } else {
            // Andernfalls suchen wir den entsprechenden Knoten und setzen den Iterator darauf
            this.nextNode = getNode(index);
        }

        this.lastReturnedNode = null;
        this.nextIndex = index;
    }

    @Override
    public boolean hasNext() {
        return nextNode != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        lastReturnedNode = nextNode;
        nextNode = nextNode.next;
        nextIndex++;
        return lastReturnedNode.element;
    }

    @Override
    public boolean hasPrevious() {
        return nextNode != head;
    }

    @Override
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }

        if (nextNode == null) {
            // Wenn der Iterator am Ende der Liste ist, ist das vorherige Element das letzte Element (tail)
            lastReturnedNode = tail;
            nextNode = tail;
        } else {
            // Andernfalls befindet sich das vorherige Element direkt vor dem aktuellen Knoten
            lastReturnedNode = nextNode.prev;
            nextNode = nextNode.prev;
        }

        nextIndex--;
        return lastReturnedNode.element;
    }

    @Override
    public int nextIndex() {
        return nextIndex;
    }

    @Override
    public int previousIndex() {
        return nextIndex - 1;
    }

    @Override
    public void remove() {
        if (lastReturnedNode == null) {
            throw new IllegalStateException("No element to remove");
        }

        Node<E> prevNode = lastReturnedNode.prev;
        Node<E> nextNode = lastReturnedNode.next;

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

        lastReturnedNode.prev = null;
        lastReturnedNode.next = null;
        lastReturnedNode = null;

        size--;
        nextIndex--;
    }

    @Override
    public void set(E e) {
        if (lastReturnedNode == null) {
            throw new IllegalStateException("No element to set");
        }

        lastReturnedNode.element = e;
    }

    @Override
    public void add(E e) {
        if (nextNode == null) {
            // Wenn der Iterator am Ende der Liste ist, fügen wir das Element ans Ende hinzu
            add(e);
        } else {
            // Andernfalls fügen wir das Element vor dem aktuellen Knoten hinzu
            Node<E> newNode = new Node<>(e, nextNode.prev, nextNode);
            nextNode.prev.next = newNode;
            nextNode.prev = newNode;
            size++;
            nextIndex++;
            lastReturnedNode = null;
        }
    }
}
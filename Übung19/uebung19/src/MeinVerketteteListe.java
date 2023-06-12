// import java.util.*;

// public class MeinVerketteteListe<E> extends DoppeltVerketteteListe<E> {
//     private DoppeltVerketteteListe<Integer> list;
//     private int sizeTest;


//     public void testListe(){
//         list = new DoppeltVerketteteListe<>();

//         //test fuer add()
//         list.add(1);
//         sizeTest++;
//         list.add(2);
//         sizeTest++;
//         list.add(3);
//         sizeTest++;
//         list.add(4);
//         sizeTest++;
//         System.out.println(list);

//         //test fuer size();
//         System.out.println("Das groesse der von das VerketteteListe ist :" + list.size() + " und MeinVerketteteListe hat gezählt dass es " + sizeTest + " elemente gibt");
//         //test fuer remove()
//         list.remove(2);
//         sizeTest--;
//         System.out.println(list);

//         //test fuer clear()
//         list.clear();
//         System.out.println(list);
//     }



//     public static void main(String[] args){
//         testListe();
//     }

//     @Override
//     public Iterator<E> iterator() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'iterator'");
//     }

//     @Override
//     public ListIterator<E> listIterator(int index) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
//     }

//     @Override
//     public List<E> subList(int fromIndex, int toIndex) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'subList'");
//     }











































//     // public MeinVerketteteListe() {
//     //     super();
//     // }

//     // public MeinVerketteteListe(Collection<? extends E> c) {
//     //     super();
//     // }
//     // //why does Node not work ? The type Node is not visibleJava(16777219)
//     // // to solve this we could import the Node class from DoubleLinkedList
//     // // but this would be a bad solution because we would have to import the Node class from DoubleLinkedList
//     // // every time we want to use it
//     // // a better solution would be to make the Node class public in DoubleLinkedList but this is vorbiden
//     // // why do we need to implement all these methods ?
//     // // because the class DoubleLinkedList implements the interface List
//     // //but we arent in the DoubleLinkedList class we are in the MeinLinkedList class so we dont have to implement these methods
//     // // but we have to implement them because we are implementing the interface List 
//     // // and the interface List has these methods
//     // // which method does the interface List have in this doc ?
//     // // the interface List has the methods add, addAll, clear, contains, isEmpty, iterator, listIterator, remove, size, subList, toArray
//     // @Override
//     // public boolean add(E e) {
//     //     if (e == null) {
//     //         throw new NullPointerException();
//     //     }
//     //     Node<E> newNode = new Node<>(e);
//     //     if (head == null) {
//     //         head = newNode;
//     //         tail = newNode;
//     //     } else {
//     //         tail.next = newNode;
//     //         newNode.prev = tail;
//     //         tail = newNode;
//     //     }
//     //     size++;
//     //     return true;
//     // }

//     // @Override
//     // public boolean remove(Object o) {
//     //     Node<E> currentNode = head;
//     //     while (currentNode != null) {
//     //         if (Objects.equals(currentNode.element, o)) {
//     //             unlink(currentNode);
//     //             return true;
//     //         }
//     //         currentNode = currentNode.next;
//     //     }
//     //     return false;
//     // }

//     // private void unlink(Node<E> node) {
//     //     Node<E> prevNode = node.prev;
//     //     Node<E> nextNode = node.next;

//     //     if (prevNode != null) {
//     //         prevNode.next = nextNode;
//     //     } else {
//     //         head = nextNode;
//     //     }

//     //     if (nextNode != null) {
//     //         nextNode.prev = prevNode;
//     //     } else {
//     //         tail = prevNode;
//     //     }

//     //     node.prev = null;
//     //     node.next = null;

//     //     size--;
//     // }

//     // @Override
//     // public boolean addAll(Collection<? extends E> c) {
//     //     boolean modified = false;
//     //     for (E element : c) {
//     //         add(element);
//     //         modified = true;
//     //     }
//     //     return modified;
//     // }

//     // @Override
//     // public void clear() {
//     //     Node<E> currentNode = head;
//     //     while (currentNode != null) {
//     //         Node<E> nextNode = currentNode.next;
//     //         currentNode.prev = null;
//     //         currentNode.next = null;
//     //         currentNode.element = null;
//     //         currentNode = nextNode;
//     //     }
//     // }

//     // @Override
//     // public Iterator<E> iterator() {
//     //     // TODO Auto-generated method stub
//     //     throw new UnsupportedOperationException("Unimplemented method 'iterator'");
//     // }

//     // @Override
//     // public ListIterator<E> listIterator(int index) {
//     //     // TODO Auto-generated method stub
//     //     throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
//     // }

//     // @Override
//     // public List<E> subList(int fromIndex, int toIndex) {
//     //     // TODO Auto-generated method stub
//     //     throw new UnsupportedOperationException("Unimplemented method 'subList'");
//     // }
// }
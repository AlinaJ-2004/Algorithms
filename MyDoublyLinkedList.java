import java.util.LinkedList;
import java.util.*;
public class MyDoublyLinkedList<T> {

    public MyDoublyList<T> head;

    public MyDoublyList<T> tail;


    public class MyDoublyList<T> {

        private T data;

        private MyDoublyList<T> next;

        private MyDoublyList<T> prev;

        MyDoublyList(T data) {
            this(data, null, null);
        }

        MyDoublyList(T data, MyDoublyList<T> next, MyDoublyList<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        T getData() {
            return data;
        }

    }



    public void display() {
        MyDoublyList<T> current = head;
        for (int i = 0; i < getSize()+1; i++) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }


    public void addToEnd(T data) {
        MyDoublyList<T> current = new MyDoublyList<T>(data);
        if (tail == null) {
            head = current;
            tail = current;
            current.next = null;
            current.next = null;
        } else {
            current.prev = tail;
            tail.next = current;
            tail = current;
        }
    }

    public void addToBeginning(T data) {
        MyDoublyList<T> current = new MyDoublyList<T>(data);
        if (head == null) {
            head = current;
            tail = current;
            current.next = null;
            current.prev = null;
        } else {
            current.next = head;
            head.prev = current;
            head = current;
        }
    }


    public T remove(int position) {
        T data = null;
        if (position == 1) {
            data = head.getData();
            head = head.next;
        } else if (position == getSize()) {
            data = tail.getData();
            tail = tail.prev;
            tail.next = null;
        } else {
            MyDoublyList<T> temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.next;
            }
            MyDoublyList<T> node = temp.next;
            node.prev = temp.prev;
            temp.prev.next = node;
            temp = null;
        }
        return data;
    }

    public int find(T keyitem) {
        MyDoublyList<T> current = head;
        for(int i = 0; i < getSize()+1; i++){
            if(current.data == keyitem){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public void reverse( ) {
        MyDoublyList<T> temp = head;
        head = tail;
        tail = temp;
        MyDoublyList<T> current = head;

        while(current!= null)
        {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.next;
        }
    }

    public int getSize() {
        int count = 0;
        if (head == null)
            return count;
        else {
            MyDoublyList<T> temp = head;
            do {
                temp = temp.next;
                count++;
            } while (temp != tail);
        }
        return count;
    }

    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        list.addToEnd(4);
        list.addToBeginning(10);
        System.out.println("The list:");
        list.display();
        System.out.println();
        System.out.println("The size of the list:");
        System.out.println(list.getSize());
        System.out.println("The removed element:");
        System.out.println(list.remove(3));
        System.out.println("DoublyLinkedList after the removal of elements based on their indexes:");
        list.display();
        System.out.println();
        System.out.println("Finding elements by their indexes, if no such elements, then output -1:");
        System.out.println(list.find(1));
        System.out.println(list.find(3));
        System.out.println(list.find(6));
        System.out.println();
        System.out.println("Reversing the DoublyLinkedlist:");
        list.reverse();
        list.display();
    }

}
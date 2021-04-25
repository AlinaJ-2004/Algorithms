import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
public class MyLinkedList<T>
{
        public MyList<T> head;
        public MyList<T> tail;
        public int size;

        public MyLinkedList(){
         head = null;
         size = 0;
        }



    public void add(T newItem)
    {
        MyList<T> list = new MyList<>(newItem);
       if (head==null){
           head = tail = list;
       }
       else{
           tail.next = list;
           tail = list;
       }
       size++;
    }


    private static class MyList<E>{
        E data;
        MyList<E> next;
        MyList(E data){
            this.data = data;
        }

    }

    public void display() {
        MyList<T> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public T get(int index){
        MyList<T> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public T remove(int index) {
        MyList<T> removedElement = head;
        for (int i = 0; i < index; i++){
            removedElement = removedElement.next;
        }

        if (index == 0) {
            head = head.next;
        } else {
            MyList<T> current = head;
            MyList<T> curr = null;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            curr = current.next;
            current.next = curr.next;
            curr = null;
        }
        size--;
        return removedElement.data;
    }

    public int find(T keyitem) {
        MyList<T> current = head;
        for(int i = 0; i < size; i++){
            if(current.data == keyitem){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public  void reverse(){
        MyList<T> prevElement=null;
        MyList<T> nextElement=null;
        MyList<T> current=head;
            while(current!=null)
            {
                nextElement=current.next;
                current.next=prevElement;
                prevElement=current;
                current=nextElement;
            }
            head=prevElement;
    }


    public static void main(String[] args)
    {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Linked list: ");
        list.display();
        System.out.println();
        System.out.println("The removed element:");
        System.out.println(list.remove(2));
        System.out.println("LinkedList after the removal of elements based on their indexes:");
        list.display();
        System.out.println();
        System.out.println("Finding elements by their indexes, if no such elements, then output -1:");
        System.out.println(list.find(5));
        System.out.println("Reversing the MyLinkedlist:");
        list.reverse();
        list.display();
    }
}

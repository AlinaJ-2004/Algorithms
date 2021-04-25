import java.util.ArrayList;
import java.util.Collection;

public class Test<T>{
    public Object[] array;
    public int capacity = 5;
    public int size = 0;

    public Test(){
        array = new Object[capacity];
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void add(T newItem){
        if (size==capacity){
            capacity = (int)(1.5*capacity);
            Object[] array2 = new Object[capacity];
            for (int i = 0; i < size; i++){
                array2[i] = array[i];
            }
        }
        array[size++] = newItem;
    }


    public int find(T keyitem) {
        int i;
        for(i = 0; i < size; i++){
            if(array[i] == keyitem){
                return i;
            }
        }
        return -1;
    }

    public T remove(int index){
        int i;
        T removedElement = (T) array[index];
        for(i = index; i < size - 1; i++){
            array[i] = array[i + 1];

        }
        size--;
        return removedElement;
    }

    public  void reverse(){
        for(int i=0; i<size/2; i++)
        {
            T temp = (T) array[i];
            array[i] = array[size -i -1];
            array[size -i -1] = temp;
        }

    }

    public static void main(String[] args){
        Test arr = new Test();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        System.out.println("The list:");
        arr.display();
        System.out.println();
        System.out.println("Finding elements by their indexes, if no such elements, then output -1:");
        System.out.println(arr.find(1));
        System.out.println(arr.find(3));
        System.out.println(arr.find(6));
        System.out.println();
        System.out.println("The removed element:");
        System.out.println(arr.remove(1));
        System.out.println("ArrayList after the removal of elements based on their indexes:");
        arr.display();
        System.out.println();
        System.out.println("Reversing the MyArraylist:");
        arr.reverse();
        arr.display();
    }
}
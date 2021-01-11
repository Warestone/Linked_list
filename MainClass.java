import java.util.LinkedList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        //TESTS
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.remove(1);
        myLinkedList.set(0,1000);
        myLinkedList.clear();
        myLinkedList.add(1000);
        myLinkedList.add(5000);
        myLinkedList.add(10000);
        int index = myLinkedList.indexOf(10000);
        int value = myLinkedList.get(2);
        Integer[] mass = new Integer[myLinkedList.size()];
        mass = myLinkedList.toArray(mass);
        String asd = myLinkedList.toString();
        myLinkedList.clear();

        System.out.println("My linked list time:   "+ workWithMyCollection() +"\nJava linked list time: " +workWithJavaCollection());
        //OUTPUT:
        /*My linked list time:   17371400
          Java linked list time: 16390100*/
    }

    private static long workWithMyCollection(){
        long timeStart;
        timeStart = System.nanoTime();
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i=1; i<=100000; i++)myLinkedList.add(i);           // add
        myLinkedList.indexOf(735);                                  // search
        myLinkedList.remove(600);                              // remove
        myLinkedList.set(50,1000);                                  // set
        myLinkedList.clear();                                       // clear
        return System.nanoTime()-timeStart;
    }

    private static long workWithJavaCollection(){
        long timeStart;
        timeStart = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i=1; i<=100000; i++)linkedList.add(i);           // add
        linkedList.indexOf(735);                                  // search
        linkedList.remove(600);                              // remove
        linkedList.set(50,1000);                                  // set
        linkedList.clear();                                       // clear
        return System.nanoTime()-timeStart;
    }
}

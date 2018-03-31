package chapter4;

public class ArrayQueueDriver {

    public static void main(String[] args) {

        ArrayQueue a = new ArrayQueue();

//        System.out.println(a); // arrayQueue is null;

        System.out.println(a.getSize());
        System.out.println(a.getCapacity());
        System.out.println(a.getFront());
        System.out.println(a.getRear());


        a.offer("Jim");

//        System.out.println(a);


    }
}

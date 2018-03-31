package lab4;

/**
 * LinkedListQueue Driver to test methods.
 *
 * @author gabrielsiguenza
 */
public class LLQueueTester {

    public static void main(String[] args) {
        LLQueue<String> linkedListQueue;

        linkedListQueue = new LLQueue<>();

        System.out.println(linkedListQueue);

        System.out.println("\nTesting offer method, \nadding Gabriel to the Queue...\n" +
                "adding Jose to the Queue...\nadding Nicholas Cage to the Queue..." );
        linkedListQueue.offer("Gabriel");
        linkedListQueue.offer("Jose");
        linkedListQueue.offer("Nicholas Cage");

        System.out.println("\nDisplaying Queue contents:\n" + linkedListQueue);

        System.out.println("\nTesting peek method: " + linkedListQueue.peek());

        System.out.println("\nTesting poll method: " + linkedListQueue.poll());

        System.out.println("\nDisplaying list to show that Gabriel has been removed:\n" + linkedListQueue);

        System.out.println("\nTesting element method: " + linkedListQueue.element());

        System.out.println("Testing remove method: " + linkedListQueue.remove());

        System.out.println(linkedListQueue);

        System.out.println("Testing add method, adding Luke Skywalker to the Queue: "
                + linkedListQueue.add("Luke Skywalker"));

        System.out.println(linkedListQueue);
    }

}

/**
 * A class demonstrating different Algorithm Complexities.
 *
 * @author gabrielsiguenza
 */
public class BigONotation {

      /*
    O(1)
    O(N)
    O(N^2)
    O(log N)
    O(n log n)
     */

    private int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    private static long startTime;
    private static long endTime;

    // O (N^2) O(N^2)
    public void bubblesort(){

        startTime = System.currentTimeMillis();

        for(int i = arraySize - 1; i > 1; i--){

            for(int j = 0; j < i; j++){

                if(theArray[j] > theArray[j+1]){

                    swapValues(j, j+1);

                }

            }

        }

        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort Took " + (endTime - startTime) + " Milliseconds");

    }

    //O(log N)

    public void binarySearchForValue(int value){

        startTime = System.currentTimeMillis();

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        int timesThrough = 0;

        while(lowIndex <= highIndex){

            int middleIndex = (highIndex + lowIndex) / 2;

            if(theArray[middleIndex] < value){
                lowIndex = middleIndex + 1;
            }

            else if(theArray[middleIndex] > value){
                highIndex = middleIndex - 1;
            }

            else{

                System.out.println("Found Match in index " + middleIndex);
                lowIndex = highIndex + 1;

            }

            timesThrough++;

        }

        endTime = System.currentTimeMillis();
        System.out.println("Binary Search Took " + (endTime - startTime) + " Milliseconds");
        System.out.println("Algorithm ran " + timesThrough + " times");

    }

    // O(n log n)

    // Comparisons = log n!(Factorial)
    // Comparisons = log n + log(n-1)+ ..... + log(1)
    // Comparisons = n log n (simplifying this whole factorial)
    public void quickSort(int left, int right){

        if(right - left <=0){
            return;
        }

        else{

            int pivot = theArray[right];
            int pivotLocation = partitionArray(left, right, pivot);
            quickSort(left, pivotLocation - 1);
            quickSort(pivotLocation + 1, right);

        }
    }

    public int partitionArray(int left, int right, int pivot){

        int leftPointer = left - 1;
        int rightPointer = right;

        while(true) {

            while (theArray[++leftPointer] < pivot) ;

            while (rightPointer > 0 && theArray[--rightPointer] > pivot) ;

            if (leftPointer >= rightPointer) {
                break;
            } else {

                swapValues(leftPointer, rightPointer);

            }
        }

            swapValues(leftPointer, right);
            return leftPointer;

    }

    BigONotation(int size){

        arraySize = size;
        theArray = new int[size];
    }

    public static void main(String[] args){

        BigONotation testAlgo2 = new BigONotation(100000);
        testAlgo2.generateRandomArray();

        BigONotation testAlgo3 = new BigONotation(400000);
        testAlgo3.generateRandomArray();

        BigONotation testAlgo4 = new BigONotation(700000);
        testAlgo4.generateRandomArray();
/*
        testAlgo2.bubblesort();
        testAlgo3.bubblesort();

        *//*
        Here we can see why measuring the time in milliseconds doesn't really matter when we are dealing with very
        efficient algorithms, and why Big O notation tells us a lot more about an algorithm than how long or how
        many milliseconds the algorithm takes to execute.
         *//*

        testAlgo2.binarySearchForValue(20);
        testAlgo3.binarySearchForValue(20);*/

        startTime = System.currentTimeMillis();

        testAlgo2.quickSort(0 , testAlgo2.itemsInArray);

        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort Took" + (endTime - startTime));
    }
    // O(1) constant time. (code that executes in the same amount of time

    // no matter how big the array is)

    public void addItemToArray(int newItem){

        theArray[itemsInArray++] = newItem;
    }

    // O(n)

    public void linearSearchForValue(int value){

        boolean valueInArray = false;

        // Forces it so that it will search through the entire array because compiler will stop if it isn't told that it needs to find more than one
        String indexsWithValue = "";

        startTime = System.currentTimeMillis();

        for(int i = 0; i < arraySize; i ++){

            if(theArray[i] == value){

                valueInArray = true;
                indexsWithValue += i + " ";

            }

        }

        System.out.println("Value Found: " + valueInArray);
        endTime = System.currentTimeMillis();
        System.out.println("Linear Search Took " + (endTime - startTime) + " Milliseconds");
    }

    public void generateRandomArray(){

        for (int i = 0; i < arraySize; i++){

            theArray[i] = (int) (Math.random() * 1000) + 10;
        }

        itemsInArray = arraySize - 1;
    }

    public void swapValues(int indexOne, int indexTwo){

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

}

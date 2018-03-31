package printerQueue;

/**
 * Class to simulate sending 100 print jobs to the printer that vary in number of pages.
 * Test implementation of the OSPrintQueue class, and the Printer class.
 */
public class JobSimulation {

    public static Timestamp timeData = new Timestamp();

    public static void main(String[] args) {

        /* Instantiate necessary class objects */
        OSPrintQueue systemQueue = new OSPrintQueue();

        System.out.println("Beginning print job simulation...");

        timeData.setAll("March", 13,2018);
        timeData.setAll(15,00,00);
        int timeElapsed = timeData.getMinute();
        int timeElapsedHour = 0;

        OSPrintQueue.setNumberOfPrinters(3);

        System.out.println("\nCurrent simulation date and time: \n" + timeData);
        System.out.println("Total elapsed time: " + timeElapsedHour + " hour(s), " + timeElapsed + " minutes");

        System.out.println("\nNumber of active printers: " + systemQueue.getNumberOfPrinters());

        for(int i = 0; i < 100; i++) {
            timeElapsed++; // make a print request every minute.
            if(timeElapsed == 60) {
                timeElapsed = 0; // reset timeElapsed.
                timeElapsedHour++; // increment timeElapsedHour
                timeData.setHour((timeData.getHour()+1)); // increment the hour
                timeData.setMinute(0); // reset the minutes
            }
            int a = systemQueue.generateRandom();

            // create a new print job to assign
            PrintJob newJob = new PrintJob(a);

            // when a request is made increment minutes.
            timeData.setMinute(timeElapsed);

            //Every time a new job is generated assign the job to a printer.
            systemQueue.pushPrintJob(newJob);
        }



        System.out.println(systemQueue);

        systemQueue.print();


//        System.out.println("\nCurrent simulation date and time: \n" + timeData);
//        System.out.println("Total elapsed time: " + timeElapsedHour + " hour(s), " + timeElapsed + " minutes");

        /* There is a more elegant way to accomplish this. */
        if(systemQueue.getNumberOfPrinters() == 1) {
            System.out.println(OSPrintQueue.getPrint1());
            System.out.print("(" + (OSPrintQueue.getPrint1().getTotalElapsedTime() / 60) + " minutes " + OSPrintQueue.getPrint1().getTotalElapsedTime() % 60 + " seconds" + ")");
        }

        if(systemQueue.getNumberOfPrinters() == 2) {
            System.out.println(OSPrintQueue.getPrint1());
            System.out.print("(" + (OSPrintQueue.getPrint1().getTotalElapsedTime() / 60) + " minutes " + OSPrintQueue.getPrint1().getTotalElapsedTime() % 60 + " seconds" + ")");

            System.out.println(OSPrintQueue.getPrint2());
            System.out.print("(" + (OSPrintQueue.getPrint2().getTotalElapsedTime() / 60) + " minutes " + OSPrintQueue.getPrint2().getTotalElapsedTime() % 60 + " seconds" + ")");
        }

        int totalMin = 0;
        int totalSeconds = 0;

        if(systemQueue.getNumberOfPrinters() == 3) {
            totalMin += OSPrintQueue.getPrint1().getTotalElapsedTime() /60;
            totalMin += OSPrintQueue.getPrint2().getTotalElapsedTime() /60;
            totalMin += OSPrintQueue.getPrint3().getTotalElapsedTime() /60;
            totalSeconds += OSPrintQueue.getPrint1().getTotalElapsedTime() %60;
            totalSeconds += OSPrintQueue.getPrint2().getTotalElapsedTime() %60;
            totalSeconds += OSPrintQueue.getPrint3().getTotalElapsedTime() %60;


            System.out.println(OSPrintQueue.getPrint1());
            System.out.print("(" + (OSPrintQueue.getPrint1().getTotalElapsedTime() / 60) + " minutes " + OSPrintQueue.getPrint1().getTotalElapsedTime() % 60 + " seconds" + ")");

            System.out.println(OSPrintQueue.getPrint2());
            System.out.print("(" + (OSPrintQueue.getPrint2().getTotalElapsedTime() / 60) + " minutes " + OSPrintQueue.getPrint2().getTotalElapsedTime() % 60 + " seconds" + ")");

            System.out.println(OSPrintQueue.getPrint3());
            System.out.print("(" + (OSPrintQueue.getPrint3().getTotalElapsedTime() / 60) + " minutes " + OSPrintQueue.getPrint3().getTotalElapsedTime() % 60 + " seconds" + ")");

            System.out.println("\nTotal Minutes: " + totalMin + "\nTotal Seconds: " + totalSeconds);
            totalMin += totalSeconds / 60;
            System.out.print(totalMin / 60 + " Hours, ");
            System.out.print(totalMin % 60 + " Minutes, ");
            System.out.print(totalSeconds % 60 + " Seconds");

            timeData.setHour(timeData.getHour()+(totalMin / 60));
            timeData.setMinute(timeData.getMinute()+(totalMin % 60));
            timeData.setSecond(totalSeconds%60);

        }


        // calculate the totalMin

        System.out.println("\n\nCurrent simulation date and time: \n" + timeData);
        System.out.println("Total elapsed time: " + timeElapsedHour + " hour(s), " + timeElapsed + " minute(s)");

        // Use this statement to check the status of the print Queues.
//        System.out.println(systemQueue);

        //        calculateTotalTime(OSPrintQueue.getPrint1().getTotalElapsedTime() + OSPrintQueue.getPrint2().getTotalElapsedTime() + OSPrintQueue.getPrint3().getTotalElapsedTime());

//        System.out.println(systemQueue.getSmallJobs() + "\n" + systemQueue.getMediumJobs() + "\n" + systemQueue.getLargeJobs());
        /*
        You have your rules of priority, each time a printing job is sent to the queue.
        it needs to prioritize based off that rule, otherwise implement your tie breaker
        rule: which is order received.
        */


//        for(int i = 0; i < 99; i++) {
//            OSPrintQueue.decrementJobs();
//        }
//
//        OSPrintQueue.decrementJobs();
    }

    public static void calculateTotalTime(int i) {
        System.out.println(i);
    }
}

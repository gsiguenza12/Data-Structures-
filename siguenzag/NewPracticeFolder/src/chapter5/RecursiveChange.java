package chapter5;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveChange {
        public static final double P = 0.01;
        public static final double N = 0.05;
        public static final double D = 0.10;
        public static final double Q = 0.25;

        public static void main(String [] args) {
            Scanner keyboard;
            keyboard = new Scanner(System.in);

            // The master list of combinations.
            ArrayList<ArrayList> combinations = new ArrayList<>();

            // holds the different amounts to check recursively
            ArrayList<Double> a = new ArrayList<>();
            double desiredAmount = 0;

            System.out.println("Please enter an amount:\n");
            desiredAmount = keyboard.nextDouble();
            recursiveChangeDispenser(desiredAmount);
        }

        /**
         * Display all combinations that equal the desired amount.
         *
         * @param desiredAmount
         * @return
         */
        public static int recursiveChangeDispenser(double desiredAmount) {



            return 0;
        }
}


package Siguenza_Gabriel_HW1;

/**
 * @author gabrielsiguenza
 *
 * Driver for AssistantJack program, Guesses the correct Theory with 22 options,
 * within 20 tries using deductive reasoning
 *
 * Algorithm:
 * Answers given need to be within the range of possible selections(w <= 6, l <= 10, m <= 6)
 * 1. WHILE (the theory is incorrect)
 * 2. Increment the number of times AssistantJack was called.
 * 3. Check for wrong answer returned by AssistantJack.
 * 4. Increment the answer that was wrong to try another combination
 * (process of elimination).
 * When the correct Theory is guessed, loop is terminated and results are printed to console.
 */
public class Main {

    public static void main(String[] args) {

        AssistantJack jack = new AssistantJack(2);

        int foundMurder = 0;
        int foundWeapon = 0;
        int foundLocation = 0;

        int w = 1;
        int l = 1;
        int m = 1;

        int wrongAnswer = 1;
        // 1 is weapon, 2 is location, 3 is person.
        while(wrongAnswer != 0)
        {
            System.out.println("\n\nTesting Theory... Times Asked = " + jack.getTimesAsked());
            System.out.println("\nJILL: I have solved the case! I believe it was " + TheoryItem.getWeaponName(w) +", " + TheoryItem.getLocationName(l) + ", " + TheoryItem.getPersonName(m));
            wrongAnswer = jack.checkAnswer(w, l, m);
            jack.addTimesAsked();

            // if no wrong answer is given guessed correct Theory!
            if(wrongAnswer == 0)
            {
                foundMurder = m;
                foundWeapon = w;
                foundLocation = l;
                System.out.println("Assistant Jack: Guessed Correct Theory!");
            }
            else
            {
                System.out.println("Assistant Jack: Guessed Incorrect Theory, Returning one of the incorrect answers: " + wrongAnswer + ", ");
                switch(wrongAnswer)
                {
                    case 1:
                        System.out.print(TheoryItem.getWeaponName(w));
                        break;

                    case 2:
                        System.out.print(TheoryItem.getLocationName(l));
                        break;
                    case 3:
                        System.out.print(TheoryItem.getPersonName(m));
                        break;

                    default:
                        break;
                }
            }

            // if the weapon is wrong increment weapon.
            if(wrongAnswer == 1)
            {
                if(w < 6) {w ++ ;}
            }

            // if location is wrong increment location
            if(wrongAnswer == 2)
            {
                if(l < 10){l ++;}
            }

            // if person is wrong increment person (m)
            if(wrongAnswer == 3)
            {
                if(m < 6){m++;}
            }

            // only increment if that guess has been deemed incorrect. Adding deductive reasoning
            // to Jill's detective skill set.
        }

        // This method guesses all 360 possibilities. Iterates through all possibilities, THEN returns corrects answer
        /*
        for (int m = 1; m <= TheoryItem.TOTAL_MURDERS; m++) {
            for (int l = 1; l <= TheoryItem.TOTAL_LOCATIONS; l++) {
                for (int w = 1; w <= TheoryItem.TOTAL_WEAPONS;w++) {
                    int checkAnswer = jack.checkAnswer(w, l, m);
                    jack.addTimesAsked();
                    System.out.println("Guess: " + w + ", " + l + ", " + m);
                    System.out.println("Incorrect Answer = " + checkAnswer);
                    if(checkAnswer == 0) {
                        foundMurder = m;
                        foundWeapon = w;
                        foundLocation = l;
                    }
                }
            }
        }*/

        System.out.println("\nThe correct answer is " +
                TheoryItem.getPersonName(foundMurder) + "," +
                TheoryItem.getLocationName(foundLocation) + "," +
                TheoryItem.getWeaponName(foundWeapon));

        System.out.println("Assistant Jack: Jill correctly guessed: " +
                foundMurder + "," +
                foundLocation + "," +
                foundWeapon);
        
        System.out.println("Assistant Jack was asked " + jack.getTimesAsked() + " times!");

        if(jack.getTimesAsked() <= 20)
        {
            System.out.println("\nTest Passed! Great deductive reasoning, Jill!");
        }
        else
        {
            System.out.println("\nTest Failed!");
        }

    }

}

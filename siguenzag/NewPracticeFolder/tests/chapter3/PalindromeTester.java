package chapter3;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTester {

    /**
     * Checks if parameter is a palindrome using stacks and
     * ignores whitespace + case sensitivity; doesn't ignore digits/symbols
     *
     * @param s any chars allowed,
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     */
    public static boolean isPalindrome(String s) {

        if(s == null)
        {
            throw new IllegalArgumentException();
        }

        s = s.replace(" ", "");

        if(s.length() == 2) {

            if(s.charAt(0) == s.charAt(1)) {
                return true;
            }
            else {
                return false;
            }
        }

        StringBuilder result = new StringBuilder();
        ArrayListStack<Character> stack1 = new ArrayListStack<>();
        //Gets rid of the white space in the parameter being passed in & turns
        //all characters to lowercase
//        s = s.replace(" ", "");
        s = s.toLowerCase();
        //Fills stack1 with each character in side of the parameter being passed in
        for (int i = 0; i < String.valueOf(result).length(); i++) {
            stack1.push(s.charAt(i));
        }
        //While stack1 is not empty(), remove each character and add them to the
        //string result
        while(!stack1.empty())
        {
            result.append(stack1.pop());
        }
        //If the string result == null than throw exception
        if (result == null) {
            throw new IllegalArgumentException();
        }
        //If the string result is equal to or less than 1 character than return tru
        if(result.length() <= 1)
        {
            return true;
        }
        //If the character from string result in position 0 to 1 is the same as the
        //the character at the end of the string result and so on than return isPalindrome
        if(result.substring(0,1).equalsIgnoreCase(result.substring(result.length() - 1, result.length())))
        {
            return isPalindrome(result.substring(1, result.length() - 1));
        }
        return false;
/*
        if(s == null)
        {
            throw new IllegalArgumentException();
        }
        s = s.replace(" ", "");
        s = s.toLowerCase();
        if(s.length() <= 1)
        {
            return true;
        }
        if(s.substring(0, 1).equalsIgnoreCase(s.substring(s.length() - 1, s.length())))
        {
            return isPalindrome(s.substring(1, s.length() - 1));

        }
        return false;
        */
    }

    @Test
    public void testErrors() {
        try {
            isPalindrome(null);
            fail("Checking null to see if it's a palindrome should throw IllegalArgumentException!");
        } catch (IllegalArgumentException iae) { /* Test Passed! */ }
    }

    @Test
    public void testSimpleTrueCases() {
        assertTrue("This test is a palindrome", isPalindrome(""));
        assertTrue("This test is a palindrome", isPalindrome(" "));
        assertTrue("This test is a palindrome", isPalindrome("A"));
        assertTrue("This test is a palindrome", isPalindrome("7"));
        assertTrue("This test is a palindrome", isPalindrome("%"));

        assertTrue("This test is a palindrome", isPalindrome("  "));
        assertTrue("This test is a palindrome", isPalindrome("BB"));
        assertTrue("This test is a palindrome", isPalindrome("33"));
        assertTrue("This test is a palindrome", isPalindrome("**"));
    }

    @Test
    public void testSimpleFalseCases() {
        assertFalse("This test is NOT a palindrome", isPalindrome("AC"));
        assertFalse("This test is NOT a palindrome", isPalindrome("71"));
        assertFalse("This test is NOT a palindrome", isPalindrome("@+"));
    }

    @Test
    public void testWhitespaceCases() {
        assertTrue("This test is a palindrome", isPalindrome(" x "));
        assertTrue("This test is a palindrome", isPalindrome(" t   t  "));
        assertTrue("This test is a palindrome", isPalindrome(" 5 5"));
        assertTrue("This test is a palindrome", isPalindrome(" #      # "));

        /*These 3 cases are causing it to fail. */
        assertFalse("This test is NOT a palindrome", isPalindrome("m   n  "));
        assertFalse("This test is NOT a palindrome", isPalindrome("   8  7 "));
        assertFalse("This test is NOT a palindrome", isPalindrome("  ^      &  "));
    }

    @Test
    public void testCaseSensitivityCases() {
        assertTrue("This test is a palindrome", isPalindrome("ABba"));
        assertTrue("This test is a palindrome", isPalindrome("roTOR"));
        assertTrue("This test is a palindrome", isPalindrome("rAceCaR"));
    }

    @Test
    public void testComplexCases() {
        assertTrue("This test is a palindrome", isPalindrome("fOO race CAR ooF"));
        assertTrue("This test is a palindrome", isPalindrome("AbBa ZaBba"));
        assertTrue("This test is a palindrome", isPalindrome("1 3 3 7  331"));
        assertTrue("This test is a palindrome", isPalindrome("sT RJKLEeE R#@ $A$ @# REeEL K  JRT s"));

    }
}

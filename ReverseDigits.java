import java.util.Scanner;

/**
 * This program reads in an integer, and outputs the reversed integer.
 *
 * @author Bill Bai
 * @teacher Ms.Krasteva
 * @version 1 2019.04.10
 */
public class ReverseDigits {
    /**
     * This recursive method reverses the digits of an integer. It works by raising a number to the power of the
     * log10 of the number on the opposite side, moving the number to the front. It then does this again with the
     * following numbers, adding them together. This then recurs until it reaches the basecase, when num < 10, which
     * just returns the num. This puts the first number in the last digit, successfully reversing the number inputted.
     * It then returns this new reversed number.
     *
     * @param num The integer to be reversed
     * @return The reversed integer.
     */
    public static int revDigits(int num) {
        if (num < 10)
            return num;
        return num % 10 * (int) Math.pow(10, (int) Math.log10(num)) + revDigits(num / 10);
    }

    /**
     * This is the main method. It gets the integer input, then displays the reversed integer.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer to be reversed: ");
        int num = s.nextInt();
        System.out.println("Your reversed number: " + revDigits(num));
    }
}

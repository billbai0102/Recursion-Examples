import java.util.Scanner;

/**
 * This program reads in String input until a single period, then reverses the input and outputs it.
 *
 * @author Bill Bai
 * @teacher Ms.Krasteva
 * @version 1 2019.04.10
 */
public class ReverseString {
    /**
     * This program takes in a String, then reverses it. It works through recursion. It works by adding every single
     * word one by one to the String, then stopping at the base case, which is the period. When outputted, it will
     * return a reversed String, with the period first.
     *
     * @param string The String to be reversed.
     * @return The reversed String that is inputted
     */
    static String reverse(String string) {
        if (string.equals("."))
            return ".";
        return reverse(string.substring(string.indexOf('\n') + 1)) + '\n' + string.substring(0, string.indexOf("\n"));
    }

    /**
     * This is the main method. It gets in the String input, and outputs the reversed version.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = "";
        String temp = "";
        while(!temp.equals(".")){
            temp = s.next();
            string += "\n" + temp;
        }
        System.out.println(reverse(string));
    }
}

import java.util.Arrays;

/**
 * This program finds a key in an array of comparables. The last element of the array is the key to be found.
 *
 * @author Bill Bai
 * @teacher Ms.Krasteva
 * @version 1 2019.04.10
 */
public class SearchItem {

    /**
     * This method checks if a key is present inside an array of comparables using recursion. It loops through
     * each element of the array using Arrays.copyOfRange, by decreasing the array each time. This way, it can check for
     * the element. If the element is not found until the last Comparable in the array, it will return false. It will
     * return true if found.
     *
     * @param arr The array and the key.
     * @param find The Comparable to be found
     * @return A boolean value, whether the Comparable exists in the array.
     */
    static boolean checkArray(Comparable[] arr, Comparable find) {
        if(arr.length < 2)
            return false;
        if(arr[0].compareTo(find) == 0)
            return true;
        return checkArray(Arrays.copyOfRange(arr,1, arr.length),find);
    }

    /**
     * This is the main method. It contains the array, and prints whether the key is found in the array.
     */
    public static void main(String[] args) {
        Comparable[] list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Comparable toFind = 5;
        if (checkArray(list, toFind) == true)
            System.out.println(toFind + " exists in the array!");
        else
            System.out.println(toFind + " doesn't exist in the array!");
    }
}

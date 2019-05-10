import java.util.ArrayList;
import java.util.List;

/**
 * This program returns a boolean based on whether a path can be found in a 5x5 matrix. It first loads every entrance
 * into an List, then checks for each maze entrance to find a path. It will return true or false.
 *
 * @author Bill Bai
 * @version 1 2019.04.10
 * @teacher Ms.Krasteva
 */
public class Maze {

    /**
     * This method finds paths in the maze passed to it. It works by moving the index up down left and right for each
     * recursion, if the neighbouring number is not 1. This way, it spreads outwards until it finds an exit, It will
     * return false if there are no more paths.
     *
     * @param maze The maze to find a path in.
     * @param row The current row in the array it's at.
     * @param col The current column in the array it's at.
     * @return A boolean representing whether the path has been found or not.
     */
    static boolean findPath(int[][] maze, int row, int col) {
        if (row < 0 || row > 4 || col < 0 || col > 4 || maze[row][col] != 0)
            return false;
        if ((row == 4 || col == 4) && maze[row][col] == 0)
            return true;
        maze[row][col] = 2;
        return findPath(maze, row + 1, col) || findPath(maze, row - 1, col) || findPath(maze, row, col + 1) || findPath(maze, row, col - 1);
    }

    /**
     * This method finds all starts inside of the maze. It works by searching all indexes that start or end with a zero,
     * and then checks if the actual number is a zero. It will store the coordinates in a List, then return that list.
     *
     * @param maze The maze that will be searched for entrances
     * @return The list of entrance coordinates.
     */
    static List<Integer> findStarts(int[][] maze) {
        List<Integer> coords = new ArrayList<Integer>();
        for (int x = 0; x < maze.length; x++)
            if (maze[x][0] == 0) {
                coords.add(x);
                coords.add(0);
            }
        for (int x = 0; x < maze[0].length; x++)
            if (maze[0][x] == 0) {
                coords.add(0);
                coords.add(x);
            }
        return coords;
    }

    /**
     * This is the main method. It contains the maze. It tests every single entrance for a path to the exit, and will
     * display whether an entrance can be found or not.
     */
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1}};
        String endMsg = "No paths were found.";
        List<Integer> starts = findStarts(maze);

        for (int x = 0; x < starts.size(); x += 2) {
            if (findPath(maze, starts.get(x), starts.get(x + 1))) {
                endMsg = "A path was found!";
                break;
            }
        }
        System.out.println(endMsg);
    }
}

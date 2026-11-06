import java.util.Arrays;

public class Assignment01Q04 {
    public static void shiftRightOnce (int[] array) {
        // Save the last value, then shift elements right.
        int temp = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }

    public static void shiftLeftOnce (int[] array) {
        // Save the first value, then shift elements left.
        int temp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = temp;
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        // Ignore null or too-short arrays and invalid directions.
        if (array == null || array.length < 2) {
            return array;
        }
        if (direction != 'L' && direction != 'R') {
            return array;
        }
        // A negative move reverses the direction.
        if (move < 0) {
            move = -move;
            direction = (direction == 'L') ? 'R' : 'L';
        }
        // Full rotations leave the array unchanged.
        if (move >= array.length) {
            move = move % array.length;
        }

        // Shift the array one position at a time.
        for (int i = 0; i < move; i++) {
            if (direction == 'L') {
                shiftLeftOnce(array);
            } else {
                shiftRightOnce(array);
            }
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}
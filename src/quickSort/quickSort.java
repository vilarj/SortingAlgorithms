package quickSort;

import java.util.Random;

/**
 * FASTEST ALGORITHM OF THEM ALL - in most cases:
 * This algorithms partitions the arrays so
 * that the smaller numbers are on the left
 * and the larger on the right.
 *
 * Recursively sends small parts of the larger
 * arrays to itself and partitions again.
 */

public class quickSort {
    private int[] list;
    private int size;
    private int values;

    public quickSort (int size) {
        this.size = size;
        list = new int[size];

        list = numberGenerator();
    }

    public void swap (int pos1, int pos2) {
        int temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
    }

    private void partition (int pivot) {
        int leftPointer = -1; // sort through the array until find a value greater than the pivot
        int rightPointer = size; // sort through the array until find a value smaller than the pivot

        while (true) {
            while (leftPointer < (size - 1) && list[++leftPointer] < pivot);
            System.out.println(list[leftPointer] + " in index " + leftPointer + " is > pivot value = " + pivot);
            while (rightPointer > 0 && list[--rightPointer] > pivot);
            System.out.println(list[rightPointer] + " in index " + rightPointer + " is < pivot value = " + pivot);

            if (leftPointer >= rightPointer) {break;}
            else {
                swap(leftPointer, rightPointer);
                System.out.println(list[leftPointer] + " was swapped for " + list[rightPointer]);
            }
        }
    }

    private int[] numberGenerator () {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public void toArray () {
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public void sort (int left, int right) {
        if (right - left <= 0) {
            return;
        }
        else {
            int pivot = list[right];
            System.out.println("Value in right " + list[right] + " is made pivot");

            System.out.println("left = " + left + ", right = " + right + ", pivot = " + pivot + " sent to partition");
            int pos = partition(left, right, pivot);

            System.out.println("Value in left " + list[left] + " is made pivot");
            sort(left, pos - 1);
            sort(pos + 1, right);

        }
    }

    public int partition (int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (list[++leftPointer] < pivot);
            System.out.println(list[leftPointer] + " in index " + leftPointer + " is > pivot value = " + pivot);
            while (rightPointer > 0 && list[--rightPointer] > pivot);
            System.out.println(list[rightPointer] + " in index " + rightPointer + " is < pivot value = " + pivot);

            if (leftPointer >= rightPointer) {
                System.out.println("left is >= right so start over");
                break;
            }
            else {
                swap(leftPointer, rightPointer);
                System.out.println(list[leftPointer] + " was swapped for " + list[rightPointer]);
            }
        }
        swap(leftPointer, right);
        return leftPointer;
    }

    // Driver
    public static void main(String[] args) {
        quickSort list = new quickSort(7);

        System.out.println("Original");
        list.toArray();
        System.out.println();

        System.out.println("Sorting the list...");
        list.sort(0, 6);
        System.out.println("\nOriginal is sorted");
        list.toArray();


    }
}

import addtwonumbers.ListNode;
import median.of.sorted.arrays.Solution;
import twosum.TwoSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});

        System.out.println(medianSortedArrays);


    }
}

package median.of.sorted.arrays;

public class Solution {
/*
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

    The overall run time complexity should be O(log (m+n)).



    Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.
    Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    Example 3:

    Input: nums1 = [0,0], nums2 = [0,0]
    Output: 0.00000
    Example 4:

    Input: nums1 = [], nums2 = [1]
    Output: 1.00000
    Example 5:

    Input: nums1 = [2], nums2 = []
    Output: 2.00000


    Constraints:

    nums1.length == m
    nums2.length == n
0 <= m <= 1000
            0 <= n <= 1000
            1 <= m + n <= 2000
            -106 <= nums1[i], nums2[i] <= 106
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalNumbersCount = nums1.length + nums2.length;
        int[] mergedArray = new int[totalNumbersCount];

        if(mergedArray.length == 0){
            return 0;
        }

        int[] mergedResult = mergeArrays(nums1, nums2, mergedArray, 0, 0, 0);
        int midIdx = (Math.round(mergedResult.length / 2) );
        if(midIdx < 0){
            midIdx = 0;
        }

        if (mergedResult.length % 2 == 0) {
            int m1 = mergedResult[midIdx - 1];
            int m2 = mergedResult[midIdx];
            return (m1 + m2) / 2.0;
        }

        return mergedResult[midIdx];
    }

    public int[] mergeArrays(int[] arr1,int[] arr2,int[] mergeArray,int i, int j, int k){
        if(i == arr1.length || j == arr2.length){
            appendToArrayFromIdx(k,mergeArray,arr1,i);
            appendToArrayFromIdx(k,mergeArray,arr2,j);
            return mergeArray;
        }

        if(arr1[i] <= arr2[j]){
            mergeArray[k] = arr1[i];
            return mergeArrays(arr1,arr2,mergeArray,++i,j,++k);
        }

        mergeArray[k] = arr2[j];
        return mergeArrays(arr1,arr2,mergeArray,i,++j,++k);
    }

    private void appendToArrayFromIdx(int idxToStartFrom,int[] array, int[] arrayToAppend,int appendIdx) {
        if(idxToStartFrom >= array.length || appendIdx >= arrayToAppend.length){
            return;

        }
        array[idxToStartFrom] = arrayToAppend[appendIdx];

        appendToArrayFromIdx(++idxToStartFrom,array,arrayToAppend,++appendIdx);
    }
}

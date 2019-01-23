/** The problem

There are two nonempty sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] merged = new int[length];
        int i, j, k;
        i = j = k = 0;
        while (i< nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }

        while (i< nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while (j< nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        if (length % 2 != 0) {
            return merged[length/2];
        } else {
            return (double) (merged[length/2 -1] + merged[length/2])/2;
        }
    }
}

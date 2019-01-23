/**The problem

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Returned answers (both index1 and index2) are not zero-based.
May assume that each input would have exactly one solution and you may not use the same element twice.*/

import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        int back = nums.length - 1;
        for (int i=0; i< nums.length; i++) {
            while (nums[back] + nums[i] > target) {
                back -= 1;
            }
            if (nums[back] + nums[i] == target) {
                result[0] = i + 1;
                result[1] = back + 1;
                return result;
            }
        }
        return result;
    }
}

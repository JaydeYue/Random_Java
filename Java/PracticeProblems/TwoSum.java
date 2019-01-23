/**The problem

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.


Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);
        int result[] = new int[2];
        int back = nums.length - 1;
        int count1, count2;
        for (int i=0; i< nums.length; i++) {
            while (sorted[back] + sorted[i] > target) {
                back -= 1;
            }
            if (sorted[back] + sorted[i] == target) {
                result[0] = i;
                result[1] = back;
                count1 = count2 = 0;
                for (int x=0; x < nums.length; x++) {

                    if (nums[x] == sorted[i] && count1 != 1) {
                        result[0] = x;
                        count1 = 1;
                    }
                    if (nums[x] == sorted[back] && x != result[0]) {
                        result[1] = x;
                        count2 = 1;
                    }
                    if (count1 == 1 && count2 == 1) {
                        Arrays.sort(result);
                        return result;
                    }
                }
            }
        }
        return result;
    }
}

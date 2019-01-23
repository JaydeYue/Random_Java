/**The problem

Given a string, find the length of the longest substring without repeating characters.*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] letter = new int[128];
        int result, temp, last;
        result = temp = last = 0;
        for (int i=0; i< s.length(); i++) {
            if (letter[s.charAt(i)] > 0) {
                if (temp > result) {
                    result = temp;
                }
                if (letter[s.charAt(i)] > last) {
                    last = letter[s.charAt(i)];
                }
                temp = i - last + 1;
                clear(letter, letter[s.charAt(i)]);
                letter[s.charAt(i)] = i + 1;
            } else {
                temp += 1;
                letter[s.charAt(i)] = i + 1;
            }
        }
        if (temp > result) {
            result = temp;
        }
        return result;
    }

    public void clear(int[] letter, int index) {
        for (int i = 0; i<26; i++) {
            if (letter[i] <= index) {
                letter[i] = 0;
            }
        }
    }
}

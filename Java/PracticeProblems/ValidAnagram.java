/**The problem

Given two strings s and t , write a function to determine if t is an anagram of s.

Assume strings only contain lower case*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int letter[] = new int[26];
        int index;
        for (int i=0; i<s.length(); i++) {
            index = (int) s.charAt(i);
            letter[index % 26] += 1;
        }
        for (int j=0; j<t.length(); j++) {
            index = (int) t.charAt(j);
            letter[index % 26] -= 1;
        }
        for (int k=0; k < 26; k++) {
            if (letter[k] != 0) {
                return false;
            }
        }
        return true;
    }
}

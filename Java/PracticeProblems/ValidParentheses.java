/**The problem

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char temp;
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == ")".charAt(0)) {
                if (stack.empty()) {
                    return false;
                }
                temp = stack.pop();
                if (temp != "(".charAt(0)) {
                    return false;
                }
            } else if (s.charAt(i) == "}".charAt(0)) {
                if (stack.empty()) {
                    return false;
                }
                temp = stack.pop();
                if (temp != "{".charAt(0)) {
                    return false;
                }
            } else if (s.charAt(i) == "]".charAt(0)) {
                if (stack.empty()) {
                    return false;
                }
                temp = stack.pop();
                if (temp != "[".charAt(0)) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}

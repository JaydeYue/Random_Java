/** The problem

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Deal with the case where one input is null
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = (temp1.val + temp2.val) / 10;
        ListNode result = new ListNode((temp1.val + temp2.val) % 10);
        ListNode tempResult = result;

        // Both l1 and l2 have a next node
        while (temp1.next != null && temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            tempResult.next = new ListNode((temp1.val + temp2.val + carry) % 10);
            carry = (temp1.val + temp2.val + carry) / 10;
            tempResult = tempResult.next;
        }

        // Either l1 or l2 has a next node
        if (temp2.next == null && temp1.next != null) {
            while (temp1.next != null) {
                temp1 = temp1.next;
                tempResult.next = new ListNode((temp1.val + carry) % 10);
                carry = (temp1.val + carry) / 10;
                tempResult = tempResult.next;
            }
        } else if (temp1.next == null && temp2.next != null) {
            while (temp2.next != null) {
                temp2 = temp2.next;
                tempResult.next = new ListNode((temp2.val + carry) % 10);
                carry = (temp2.val + carry) / 10;
                tempResult = tempResult.next;
            }
        }

        // Check if we need to make a new node for the final carry
        if (carry != 0) {
            tempResult.next = new ListNode(carry);
        }

        return result;
    }
}

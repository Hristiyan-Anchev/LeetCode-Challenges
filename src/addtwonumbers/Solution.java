package addtwonumbers;


import java.util.ArrayDeque;

public class Solution {
/*
  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> firstNumberStack = extractValuesFromList(l1, new ArrayDeque<Integer>());
        ArrayDeque<Integer> secondNumberStack = extractValuesFromList(l2, new ArrayDeque<Integer>());

        ListNode sum = getSumAsNodeList(firstNumberStack, secondNumberStack,
                new ListNode(0),
                new ListNode(-1),
                0
        );


        return sum;
    }

    private ListNode getSumAsNodeList(ArrayDeque<Integer> firstNumberStack,
                                      ArrayDeque<Integer> secondNumberStack,
                                      ListNode accumulator,
                                      ListNode initialRef,
                                      int carry) {


        if (initialRef.val == -1) {
            initialRef = accumulator;
        }
        int firstNum = 0;
        if (firstNumberStack.peek() != null) {
            firstNum = firstNumberStack.removeLast();

        }

        int secondNum = 0;
        if (secondNumberStack.peek() != null) {
            secondNum = secondNumberStack.removeLast();

        }

        int sum = firstNum + secondNum + carry;

        accumulator.val = sum % 10;
        carry = (int) (sum / 10);


        if (firstNumberStack.peek() == null && secondNumberStack.peek() == null) {
            if(carry != 0){
                accumulator.next = new ListNode(carry);
            }

            return initialRef;
        }

        accumulator.next = new ListNode();
        return getSumAsNodeList(firstNumberStack, secondNumberStack,
                accumulator.next,
                initialRef,
                carry
        );
    }


    private ArrayDeque<Integer> extractValuesFromList(ListNode l, ArrayDeque<Integer> nums) {

        ListNode currentNumber = l;
        if (currentNumber != null) {
            nums.push(currentNumber.val);
            return extractValuesFromList(l.next, nums);
        }

        return nums;
    }

}

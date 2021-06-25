package twosum;

public class TwoSum {
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


    private Integer[] nums;
    private Integer target;

    public TwoSum(Integer[] nums, Integer target) {
        this.setNums(nums);
        this.setTarget(target);
    }

    public Integer[] getNums() {
        return nums;
    }

    public void setNums(Integer[] nums) {
        if (nums.length >= 2 && nums.length <= 10000) {
            this.nums = nums;
        }
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public int[] findTargetIndices() {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    Integer n1 = nums[i];
                    Integer n2 = nums[j];

                    if(n1 + n2 == this.target){
                        return new int[]{i,j};
                    }
                }
            }
        }

        return new int[]{};
    }


}

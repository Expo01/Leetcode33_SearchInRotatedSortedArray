public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}

// [4,5,6,7,0,1,2]
class Solution {
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int isStart = L + (R - L) / 2;
        boolean exit = false;

        while (!exit) {
            if (nums[isStart] < nums[isStart + 1] && nums[isStart] < nums[isStart - 1]) { // OOB problem here but when i try to fix no good
                exit = true;
            } else {
                if (target < nums[0]) {
                    L = isStart;
                } else {
                    R = isStart;
                }
                isStart = L + (R - L) / 2;
            }
        }

        int targetIndex = isStart;
        // start index now aquired. can do regular binary search

        while (L <= R) {
            if (nums[targetIndex] == target) {
                break;
            } else if (target < nums[targetIndex]) {
                R = targetIndex - 1;
            } else {
                L = targetIndex + 1;
            }
            targetIndex = L + (R - L) / 2;
        }
        if (nums[targetIndex] == target){
            return targetIndex;
        } else return -1;

    }
}
public class Main {
    public static void main(String[] args) {


    }
}


class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find the index of the pivot element (the smallest element)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) { // suppose [4,5,6,*7*,0,1,2]
                left = mid + 1;
            } else { // suppose [6,7,0,*1*,2,4,5]
                right = mid - 1;
            } // if start index in left half, L will ultimately increment past R so be one index further than mid
            // if start index in R half, then R index increment to mid-1
        }

        // Binary search over elements on the pivot element's left
        int answer = binarySearch(nums, 0, left - 1, target); // L could either be mid or mid+1.
        // so right boundary would either be mid-1 or mid. in the event that mid is exluded where say mid = 3, and R boundary = 3-1 = 2
        // then L still = L (mid) and is captured in second binary search call where L is the L boundary
        if (answer != -1) {
            return answer;
        }

        // Binary search over elements on the pivot element's right
        return binarySearch(nums, left, n - 1, target);
    }

    // Binary search over an inclusive range [left_boundary ~ right_boundary]
    private int binarySearch(int[] nums, int leftBoundary, int rightBoundary, int target) {
        int left = leftBoundary, right = rightBoundary;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

// [4,5,6,7,0,1,2]
//class Solution {
//    public int search(int[] nums, int target) {
//        int L = 0;
//        int R = nums.length - 1;
//        int isStart = L + (R - L) / 2;
//        boolean exit = false;
//
//        while (!exit) {
//            if (nums[isStart] < nums[isStart + 1] && nums[isStart] < nums[isStart - 1]) { // OOB problem here but when i try to fix no good
//                exit = true;
//            } else {
//                if (target < nums[0]) {
//                    L = isStart;
//                } else {
//                    R = isStart;
//                }
//                isStart = L + (R - L) / 2;
//            }
//        }
//
//        int targetIndex = isStart;
//        // start index now aquired. can do regular binary search
//
//        while (L <= R) {
//            if (nums[targetIndex] == target) {
//                break;
//            } else if (target < nums[targetIndex]) {
//                R = targetIndex - 1;
//            } else {
//                L = targetIndex + 1;
//            }
//            targetIndex = L + (R - L) / 2;
//        }
//        if (nums[targetIndex] == target){
//            return targetIndex;
//        } else return -1;
//
//    }
//}
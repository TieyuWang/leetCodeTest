public class Test704 {
    public static void main(String[] args) {
/*[-1,0,3,5,9,12]
        2*/
    }

    class Solution {
        public int search(int[] nums, int target) {
            int low = 0;
            int mid = (nums.length - 1) / 2;
            int high = nums.length - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[low] == target){
                    return low;
                } else if (nums[high] == target){
                    return high;
                } else if (nums[mid] > target) {
                    high = mid -1;
                } else if (nums[mid] < target) {
                    low = mid +1;
                }
            }
            return -1;
        }
    }
/*
    public static int search(int[] nums, int target) {
        return find(nums, 0, (nums.length - 1)/ 2, nums.length - 1, target);
    }

    public static int find(int[] nums, int front, int index, int rear, int target) {
        System.out.println("f=" + front + " i=" + index + " r=" + rear + " tar=" + target + " real=" + nums[index]);
        if (front == rear) {
            return -1;
        }
        if (nums[index] > target) {
            return find(nums, front,index / 2, index - 1, target);
        } else if (nums[index] < target) {
            return find(nums, index + 1,(rear - index) / 2 + index, rear, target);
        } else {
            return index;
        }
    }*/
}

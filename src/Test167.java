import java.util.Arrays;

public class Test167 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[2,7,11,15]
        //9
        System.out.println("Arrays.toString() = " + Arrays.toString(solution.twoSum(new int[]{-1, 0}, -1)));
    }
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //1. 二分找到第一个比大于等于target的数
            int mid = findMid(numbers, target / 2);
            System.out.println("mid = " + mid);
            //2. 双指针头尾相加循环检查两数只和
            int rightLow = mid;
            int rightHigh = numbers.length - 1;
            for (int i=mid; i >= 0 ;i--) {
                for (int j=rightLow ;j <= rightHigh; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (numbers[i] + numbers[j] < target) {
                        rightLow = i;
                    }
                    if (numbers[i] + numbers[j] == target) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
            return new int[2];
        }

        private int findMid(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while(left <= right) {
                int mid = left + (right - left) /2;
                System.out.println("left=" + left + " right=" + right + "mid = " + mid);
                if (numbers[mid] == target) {
                    return mid;
                } else if (numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left > 0 ? left -1 : left;
        }
    }
}

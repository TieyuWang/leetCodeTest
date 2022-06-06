import java.util.Arrays;

public class Test977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-2,0})));
    }

    public static int[] sortedSquares(int[] nums) {
        int [] res = new int[nums.length];
        int index1= 0;
        int index2 = nums.length -1;
        for (int resIndex = nums.length -1; resIndex >=0; resIndex --) {
            //index1 如果移动到大于等于0的地方必定小于 index2
            if(-nums[index1] > nums[index2]) {
                res[resIndex] = nums[index1] * nums[index1];
                index1 ++;
            } else {
                res[resIndex] = nums[index2] * nums[index2];
                index2 --;
            }
        }
        return res;
    }
   /* public static int[] sortedSquares(int[] nums) {
        int [] res = new int[nums.length];
        if (nums[nums.length -1] < 0) {
            int resIndex = 0;
            for (int i = nums.length -1; i >= 0; i--) {
                res[resIndex] = nums[i] * nums[i];
                resIndex ++;
            }
        } else if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i] * nums[i];
            }
        } else {
            //1. 找到整数开始的位置， 二分
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left < right) {
                mid = (right - left) / 2 + left;
                if (nums[mid] >= 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            //2. 双指针插入
            int index1 = right - 1;
            int index2 = right;
            int indexRes = 0;

            while (indexRes < nums.length) {
        *//*        if (index1 >= 0 && index2 < nums.length) {
                    System.out.println("i1=" + index1 + " i2=" + index2 + " v1=" + nums[index1]
                            + " v2=" + nums[index2] + " resi=" + indexRes);
                }*//*
                if (index1 >= 0 && (index2 == nums.length || -nums[index1] <= nums[index2])) {
                    res[indexRes] = nums[index1] * nums[index1];
                    index1--;
                } else {
                    res[indexRes] = nums[index2] * nums[index2];
                    index2++;
                }
                indexRes++;
            }
        }
        return res;
    }*/
}

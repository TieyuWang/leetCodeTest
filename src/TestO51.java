import java.util.Arrays;

public class TestO51 {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        //[-4,0,7,4,9,-5,-1,0,-7,-1]
        System.out.println(Arrays.toString(mergeSort.sortArray(new int[]{1,2,3,4,5,6,7,8,9})));
    }

    static class MergeSort {
        public int[] sortArray(int[] nums) {
            int[] temp = new int[nums.length];
            mergeSort(nums, temp, 0, nums.length -1);
            return nums;
        }

        private void mergeSort(int[] nums, int[] temp, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                mergeSort(nums, temp, left, mid);
                mergeSort(nums, temp, mid + 1, right);
                // System.out.println("ms " + Arrays.toString(nums));
                //到这两个数组开始合并 int[] {left, mid}  int[]{mid+1, right}
                if (nums[mid] <= nums[mid + 1]) {
                    System.out.println("cut ");
                    return;
                }
                merge2(nums, temp, left, mid, right);
                // System.out.println("me " + Arrays.toString(nums));
            }
        }

        private void merge(int[] nums, int [] temp, int left, int mid, int right) {
            //    System.out.println("left=" + left + " mid=" + mid + " right=" + right);
            int array1Head = left;
            int array2Head = mid + 1;

            for (int i=left; i <= right; i++) {
                temp[i] = nums[i];
            }

            for (int i=left; i <= right; i++) {
                if (array2Head > right || (array1Head <= mid && temp[array1Head] <= temp[array2Head])) {
                    nums[i] = temp[array1Head];
                    array1Head++;
                } else if (array1Head > mid ||  (array2Head <= right && temp[array2Head] < temp[array1Head])){
                    nums[i] = temp[array2Head];
                    array2Head++;
                }
            }
        }
        private void merge2(int[] nums, int [] temp, int left, int mid, int right) {
            //    System.out.println("left=" + left + " mid=" + mid + " right=" + right);
            int array1Head = left;
            int array2Head = mid + 1;
            int tempIndex = left;
            while (array1Head <= mid && array2Head <= right){
               if (nums[array1Head] < nums[array2Head]) {
                   temp[tempIndex] = nums[array1Head];
                   array1Head++;
               }else {
                   temp[tempIndex] = nums[array2Head];
                   array2Head++;
               }
               tempIndex++;
            }
            while (array1Head < mid) {
                temp[tempIndex] = nums[array1Head];
                array1Head++;
                tempIndex++;
            }
            while (array2Head < right) {
                temp[tempIndex] = nums[array2Head];
                array2Head++;
                tempIndex++;
            }

            for (int i=left; i <= right; i++) {
                nums[i] = temp[i];
            }
        }
    }






    class Solution {
        int[] nums, tmp;
        public int reversePairs(int[] nums) {
            this.nums = nums;
            tmp = new int[nums.length];
            return mergeSort(0, nums.length - 1);
        }

       // [7,5,6,4]
        private int mergeSort(int l, int r) {
            // 终止条件
            if (l >= r) return 0;
            // 递归划分
            int m = (l + r) / 2;
            int res = mergeSort(l, m) + mergeSort(m + 1, r);
            // 合并阶段
            int i = l, j = m + 1;
            for (int k = l; k <= r; k++) {
                tmp[k] = nums[k];
            }
            for (int k = l; k <= r; k++) {
                if (i == m + 1) {
                    nums[k] = tmp[j++];
                } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                    nums[k] = tmp[i++];
                } else {
                    nums[k] = tmp[j++];
                    res += m - i + 1; // 统计逆序对
                }
            }
            return res;
        }
    }
}

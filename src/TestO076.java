import java.util.Arrays;

public class TestO076 {
    public static void main(String[] args) {
        //[5,2,3,1]

       /* QuickSort quickSort = new QuickSort();
        quickSort.sort(new int[]{5,2,3,1});*/
        FindK findK = new FindK();
        findK.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    static class FindK{

        public int findKthLargest(int[] nums, int k) {
            quickSort(nums, 0, nums.length - 1, k -1);
            System.out.println(Arrays.toString(nums));
            return nums[k -1];
        }
        private boolean quickSort(int[] nums, int left, int right, int target) {
            if (left < right) {
                int point = swapPoint(nums, left, right);
                System.out.println("point=" + point);
                if (point == target) {
                    return true;
                } else if (point < target) {
                    return quickSort(nums, point + 1, right, target);
                } else {
                    return quickSort(nums, left, point - 1, target);
                }
            }
            return false;
        }
        private int swapPoint(int[] nums, int left, int right) {
            System.out.println("left=" + left + " right=" + right);
            System.out.println(Arrays.toString(nums));
            int point = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= point) {
                    right--;
                }
                if (left < right && nums[right] < point) {
                    System.out.println(" swap left=" + left + " right=" + right);
                    nums[left] = nums[right];
                }
                while (left < right && nums[left] <= point) {
                    left++;
                }
                if (left < right && nums[left] > point) {
                    System.out.println(" swap right=" + right + " left=" + left);
                    nums[right] = nums[left];
                }
            }
            nums[left] = point;
            System.out.println(Arrays.toString(nums));
            return left;
        }
    }



    static class QuickSort {
        public int[] sort(int[] nums) {
            int len = nums.length;
            if (len <= 1) {
                return nums;
            }

            swapPoint( nums,0, len - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int index = swapPoint(nums, left, right);
                quickSort(nums, left, index - 1);
                quickSort(nums, index + 1, right);
            }
        }

        private int swapPoint(int[] nums, int left, int right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid] && nums[mid] < nums[right]){
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
            }
            if (nums[left] < nums[right] && nums[right] < nums[mid]){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            int point = nums[left];
            while (left < right) {
                while (left <right && nums[right] >= point) {
                    right--;
                }
                if (nums[right] < point) {
                    nums[left] = nums[right];
                }
                while (left < right && nums[left] <= point) {
                    left++;
                }
                if (nums[left] > point) {
                    nums[right] = nums[left];
                }
            }
            nums[left] = point;
            return left;
        }
    }
}

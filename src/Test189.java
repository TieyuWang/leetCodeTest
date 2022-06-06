import java.util.Arrays;

public class Test189 {
    public static void main(String[] args) {
      //  [-1,-100,3,99]
      //  2

        String floatStr = "3.1415926";
        System.out.println("floatStr = " + Float.parseFloat(floatStr.substring(0,4)));
      //  rotate(new int[]{-1,-100,3,99},2);
    }

    private static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int tempIndex = 0;
        for (int i= nums.length - k; i < nums.length; i++) {
            temp[tempIndex++] = nums[i];
        }
        int numsIndex = 0;
        while (tempIndex < nums.length) {
            temp[tempIndex++] = nums[numsIndex++];
        }
        for (int i=0;i< nums.length;i++){
            nums[i] = temp[i];
        }
        System.out.println("nums = " + Arrays.toString(nums) + ", k = " + k);
    }

    /*public static void rotate(int[] nums, int k) {
        //最小公倍数过不了 [1,2,3,4,5,6]
        //4
        if (nums.length <= 1 || (k/nums.length > 0 && k % nums.length == 0)) {
            return;
        }
        if (k/nums.length > 0) {
            k = k % nums.length;
        }
        for(int start=0; start< k; start++){
            int index = start + k;
            int temp = nums[start];
            while(index != start) {
                int newTemp = nums[index];
                nums[index] = temp;
                temp = newTemp;
                index +=k;
                if (index > nums.length - 1) {
                    index -= nums.length;
                }
            }
            nums[start] = temp;
            if (nums.length % k != 0) {
                break;
            }
        }
    }*/
}

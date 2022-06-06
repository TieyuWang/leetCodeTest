public class Test278 {
    static int badRes = 1702766719;
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        int low = 1;
        int mid = n/2;
        int high = n;
        int lastBad = n;
        int lastGood = 0;
        while(low < high) {
            mid =  (high - low)/2 + low;
            System.out.println(mid + " low=" + low + " high=" + high);
            if(isBadVersion(mid)) {
                high = mid - 1;
                lastBad = mid;
            } else {
                low = mid + 1;
                lastGood = mid;
            }
        }

        return high;
    }

    private static boolean isBadVersion(int mid) {
        return badRes <= mid;
    }
}

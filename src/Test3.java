public class Test3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("aab");
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] hashArray = new int[256];
        int head = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        int tRes = 0;
        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
             System.out.println(" i=" + i + " hash=" + hashArray[c]);
            if (hashArray[c] == 0) {
                hashArray[c] = i + 1;
                if(++tRes > res) {
                    System.out.println("res=" + res + " tRes=" + tRes);
                    res = tRes;
                }
            } else {
                //有重复的 记录长度
                tRes = tRes - (hashArray[c] - head) + 1;
                System.out.println("tRes=" + tRes + " hashArray[c]=" + hashArray[c] + " head=" + head);
                int len = i - head;
                  System.out.println("len=" + len + " i=" + i + " head=" + head);
                if (len > res) {
                    res = len;
                }
                //清空hash表
                int tempHead = hashArray[c];
                for (int j=head; j < hashArray[c]; j++) {
                      System.out.println( " j=" + j);
                    hashArray[s.charAt(j)] = 0;
                }
                head = tempHead;
                 System.out.println( " head=" + head + " i=" +i);
                hashArray[c] = i + 1;
            }
        }
        return res;
    }
}

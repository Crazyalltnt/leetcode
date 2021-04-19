package slidingwindow;

import java.util.Arrays;

/**
 * No.567 字符串的排列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/19 10:02
 */
public class L0567PermutationInString {
    public static void main(String[] args) {
        // String s1 = "ab";
        // String s2 = "eidbaooo";
        String s1 = "ab";
        String s2 = "eidboaoo";

        System.out.println(checkInclusion(s1, s2));
    }

    /**
     * 字符串的排列 滑动窗口
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 是否包含排列
     */
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串的排列 滑动窗口 优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 是否包含排列
     */
    public static boolean checkInclusion2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }

        int[] cnt = new int[26];

        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']--;
            cnt[s2.charAt(i) - 'a']++;
        }

        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                diff++;
            }
        }

        if (diff == 0) {
            return true;
        }

        for (int i = n; i < m; i++) {
            int x = s2.charAt(i) - 'a';
            int y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                diff++;
            }
            cnt[x]++;
            if (cnt[x] == 0) {
                diff--;
            }
            if (cnt[y] == 0) {
                diff++;
            }
            cnt[y]--;
            if (cnt[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}

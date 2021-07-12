package string;

/**
 * No.14 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/4 10:44
 */
public class L0014LongestCommonPrefix {
    public static void main(String[] args) {
        // String[] strs = {"flower","flow","flight"};
        // String[] strs = {"dog","racecar","car"};
        // String[] strs = {""};
        String[] strs = {"hello"};
        // String[] strs = {"", "b"};
        // String[] strs = {"bb", "b", ""};
        // String[] strs = {"a", "ac"};
        System.out.println(longestCommonPrefix5(strs));
    }

    /**
     * 获取最长前缀 循环按位添加字符 横向扫描
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     *
     * @param strs 字符串数组
     * @return 最长前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        if ("".equals(strs[0])) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        boolean end = false;
        int index = 0;
        while (!end) {
            int i = 1;
            while (i < strs.length) {
                if ("".equals(strs[i]) || index == strs[0].length() || index == strs[i].length()
                    || strs[i].charAt(index) != strs[0].charAt(index)) {
                    end = true;
                    break;
                }
                i++;
            }

            if (i == strs.length) {
                sb.append(strs[0].charAt(index));
                index++;
            }
        }

        return sb.toString();
    }

    /**
     * 获取最长前缀 两两比较更新前缀 横向扫描
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     *
     * @param strs 字符串数组
     * @return 最长前缀
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * 获取两个字符串的公共前缀
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 公共前缀
     */
    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 获取最长前缀 循环按位截取子串 纵向扫描
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     *
     * @param strs 字符串数组
     * @return 最长前缀
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 获取最长前缀 分治算法
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MlogN)
     *
     * @param strs 字符串数组
     * @return 最长前缀
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    /**
     * 获取公共前缀
     *
     * @param strs  字符串
     * @param start 起始索引
     * @param end   终止索引
     * @return 公共前缀
     */
    public static String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end + start) / 2;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    /**
     * 获取公共前缀
     *
     * @param lcpLeft  左前缀
     * @param lcpRight 右前缀
     * @return 公共前缀
     */
    public static String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    /**
     * 获取最长前缀 二分查找
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MlogN)
     *
     * @param strs 字符串数组
     * @return 最长前缀
     */
    public static String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 0;
        int high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    /**
     * 是否公共前缀
     *
     * @param strs   字符串
     * @param length 长度
     * @return 是否公共前缀
     */
    private static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

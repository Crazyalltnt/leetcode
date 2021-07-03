package string;

import javafx.util.Pair;

/**
 * No.165 比较版本号
 * https://leetcode-cn.com/problems/compare-version-numbers
 * <p>
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。
 * 修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。
 * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * <p>
 * 示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * <p>
 * 示例 2：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * <p>
 * 示例 3：
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 * <p>
 * 示例 4：
 * 输入：version1 = "1.0.1", version2 = "1"
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是 有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/3 13:51
 */
public class L0165CompareVersionNumbers {
    public static void main(String[] args) {
        // String version1 = "1.01", version2 = "1.001";
        // String version1 = "0.1", version2 = "1.1";
        String version1 = "1.0.1", version2 = "1";
        System.out.println(compareVersion(version1, version2));
        ;
    }

    /**
     * 比较版本号 拆分数组
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 比较值
     */
    public static int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        int len1 = version1Array.length;
        int len2 = version2Array.length;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int revision1 = i < len1 ? Integer.parseInt(version1Array[i]) : 0;
            int revision2 = i < len2 ? Integer.parseInt(version2Array[i]) : 0;
            if (revision1 > revision2) {
                return 1;
            } else if (revision1 < revision2) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 比较版本号 双指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 比较值
     */
    public static int compareVersion2(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int len1 = version1.length(), len2 = version2.length();

        int i1, i2;
        Pair<Integer, Integer> pair;
        while (p1 < len1 || p2 < len2) {
            pair = getNextChunk(version1, len1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNextChunk(version2, len2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        if (p > n - 1) {
            return new Pair<>(0, p);
        }

        int i;
        int end = p;
        while (end < n && version.charAt(end) != '.') {
            end++;
        }
        i = Integer.parseInt(version.substring(p, end));
        p = end + 1;
        return new Pair<>(i, p);
    }

    /**
     * 比较版本号 双指针简化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 比较值
     */
    public static int compareVersion3(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int index1 = 0, index2 = 0;
        while (index1 < len1 || index2 < len2) {
            if (index1 < len1 && version1.charAt(index1) == '.') {
                index1++;
            }
            if (index2 < len2 && version2.charAt(index2) == '.') {
                index2++;
            }
            int curr1 = 0;
            int curr2 = 0;
            while (index1 < len1 && version1.charAt(index1) != '.') {
                curr1 = curr1 * 10 + version1.charAt(index1++) - '0';
            }
            while (index2 < len2 && version2.charAt(index2) != '.') {
                curr2 = curr2 * 10 + version2.charAt(index2++) - '0';
            }
            if (curr1 != curr2) {
                return curr1 < curr2 ? -1 : 1;
            }
        }
        return 0;
    }
}

package string;

import java.util.Arrays;

/**
 * No.0006 Z字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/24 13:58
 */
public class L0006ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    /**
     * Z字形变换 按行排序
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s       字符串
     * @param numRows 行数
     * @return 新字符串
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        String[] array = new String[numRows];
        Arrays.fill(array, "");
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            array[i] += c;
            if (i == 0 || i == numRows - 1) {
                flag = -flag;

            }
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (String ss : array) {
            res.append(ss);
        }
        return res.toString();
    }

    /**
     * Z字形变换 按行访问
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s       字符串
     * @param numRows 行数
     * @return 新字符串
     */
    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int n = s.length();
        int cycleLength = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLength) {
                res.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLength - i < n) {
                    res.append(s.charAt(j + cycleLength - i));
                }
            }
        }
        return res.toString();
    }
}

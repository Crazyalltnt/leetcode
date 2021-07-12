package string;

import java.util.HashMap;
import java.util.Map;

/**
 * No.8 字符串转换整数
 * https://leetcode-cn.com/problems/string-to-integer-atoi
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 示例 1：
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 *
 * 示例 2：
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 *
 * 示例 3：
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 *              ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 *
 * 示例 4：
 * 输入：s = "words and 987"
 * 输出：0
 * 解释：
 * 第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
 *          ^
 * 解析得到整数 0 ，因为没有读入任何数字。
 * 由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
 *
 * 示例 5：
 * 输入：s = "-91283472332"
 * 输出：-2147483648
 * 解释：
 * 第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
 *           ^
 * 第 3 步："-91283472332"（读入 "91283472332"）
 *                      ^
 * 解析得到整数 -91283472332 。
 * 由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
 *
 * 提示：
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/2 20:51
 */
public class L0008StringToInteger {
    public static void main(String[] args) {
        // String s = "42";
        // String s = "   -42";
        // String s = "4193 with words";
        // String s = "words and 987";
        // String s = "-91283472332";
        // String s = "+-12";
        // String s = "+-";
        // String s = "00000-42a1234";
        // String s = "  0000000000012345678";
        String s = "20000000000000000000";
        System.out.println(myAtoi3(s));
    }

    /**
     * 字符串转整数 截取子串法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 整数
     */
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        if (left == s.length() || !(s.charAt(left) == '+' || s.charAt(left) == '-' || Character.isDigit(s.charAt(left)))) {
            return 0;
        }

        if (s.charAt(left) == '+' || s.charAt(left) == '-') {
            if (left == s.length() - 1 || !Character.isDigit(s.charAt(left + 1))) {
                return 0;
            }
        }

        int right = left + 1;
        while (right < s.length() && Character.isDigit(s.charAt(right))) {
            right++;
        }


        long first;
        String subString;
        if (s.charAt(left) == '+') {
            first = 1;
            subString = s.substring(left + 1, right);
        } else if (s.charAt(left) == '-') {
            first = -1;
            subString = s.substring(left + 1, right);
        } else {
            first = 1;
            subString = s.substring(left, right);
        }

        long num = 0;
        for (int i = 0; i < subString.length(); i++) {
            num = (subString.charAt(i) - '0') + num * 10;
            if (num * first > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (num * first < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)(num * first);
    }

    /**
     * 字符串转整数 按位累加法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 整数
     */
    public static int myAtoi2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
                start++;
        }

        if (start == s.length() || !(Character.isDigit(s.charAt(start)) || s.charAt(start) == '+' || s.charAt(start) == '-')) {
            return 0;
        }

        long num = 0;
        long first;
        if (s.charAt(start) == '-') {
            first = -1;
            start++;
        } else if (s.charAt(start) == '+'){
            first = 1;
            start++;
        } else {
            first = 1;
        }

        for (int i = start; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            } else {
                break;
            }

            if (num * first > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (num * first < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)(num * first);
    }

    /**
     * 字符串转整数 自动机法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 整数
     */
    public static int myAtoi3(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

/**
 * 自动机类
 */
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

package string;

import java.util.*;

/**
 * No.22 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/10 10:27
 */
public class L0022GenerateParentheses {
    public static void main(String[] args) {

    }

    /**
     * 括号生成 回溯法
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param n 数字
     * @return 有效括号组合
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            list.add(sb.toString());
            return;
        }
        if (open < max) {
            sb.append("(");
            backtrack(list, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(list, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 括号生成 插入法
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param n 数字
     * @return 有效括号组合
     */
    public static List<String> generateParenthesis2(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis2(n - 1)) {
            for (int i = 0; i <= str.length() / 2; i++) {
                set.add(str.substring(0, i) + "()" + str.substring(i, str.length()));
            }

        }
        return new ArrayList<>(set);
    }
}

package string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.0032 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 *
 * 提示：
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/7 19:50
 */
public class L0032LongestValidParentheses {
    public static void main(String[] args) {

    }

    /**
     * 最长有效括号 暴力 超时
     * 时间复杂度 O(N^3)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }

        for (int i = n % 2 == 0 ? n : n - 1; i > 0; i -= 2) {
            sub : for (int j = 0; j < n - i + 1; j++) {
                String sub = s.substring(j, j + i);
                Deque<Character> stack = new LinkedList<>();
                for (int k = 0; k < i; k++) {
                    if (sub.charAt(k) == '(') {
                        stack.push('(');
                    } else if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        continue sub;
                    }
                }
                if (stack.isEmpty()) {
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * 最长有效括号 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses2(String s) {
        int maxAns = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i -1] > 0 && s.charAt(i - dp[i -1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxAns = Math.max(maxAns, dp[i]);
            }
        }
        return maxAns;
    }

    /**
     * 最长有效括号 栈
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses3(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }

    /**
     * 最长有效括号 无需额外空间 双指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses4(String s) {
        int left = 0, right = 0;
        int maxAns = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxAns = Math.max(maxAns, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >=0 ; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxAns = Math.max(maxAns, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxAns;
    }
}

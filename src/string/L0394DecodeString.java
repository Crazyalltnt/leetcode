package string;

import java.util.*;

/**
 * No.394 字符串解码
 * https://leetcode-cn.com/problems/decode-string
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/11 16:11
 */
public class L0394DecodeString {
    public static void main(String[] args) {

    }

    int ptr;

    /**
     * 字符串解码 栈
     * 时间复杂度 O(len)
     * 空间复杂度 O(len)
     *
     * @param s 字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        pointer = 0;

        while (pointer < s.length()) {
            char cur = s.charAt(pointer);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stack.addLast(String.valueOf(s.charAt(pointer++)));
            } else {
                pointer++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.pollLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stack.pollLast();
                // 此时栈顶为当前sub对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stack.pollLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构建好的字符串入栈
                stack.addLast(t.toString());
            }
        }
        return getString(stack);
    }

    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(pointer))) {
            ret.append(s.charAt(pointer++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> list) {
        StringBuilder ret = new StringBuilder();
        for (String s : list) {
            ret.append(s);
        }
        return ret.toString();
    }

    /**
     * 字符串解码 栈 优化
     * 时间复杂度 O(len)
     * 空间复杂度 O(len)
     *
     * @param s 字符串
     * @return 解码后的字符串
     */
    public String decodeString2(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                // 把所有的字母push进去，除了]
                stack.push(c);
            } else {
                //step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                //[ ]内的字符串
                String sub = sb.toString();
                stack.pop(); // 去除[

                //step 2: 获取倍数数字
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                //倍数
                int count = Integer.parseInt(sb.toString());

                //step 3: 根据倍数把字母再push回去
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        //把栈里面所有的字母取出来，完事
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    String src;
    int pointer;
    /**
     * 字符串解码 递归
     * 时间复杂度 O(len)
     * 空间复杂度 O(len)
     *
     * @param s 字符串
     * @return 解码后的字符串
     */
    public String decodeString3(String s) {
        src = s;
        pointer = 0;
        return getString();
    }

    public String getString() {
        if (pointer == src.length() || src.charAt(pointer) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(pointer);
        int repTime = 1;
        StringBuilder ret = new StringBuilder();

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++pointer;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++pointer;
            // 构造字符串
            while (repTime-- > 0) {
                ret.append(str);
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = new StringBuilder(String.valueOf(src.charAt(pointer++)));
        }

        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (pointer < src.length() && Character.isDigit(src.charAt(pointer))) {
            ret = ret * 10 + src.charAt(pointer++) - '0';
        }
        return ret;
    }
}

package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.17 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/9 8:52
 */
public class L0017LetterCombinationsOfaPhoneNumber {
    public static void main(String[] args) {

    }

    /**
     * 电话号码的字母组合 回溯
     * 时间复杂度 O(3^m * 4^N)
     * 空间复杂度 O(M+N)
     *
     * @param digits 数字字符串
     * @return 字母组合
     */
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>(8) {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    /**
     * 数字到号码的映射
     */
    private final String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    /**
     * 路径
     */
    private StringBuilder sb = new StringBuilder();
    /**
     * 结果集
     */
    private List<String> res = new ArrayList<>();

    /**
     * 电话号码的字母组合 回溯 优化
     * 时间复杂度 O(3^m * 4^N)
     * 空间复杂度 O(M+N)
     *
     * @param digits 数字字符串
     * @return 字母组合
     */
    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        back(digits, 0);
        return res;
    }

    public void back(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
        }

        String val = map[digits.charAt(index) - '2'];
        for (char ch : val.toCharArray()) {
            sb.append(ch);
            back(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

import java.util.*;

/**
 * No.22 括号生成
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/21 10:20
 */
public class L0022GenerateParentheses {
    public static void main(String[] args) {

    }

    List<String> list = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    /**
     * 括号生成
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param n 括号对数
     * @return 有效括号组合
     */
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return list;
    }

    public void backtrack(int left, int right, int n) {
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            backtrack(left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(')');
            backtrack(left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 括号生成 插入法
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param n 括号对数
     * @return 有效括号组合
     */
    public static List<String> generateParenthesis2(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis2(n - 1)) {
            for (int i = 0; i <= str.length() / 2; i++) {
                set.add(str.substring(0, i) + "()" + str.substring(i));
            }

        }
        return new ArrayList<>(set);
    }
}

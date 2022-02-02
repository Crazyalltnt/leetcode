import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/2 16:15
 */
public class JZ50FirstNotRepeatingChar {
    public static void main(String[] args) {

    }

    /**
     * 第一个只出现一次的字符
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param str 字符串
     * @return 字符
     */
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            map.put(c, !map.containsKey(c));
        }
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
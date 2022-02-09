import java.util.LinkedHashMap;

/**
 * JZ75 字符流中第一个不重复的字符
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/9 17:17
 */
public class JZ75FirstUniqChar {
    public static void main(String[] args) {

    }

    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, -1);
        } else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char cur : map.keySet()) {
            if (map.get(cur) == 1) {
                return cur;
            }
        }
        return '#';
    }
}

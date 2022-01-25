/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/25 20:28
 */
public class JZ56SingleNumbers {
    public static void main(String[] args) {

    }

    public int[] FindNumsAppearOnce (int[] array) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : array) {
            n ^= num;
        }
        while ((n & m) == 0) {
            m <<= 1;
        }
        for (int num : array) {
            if ((num & m) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        if (x < y) {
            return new int[]{x, y};
        }
        return new int[]{y, x};
    }
}

/**
 * No.470 用 Rand7() 实现 Rand10()
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/2 18:53
 */
public class L0470ImplementRand10UsingRand7 {
    public static void main(String[] args) {

    }

    public int rand7() {
        return (int)(Math.random() * 7) + 1;
    }

    /**
     * 用 Rand7() 实现 Rand10()
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @return 1-10的均匀随机数
     */
    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) {
                return num % 10 + 1;
            }
            // 41-49 0-8 * 7 + 1-7 = 1-63
            num = (num - 41) * 7 + rand7();
            if (num <= 60) {
                return num % 10 + 1;
            }
            // 61 - 63 0-2 * 7 + 1-7 = 1-21
            num = (num - 61) * 7 + rand7();
            if (num <= 20) {
                return num % 10 + 1;
            }
        }
    }
}

/**
 * 跳台阶扩展问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
 *
 * 数据范围：1 ≤ n ≤ 20
 * 进阶：空间复杂度 O(1) ， 时间复杂度 O(1)
 *
 * @author Neil
 * @version v1.0
 * @date 2021/12/31 18:35
 */
public class JZ71JumpFloor2 {
    public static void main(String[] args) {

    }

    /**
     * 跳台阶扩展问题
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param target 台阶数
     * @return 跳法
     */
    public int jumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII(target - 1);
        }
    }

    /**
     * 跳台阶扩展问题
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param target 台阶数
     * @return 跳法
     */
    public int jumpFloorII2(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target - 1);
    }
}

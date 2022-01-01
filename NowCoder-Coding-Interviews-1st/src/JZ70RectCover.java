/**
 * JZ70 矩形覆盖
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/1 16:19
 */
public class JZ70RectCover {
    public static void main(String[] args) {

    }

    /**
     * JZ70 矩形覆盖
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param target 目标值
     * @return 方法数
     */
    public int rectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }
}

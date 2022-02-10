/**
 * 剑指 Offer 14- II. 剪绳子 II
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/10 18:11
 */
public class JZ14CutRope2 {
    public static void main(String[] args) {

    }

    /**
     * 剪绳子 数学 快速幂求余
     * 快速幂参考
     * https://blog.csdn.net/qq_40913465/article/details/109388526
     * https://zhuanlan.zhihu.com/p/307759581
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param number 数字
     * @return 乘积
     */
    public long cutRope(long number) {
        if(number <= 3) {
            return number - 1;
        }
        long b = number % 3, p = 998244353;
        long rem = 1, x = 3;
        for(long a = number / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if(b == 0) {
            return (int)(rem * 3 % p);
        }
        if(b == 1) {
            return (int)(rem * 4 % p);
        }
        return (int)(rem * 6 % p);
    }

    /**
     * 剪绳子 贪心 循环求余
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param number 数字
     * @return 乘积
     */
    public long cutRope2(long number) {
        if(number <= 3) {
            return number - 1;
        }
        long res = 1L;
        int p = 998244353;
        //贪心算法，优先切三，其次切二
        while(number > 4){
            res = res * 3 % p;
            number -= 3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return res * number % p;
    }

    /**
     * 剪绳子 贪心 循环求余
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param number 数字
     * @return 乘积
     */
    public long cutRope3(long number) {
        if(number <= 3) {
            return number - 1;
        }
        long b = number % 3, p = 1000000007;
        long ret = 1;
        //线段被我们分成以3为大小的小线段个数
        long lineNums = number / 3;
        //从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
        for(int i = 1; i < lineNums; i++){
            ret = 3 * ret % p;
        }
        if(b == 0) {
            //刚好被3整数的，要算上前一段
            return (int)(ret * 3 % p);
        }
        if(b == 1) {
            //被3整数余1的，要算上前一段
            return (int)(ret * 4 % p);
        }

        //被3整数余2的，要算上前一段
        return (int)(ret * 6 % p);
    }
}

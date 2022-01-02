/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/2 15:35
 */
public class JZ36MaxProfit {
    public static void main(String[] args) {

    }

    /**
     * 股票的最大利润
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}

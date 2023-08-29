
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的。(如果有数量限制)
import java.util.Arrays;


public class code322 {
    public int coinChange(int[] coins, int amount){
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i<= amount;i++){
            for (int coin : coins) {
                if (i >= coin && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1:dp[amount];
    }

    //如果有硬币数量的限制
    public static int coinNum(int[] coins, int[] num, int amount){
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i<= amount;i++){
            int[] num_copy = deepCopy(num);
            for (int j=0;j<coins.length;j++) {
                if (i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE && num_copy[j]>0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    num_copy[j]--;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1:dp[amount];
    }

    public static int[] deepCopy(int[] input){
        int[] out = new int[input.length];
        for(int i = 0;i<input.length;i++){
            out[i] = input[i];
        }
        return out;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int[] num = new int[]{3,2,1};
        int amount = 11;
//        code322 c = new code322();
//        int out = c.coinChange(coins,amount);
        int out = coinNum(coins, num, amount);
        System.out.println(out);
    }
}

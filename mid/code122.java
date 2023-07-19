import java.util.ArrayList;
import java.util.List;

//给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
//
//        在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//
//        返回 你能获得的 最大 利润 。
public class code122 {
    public static int maxProfit(int[] prices) {
        List<Integer> profit_list = new ArrayList<>();
        int min_local= Integer.MAX_VALUE;
        int profit_max = -1;
        if(prices.length==1){return 0;}
        for(int i=0;i<prices.length;i++){
            if(i==0&&prices[0] < prices[1]){
                min_local = prices[i];
                continue;
            }
            if(i==0){continue;}
            if(i==(prices.length-1)){
                int profit = prices[i] - min_local;
                if(profit>profit_max){
                    profit_max = profit;
                }
                profit_list.add(profit_max);
                continue;
            }
            if(Isminlocal(prices, i)){
                if(profit_max!=-1){
                    profit_list.add(profit_max);
                    profit_max = -1;
                }
                min_local = prices[i];
            }
            else{
                if(min_local!=-1){
                    int profit = prices[i] - min_local;
                    if(profit>profit_max){
                        profit_max = profit;
                    }
                }
            }

        }
        int out = 0;
        for(int profit : profit_list){
            out += profit;
        }
        if(out>0){return out;}
        return 0;
    }
    public static boolean Isminlocal(int[] prices, int i){
        if(prices[i]<=prices[i+1]&&prices[i]<=prices[i-1]){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] prices = new int[]{1};
        int out = maxProfit(prices);
        System.out.println(out);
    }
}

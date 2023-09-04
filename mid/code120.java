//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//每一步只能移动到下一行中相邻的结点上。
//相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

import java.util.*;

//多维动态规划
public class code120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3,6),
                Arrays.asList(7, 8, 9),
                Arrays.asList(7, 8, 9, 10)));
        int out = minimumTotal(triangle);
        System.out.println(out);

    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        //自底向上递推
        //dp[i][j] 表示从点 (i,j)(i, j)(i,j) 到底边的最小路径和。
        //dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

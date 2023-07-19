//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
//        每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//        0 <= j <= nums[i]
//        i + j < n
//返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。


public class code45 {
    public static int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int count= 0;
        int end = nums.length - 1;
        while (end!=0){
            end = find(nums, end);
            count++;
        }
        return count;
    }

    public static int find(int[] nums, int end){
        for(int i=0;i<end;i++){
            int dis =  i + nums[i];
            if(dis>= end){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[] prices = new int[]{1,1,1,1};
        int out = jump(prices);
        System.out.println(out);
    }
}

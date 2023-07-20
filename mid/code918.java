//
//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
//
//环形数组 意味着数组的末端将会与开头相连呈环状。形式上，
//nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
//
//子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
//形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，
//不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。

public class code918 {
    public static int maxSubarraySumCircular(int[] nums){
        int start = 0;
        int res;
        int max = 0;
        int count = 0;
        while (count<nums.length){
            res = nums[start];
            if(res<=0){
                start = (start + 1) % nums.length;
                continue;
            }
            if(res > max){
                max = res;
            }
            int end = (start + 1) % nums.length;
            while(end != start){
                res += nums[end];
                if(res<=0){
                    start = (end + 1) % nums.length;
                    break;
                }
                if(res > max){
                    max = res;
                }
                if(end + 1 >= nums.length){
                    count = nums.length;
                }
                end = (end + 1) % nums.length;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,-3,5};
        int out = maxSubarraySumCircular(nums);
        System.out.println(out);
    }
}

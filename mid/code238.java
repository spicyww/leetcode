import java.util.Arrays;

//给你一个整数数组 nums，返回 数组 answer ，
// 其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？
// （ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
//输入: nums = [1,2,3,4]
//        输出: [24,12,8,6]
// 乘积 = 当前数左边的乘积 * 当前数右边的乘积
public class code238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        int[] out = productExceptSelf(nums);
        String listAsString = Arrays.toString(out);
        System.out.println(listAsString);
    }
}

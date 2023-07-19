import java.util.Arrays;
import java.util.Collection;

public class code209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).max().getAsInt() >= target) {
            return 1;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int out= nums.length+1;
        while(end< nums.length){
            sum += nums[end];
            while (sum>=target){
                if((end - start + 1)<out)
                {
                    out = end - start + 1;
                }
                sum -= nums[start];
                start++;
            }
            end++;
        }
        if(out<= nums.length){
            return out;
        }
        return 0;
    }

    public static void main(String[] args) {
        code209 code = new code209();
        int target = 11;
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int out = code.minSubArrayLen(target, nums);
        System.out.println(out);
    }
}


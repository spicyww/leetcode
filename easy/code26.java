import java.util.Arrays;

public class code26 {
    public static int removeDuplicates(int[] nums){
        int slow = 0;
        int fast = 1;
        while (fast<nums.length){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
            else {
                fast++;
            }
        }
        return slow+1;
    }

    public static void main(String args[]){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        System.out.println(k);
        String listAsString = Arrays.toString(nums);
        System.out.println(listAsString);
    }
}


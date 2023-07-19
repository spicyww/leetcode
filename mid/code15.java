import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        int s = 0;
        int e = nums.length;
        int m = e / 2;
        while (s<m&&m<e){
            int res = nums[s] + nums[e] + nums[m];
            if(res == 0){
                out.add(add_l(s, e, m));
            }
        }
        return null;
    }

    public static List<Integer> add_l(int nums1, int nums2, int nums3){
        List<Integer> out = new ArrayList<>();
        out.add(nums1);
        out.add(nums2);
        out.add(nums3);
        return out;
    }

    public static void main(String[] args) {
        code15 test = new code15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> out = test.threeSum(nums);
        System.out.println(out);
    }
}


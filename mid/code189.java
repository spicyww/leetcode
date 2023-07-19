import java.util.Arrays;

//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//        输入: nums = [1,2,3,4,5,6,7], k = 3
//        输出: [5,6,7,1,2,3,4]
//        解释:
//        向右轮转 1 步: [7,1,2,3,4,5,6]
//        向右轮转 2 步: [6,7,1,2,3,4,5]
//        向右轮转 3 步: [5,6,7,1,2,3,4]
//        选择空间占用仅为1的方法
public class code189 {
    //    public static int[] rotate(int[] nums, int k){
//        int[] newline = new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            int index = (i + k)% nums.length;
//            newline[index] =  nums[i];
//        }
//        return newline;
//    }
    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
        return nums;
    }
    //找最大公约数，
    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        int[] out = rotate(nums, k);
        String listAsString = Arrays.toString(out);
        System.out.println(listAsString);
    }
}

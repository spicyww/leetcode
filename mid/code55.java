


//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//        判断你是否能够到达最后一个下标。


//只需要判断最远能不能到达最后一个点就行

import java.util.ArrayList;
import java.util.List;

public class code55 {
    public static boolean canJump(int[] nums) {
        int i = nums.length - 1;
        while (i!=0){
            List<Integer> sublist = subList(nums, i);
            int point = find(sublist);
            if(point==-1){
                return false;
            }
            i = point;
        }
        return true;
    }
    public static List<Integer> subList(int[] nums, int k){
        List<Integer> sublist = new ArrayList<>();
        for(int i=0;i<k;i++){
            sublist.add(nums[i]);
        }
        return sublist;
    }
    public static int find(List<Integer> nums){
        for(int i=0;i<nums.size();i++){
            int dis = nums.size() - i;
            if(dis <= nums.get(i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] prices = new int[]{3,2,1,0,4};
        boolean out = canJump(prices);
        System.out.println(out);
    }

}

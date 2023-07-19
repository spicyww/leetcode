
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
// 多数元素就肯定是出现次数最多的元素

import java.util.HashMap;
import java.util.Map;

public class code169 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            boolean containsKey = hashMap.containsKey(num);
            if (containsKey) {
                int value = hashMap.get(num) + 1;
                hashMap.put(num, value);
            } else {
                hashMap.put(num, 1);
            }
        }
        int max = 0;
        int out = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value > max){
                max = value;
                out = key;
            }
        }
        return  out;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int out = majorityElement(nums);
        System.out.println(out);
    }
}

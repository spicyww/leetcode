//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
//        如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//注意：
//
//对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//如果 s 中存在这样的子串，我们保证它是唯一的答案。


// 滑动窗口的通常解决思路
// 设定左边界和右边界，滑动右边界指到符合条件后，记录并滑动左边界
public class code76 {
    public static String minWindow(String s, String t){
        // 排除t比s长的情况
        if(s.length()<t.length()){
            return "";
        }
        int left = 0;
        int right = 1;
        while (right<s.length()){
            
        }

        return "";
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String out = minWindow(s, t);
        System.out.println(out);
    }
}

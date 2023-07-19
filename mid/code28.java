
//给你两个字符串 haystack 和 needle ，
//请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回  -1 。
public class code28 {
    public static int strStr(String haystack, String needle){
        for(int i=0;i<haystack.length();i++){
            if((haystack.length()-i)<needle.length()){
                return -1;
            }
            int temp = i;
            for(int j=0;j<needle.length();j++){
                if(needle.charAt(j)!=haystack.charAt(temp)){
                    break;
                }
                temp++;
            }
            if((temp-i)==needle.length()){
                return i;
            }
        }
        return -1;
    }
//    public static int strStr2(String haystack, String needle){
//         //得到部分匹配表
//        //全部长度减去匹配长度，得到需要位移的长度
//    }

    public static void main(String[] args) {
        String haystack = "abc";
        String needle = "c";
        int out = strStr(haystack, needle);
//        int out2 = strStr2(haystack, haystack);
//        System.out.println(out2);
        System.out.println(out);
    }
}

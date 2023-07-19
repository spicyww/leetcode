import java.util.ArrayList;
import java.util.List;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//输入：strs = ["flower","flow","flight"]
//        输出："fl"
public class code14 {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer out_string = new StringBuffer();
        String str = strs[0];
        int count;
        for(int i=0; i<str.length(); i++){
            count = 0;
            for(int j=0; j<strs.length; j++){
                if(strs[j].length()<=i){
                    count = -1;
                    break;
                }
                if(strs[j].charAt(i)!= str.charAt(i)){
                    count = -1;
                    break;
                }
            }
            if(count!=-1){
                out_string.append(String.valueOf(str.charAt(i)));
            }
            else {
                break;
            }
        }
        return out_string.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String out = longestCommonPrefix(strs);
        System.out.println(out);
    }
}

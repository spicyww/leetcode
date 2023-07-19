
//给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//
//单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
//返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//
//注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
//返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

//输入：s = "the sky is blue"
//        输出："blue is sky the"
public class code151 {
    public static String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuffer out_string = new StringBuffer();
        int count = 0;
        for(int i=words.length-1;i>=0;i--){
            if (words[i] == "") {
                continue;
            }
            if(count != 0){
                out_string.append(" ");
            }
            out_string.append(words[i]);
            count=1;
        }
        return out_string.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        String out = reverseWords(s);
        System.out.println(out);
    }
}


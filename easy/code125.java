//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
//短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
//字母和数字都属于字母数字字符。
//
//给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

public class code125 {
    public static boolean isPalindrome(String s) {
        StringBuffer s_n = new StringBuffer();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if((int) c >=97 && (int) c <= 122) {
                s_n.append(c);
            }
            else if((int) c >=65&&(int) c <=90){
                s_n.append((char)(c+32));
            }
            else if((int) c >=48&&(int) c <=57) {
                s_n.append(c);
            }
        }
        int i = 0;
        int j = s_n.length()-1;
        while (i<j){
            if(s_n.charAt(i) != s_n.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        boolean out = isPalindrome(s);
        System.out.println(out);
    }
}


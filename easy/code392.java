public class code392 {
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i!=(s.length())){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean out = isSubsequence(s, t);
        System.out.println(out);
    }
}


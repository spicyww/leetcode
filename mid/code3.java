import java.util.HashSet;
import java.util.Set;

public class code3 {
    public static int lengthOfLongestSubstring(String s){

        //初始化一个哈希表集合
        Set<Character> occ = new HashSet<>();
        int n  = s.length();
        int ans = 0;
        int rk = -1; //第一个点的前面一个点
        for(int i=0;i<n;i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));//右移之后，去除掉前面的点
            }
            while(rk+1<n&&!occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            ans =  Math.max(ans, rk-i+1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}



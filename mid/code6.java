
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
public class code6 {
    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        StringBuffer out_string = new StringBuffer();
        int dis = (numRows - 1)*2;
        for(int i = 0; i< numRows; i++){
            int temp = i;
            while(i<s.length()){
                if(temp==0 || temp==numRows-1){
                    out_string.append(s.charAt(i));
                    if(i+dis<s.length()){out_string.append(s.charAt(i+dis));}
                    i += dis*2;
                }
                else{
                    out_string.append(s.charAt(i));
                    if(i+(dis-temp*2)<s.length()){
                        out_string.append(s.charAt(i+(dis-temp*2)));
                    }
                    i = i + dis;
                }
            }
            i = temp;
        }
        return out_string.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String out = convert(s, numRows);
        System.out.println(out);
    }
}
//PINALSIGYAHRPI
import java.util.HashMap;

public class code13 {
    public static int romanToInt(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        int count = 0;
        for(int i=0;i<s.length();i++){
            int data1 = hashMap.get(String.valueOf(s.charAt(i)));
            if(i!=s.length()-1) {
                int data2 = hashMap.get(String.valueOf(s.charAt(i + 1)));
                if (data1 < data2) {
                    count = count + data2 - data1;
                    i++;
                    continue;
                }
            }
            count += data1;
        }
        return count;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
        int out = romanToInt(s);
        System.out.println(out);
    }
}


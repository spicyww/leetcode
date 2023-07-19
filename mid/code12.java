import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
public class code12 {
    public static String intToRoman(int num) {
        List<Character> out = new ArrayList<>();
        int data1 = num%10;
        int data2 = (num-data1)%100;
        int data3 = (num-data1-data2)%1000;
        int data4 = (num-data1-data2-data3)%10000;
        int count4 = data4 / 1000;
        add_char(out, count4, 'M');
        if(data3 != 0){
            if(data3<400){
                add_char(out, data3/100, 'C');
            }
            else if(data3==400){
                out.add('C');
                out.add('D');
            }
            else if(data3==900){
                out.add('C');
                out.add('M');
            }
            else{
                out.add('D');
                add_char(out, (data3-500)/100, 'C');
            }
        }
        if(data2 != 0) {
            if (data2 < 40) {
                add_char(out, data2 / 10, 'X');
            }
            else if (data2 == 40) {
                out.add('X');
                out.add('L');
            }
            else if (data2 == 90) {
                out.add('X');
                out.add('C');
            } else {
                out.add('L');
                add_char(out, (data2 - 50) / 10, 'X');
            }
        }
        if(data1 != 0) {
            if (data1 < 4) {
                add_char(out, data1, 'I');
            }
            else if (data1 == 4) {
                out.add('I');
                out.add('V');
            }
            else if (data1 == 9) {
                out.add('I');
                out.add('X');
            }
            else {
                out.add('V');
                add_char(out, (data1 - 5), 'I');
            }
        }
        String string_out = out.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return string_out;
    }

    public static void add_char(List<Character> out, int num, char s){
        for(int i =0; i<num;i++){
            out.add(s);
        }
    }

    public static void main(String[] args) {
        int num = 1994;
        String out = intToRoman(num);
        System.out.println(out);
    }
//    MCMXCIV"
}

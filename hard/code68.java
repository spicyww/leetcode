import java.util.ArrayList;
import java.util.List;
//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
//
//你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
//
//要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
//
//文本的最后一行应为左对齐，且单词之间不插入额外的空格。
//
//注意:
//
//单词是指由非空格字符组成的字符序列。
//每个单词的长度大于 0，小于等于 maxWidth。
//输入单词数组 words 至少包含一个单词。

public class code68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> out = new ArrayList<>();
        for(int i = 0;i<words.length;){
            int len = 0;
            int temp = i;
            StringBuffer out_temp = new StringBuffer();
            while((len+(i-temp))<=maxWidth){
                len += words[i].length();
                if(i==words.length-1){
                    i++;
                    int num_bank = maxWidth - len;
                    String spaces = " ";
                    for(int j=0;j<(i-temp);j++){
                        if(j!=(i-temp-1)){
                            out_temp.append(words[temp+j]);
                            out_temp.append(spaces);
                        }
                        else{
                            out_temp.append(words[temp+j]);
                            out_temp.append(spaces.repeat(num_bank-j));
                        }
                    }
                    break;
                }
                i++;
                if((len + words[i].length()+(i-temp))>maxWidth){
                    int num_bank = maxWidth - len;
                    String spaces = " ";
                    int n_b = 0;
                    int left_num = num_bank;
                    if((i-temp-1)!=0){
                        n_b = num_bank / (i-temp-1);
                        left_num = num_bank % (i-temp -1);
                    }
                    else{
                        out_temp.append(words[temp]);
                        out_temp.append(spaces.repeat(num_bank));
                        len = 0;
                        break;
                    }
                    for(int j=0;j<(i-temp);j++){
                        if(j!=(i-temp-1)){
                            out_temp.append(words[temp+j]);
                            if(left_num>0){
                                out_temp.append(spaces.repeat(n_b+1));
                                left_num--;
                            }
                            else{
                                out_temp.append(spaces.repeat(n_b));
                            }
                        }
                        else{
                            out_temp.append(words[temp+j]);
                        }
                    }
                    len = 0;
                    break;
                }
            }
            out.add(String.valueOf(out_temp));
        }
        return out;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> out = fullJustify(words, maxWidth);
        System.out.println(out);
    }
}


//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
//
//s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
//
//例如，如果 words = ["ab","cd","ef"]，
//那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"，
//和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
//返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。

import java.util.*;

public class code30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> out = new ArrayList<>();
        int len = words.length * words[0].length();
        if(s.length() < len){
            return out;
        }
        int i = 0;
        while (i + len <= s.length()){
            HashMap<String, Integer> differ = new HashMap<>();
            for(String word:words){
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for(int j=0;j< words.length;j++){
                int start = i + j * words[0].length();
                int end = start + words[0].length();
//                s.substring(start, end+1)
                String str = s.substring(start, end);
                if(!differ.containsKey(str)){
                    break;
                }
                else{
                    differ.put(str,differ.getOrDefault(str, 0) - 1);
                    if(differ.get(str) == 0){
                        differ.remove(str);
                    }
                }

                if(j==(words.length)-1){
                    out.add(i);
                }
            }
            i++;

        }
        return out;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        List<Integer> out = findSubstring(s, words);
        System.out.println(out);
    }
}

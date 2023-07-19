
//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
//单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

public class code58 {
    public static int lengthOfLastWord(String s) {
        String [] words = s.split(" ");
        String word = words[words.length-1];
        System.out.println(word);
        return word.length();
    }

    public static void main(String[] args) {
        String s = "Hello World";
        int out = lengthOfLastWord(s);
        System.out.println(out);
    }
}

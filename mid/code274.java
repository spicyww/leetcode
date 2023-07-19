import java.util.ArrayList;

//给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
//
//根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
//一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
//并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
//找到k篇论文且这几篇论文都被引用了至少k次
public class code274 {
    public static int hIndex(int[] citations) {
        ArrayList<Integer> idx = new ArrayList<>();
        for(int list : citations){
            idx.add(list);
        }
        java.util.Collections.sort(idx);
        int i = citations.length - 1;
        int out = 0;
        while (i>=0){
            if(idx.get(i)>out){
                out++;
            }
            i--;
        }
        return out;
    }

    public static void main(String[] args){
        int[] cia = new int[]{1,3,1};
        int out = hIndex(cia);
        System.out.println(out);
    }
}


import java.util.Arrays;

//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
//你从其中的一个加油站出发，开始时油箱为空。
//
//给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
//如果存在解，则 保证 它是 唯一 的。
//从头遍历一遍，
//如果 总油量-总消耗量 为负，
//说明无法绕圈（因为从任意点出发绕一圈的总油量-总消耗量都相等）。
//否则从遍历一遍中，
//累计油量-累计消耗量的最低点出发——这样保证从这个出发点回到这个出发点的过程中，
//由于前面已经验证过有解，在最低点的下一个正点就一定是出发点
public class code134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dis_gas = new int[gas.length];
        for(int i=0;i<gas.length;i++){
            dis_gas[i] = gas[i] - cost[i];
        }
        if(Arrays.stream(dis_gas).sum()<0){
            return -1;
        }
        int count = 0;
        int idx = 0;
        int count_pos = 0;
        for(int j=0;j< dis_gas.length;j++){
            if(dis_gas[j]>0 && count < 0){
                idx = j;
                count = 0;
                count_pos++;
            }
            if(dis_gas[j]>0 && count >=0){
                if(count_pos==0){
                    idx = j;
                }
                count_pos++;
            }
            count = count + dis_gas[j];
        }
        return idx;
    }

    public static void main(String[] args){
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        int out = canCompleteCircuit(gas, cost);
        System.out.println(out);
    }
}


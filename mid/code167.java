public class code167 {
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = len / 2 + 1;
        int right = len / 2 +1;
        while((numbers[left - 1] + numbers[right - 1]) != target){
            System.out.println(numbers[left]);
            System.out.println(numbers[right]);
            if((numbers[left - 1] + numbers[right - 1]) > target){
                if(left==1){
                    right--;
                }
                else{
                    left--;
                }
            }
            else{
                if(right==len){
                    left++;
                }
                else{
                    right++;
                }
            }
        }
        return new int[]{left, right};
    }

    public static void main(String args[]){
        int target = 542;
        int [] array = new int[]{12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
        int [] out = twoSum(array, target);
        System.out.println(out);
    }
}


import java.util.Arrays;

public class code88 {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n){
        if(n == 0){
            return nums1;
        }
        if(n == nums1.length) {
            for(int i=0;i<n;i++) {
                nums1[i] = nums2[i];
            }
            return nums1;
        }
        int i = nums1.length - 1;
        m--;
        n--;
        int temp = 0;
        while(n >=0){
            while(m >=0 && nums1[m] > nums2[n]){
                temp = nums1[i];
                nums1[i] = nums1[m];
                nums1[m] = temp;
                i--;
                m--;
            }
            temp = nums1[i];
            nums1[i] = nums2[n];
            nums2[n] = temp;
            n--;
            i--;
        }
        return nums1;
    }

    public static void main(String args[]){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        int[] out = merge(nums1, m, nums2, n);
        String listAsString = Arrays.toString(out);
        System.out.println(listAsString);
    }
}




public class code11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxarea = 0;
        while(i < j){
            int area = (j-i) * Math.min(height[i], height[j]);
            if(area > maxarea){maxarea = area;}
            if(height[i]<height[j]){i++;}
            else{j--;}
        }
        return maxarea;
    }

    public static void main(String[] args) {
        code11 container = new code11();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int out = container.maxArea(height);
        System.out.println(out);
    }
}


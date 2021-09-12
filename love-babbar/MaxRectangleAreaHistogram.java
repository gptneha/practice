class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        
        for (int i=0 ; i< heights.length; i++) {
            int left = i-1;
            if (i == 0) {
                left = i;
            }
            int right = i+1;
            if (i == heights.length -1) {
                right = i;
            }
            System.out.println("Area for "+i);
            System.out.println(getAreaLeft(heights, 0, left, heights[i]) );
            System.out.println(getAreaRight(heights, 0, left, heights[i]) );
            int currentArea = getAreaLeft(heights, 0, left, heights[i]) 
                + getAreaRight(heights, left, heights.length-1, heights[i] ) 
                + heights[i]*1;
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
    
    public int getAreaLeft(int[] heights, int startIndex, int endIndex, int hight){
        int width = 0;
        for (int i =startIndex ; i <= endIndex ; i++) {
            if (heights[i] >= hight) {
                width = width +1;
            } else if (heights[i] < hight) {
                width = 0;
            }
        }
        return width * hight;
    }
    
    public int getAreaRight(int[] heights, int startIndex, int endIndex, int hight){
        int width = 0;
        for (int i = endIndex ; i >= startIndex ; i--) {
            if (heights[i] >= hight) {
                width = width +1;
            } else if (heights[i] < hight) {
                width = 0;
            }
        }
        return width * hight;
    }
}

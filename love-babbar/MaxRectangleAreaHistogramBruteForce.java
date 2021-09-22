class Solution {
    
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        
        for (int i=0 ; i< heights.length; i++) {
            int left = i-1;
            int leftArea = 0;
            int rightArea = 0;
            if (i == 0) {
                left = i;
                leftArea = 0;
            } else {
                leftArea = getAreaLeft(heights, 0, left, heights[i]);
            }
            int right = i+1;
            if (i == heights.length -1) {
                right = i;
                rightArea = 0;
            } else {
                rightArea = getAreaRight(heights, right, heights.length-1, heights[i]);
            }
            // System.out.println("Area for "+i);
            // System.out.println(leftArea );
            // System.out.println(rightArea);
            int currentArea = leftArea
                +  rightArea
                + heights[i]*1;
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
    
    public int getAreaLeft(int[] heights, int startIndex, int endIndex, int hight){
        int width = 0;
        for (int i =endIndex ; i >= startIndex ; i--) {
            if (heights[i] >= hight) {
                width = width +1;
            } else if (heights[i] < hight) {
                break;
            }
        }
        return width * hight;
    }
    
    public int getAreaRight(int[] heights, int startIndex, int endIndex, int hight){
        int width = 0;
        for (int i = startIndex ; i <= endIndex ; i++) {
            if (heights[i] >= hight) {
                width = width +1;
            } else if (heights[i] < hight) {
                break;
            }
        }
        return width * hight;
    }
}

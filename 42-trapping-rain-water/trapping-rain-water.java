class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftPtr = 0, rightPtr = n - 1;
        int leftMax = height[leftPtr], rightMax = height[rightPtr];
        int res = 0;
        while(leftPtr < rightPtr){
            if(leftMax < rightMax){
                leftPtr++;
                leftMax = Math.max(leftMax, height[leftPtr]);
                res += leftMax - height[leftPtr];
            } else{
                rightPtr--;
                rightMax = Math.max(rightMax, height[rightPtr]);
                res += rightMax - height[rightPtr];
            }
        }
        return res;
    }
}
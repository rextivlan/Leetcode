class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bot = m - 1;
        int row = 0;
        while(top <= bot){
            row = (top + bot) / 2;
            if(target > matrix[row][n-1]){
                top = row+1;
            } else if(target < matrix[row][0]){
                bot = row-1;
            } else {
                break;
            }
        }
        if(!(top <= bot)){
            return false;
        }
        int l = 0, r = n-1;
        row = (top + bot)/2;
        while(l <= r){
            int mid = (l + r) /2;
            if(matrix[row][mid] < target){
                l = mid + 1;
            } else if(matrix[row][mid] > target){
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false; 
    }
}
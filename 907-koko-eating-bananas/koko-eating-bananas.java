class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int p : piles){
            right = Math.max(right, p);
        }
        int res = right;
        while( left <= right){
            int mid = (left + right) / 2;
            long total = 0;
            for(int p: piles){
                total += (int) Math.ceil((double)p / mid);
            }
            if(total <= h){
                res = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return res;
    
    }
}
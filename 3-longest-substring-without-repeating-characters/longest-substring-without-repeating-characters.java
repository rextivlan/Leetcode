class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> mySet = new HashSet<>();
        int left = 0, res = 0;
        for(int right = 0; right < s.length(); right++){
            while(mySet.contains(s.charAt(right))){
                mySet.remove(s.charAt(left));
                left++;
            }
            mySet.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
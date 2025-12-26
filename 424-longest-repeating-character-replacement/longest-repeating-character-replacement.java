class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char endChar = s.charAt(windowEnd);
            charFreq.put(endChar, charFreq.getOrDefault(endChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, 
            charFreq.get(endChar));

            if(windowEnd - windowStart + 1 - maxRepeatLetterCount > k){
                char startChar = s.charAt(windowStart);
                charFreq.put(startChar, charFreq.get(startChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }
}
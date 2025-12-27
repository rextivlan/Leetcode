class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
       int[] freq = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int curr = 0, req = 0;
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) req++;
        }

        int l = 0, resLen = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window[c]++;

            if (freq[c] > 0 && window[c] == freq[c]) {
                curr++;
            }

            while (curr == req) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    start = l;
                }

                char left = s.charAt(l);
                window[left]--;

                if (freq[left] > 0 && window[left] < freq[left]) {
                    curr--;
                }
                l++;
        }
        
       }
       return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
    }
}
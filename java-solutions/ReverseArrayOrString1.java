class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int start = 0;
        int end = s.length-1;
        while (true) {
            if (start == end) {
                break;
            }
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            if (start +1 == end) {
                break;
            }
            start = start + 1;
            end = end -1;
            
        }
    }
}

import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> m = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        for (int i=0; i < nums.length; i ++) {
            s.add(nums[i]);
            if (!m.containsKey(nums[i])) {
                m.put(nums[i], 0);
            }
            Integer count = m.get(nums[i]) + 1;
            m.put(nums[i], count);
        }
        
        if (k==0) {
            for (Integer num : s) {
                if (m.containsKey(num) && m.get(num) >= 2) {
                    //System.out.println("been here");
                    //System.out.println(num);
                    result = result + 1;
                }
            }
        } else {
            for (int num : s) {
                Integer diff = num + k;
                if (m.containsKey(diff)) {
                    result = result +1;
                }
            }
        }
        
        return result;
    
    }
}

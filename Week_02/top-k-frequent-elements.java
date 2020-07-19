import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k == 0) return new int[]{};
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            int value = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], value);
        }

        PriorityQueue<Integer> heap 
        = new PriorityQueue<Integer>((o1, o2) -> map.get(o1) - map.get(o2));
        
        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        
        int [] result = new int[heap.size()];
       
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
// @lc code=end


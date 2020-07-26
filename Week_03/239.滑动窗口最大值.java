import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

/**
 * 时间复杂度O(N) 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
 * 队列第一个位置保存当前窗口的最大值。 注意队列存的是最大值下标 原则：对新来的元素k，将其与双端队列中的元素相比较
 * 1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值） 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 */
// @lc code=start
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		// 存储数组的index
		ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
		if (nums == null || nums.length == 0 || k <= 0) {
			return new int[0];
		}
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			// 头： 清理超长元素
			// If an element in the deque and it is out of i-(k-1), we discard them. 
			// We just need to poll from the head,
			// as we are using a deque and elements are ordered as the sequence in the array
			if (!deq.isEmpty() && deq.peekFirst() < i-(k-1)) {
				deq.pollFirst();
			}
			// 尾：检查入队条件，如不满足则移除，并保持单调性
			// 保持单调性的意义在于，永远保证头部为当前窗口的最大值
			// Now only those elements within [i-(k-1),i] are in the deque. 
			// We then discard elements smaller than a[i] from the tail. 
			// This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], 
			// or any other subsequent window: a[i] would always be a better candidate.
			while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
				deq.pollLast();
			}
			// 尾：清除完成后，当前元素从尾部入列,意味着滑动窗口向右扩充
			deq.offerLast(i);
			// 头：从头部返回最大值(考虑左边边界，队列未满)
			// As a result elements in the deque are ordered in both sequence in array and their value. 
			// At each step the head of the deque is the max element in [i-(k-1),i]
			if (i >= k - 1) {
				res[i - k + 1] = nums[deq.peekFirst()];
			}
		}
		return res;
	}
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    private int ret = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ret;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        // 一分为二
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);

        // count elements
        int count = 0;
        for (int l = left, r = middle + 1; l <= middle;) {
            if (r > right || (long) nums[l] <= 2 * (long) nums[r]) {
                l++;
                ret += count;
            } else {
                r++;
                count++;
            }
        }

        // merge sort
        int[] temp = new int[right - left + 1];
        for (int l = left, r = middle + 1, k = 0; l <= middle || r <= right;) {
            if (l <= middle && ((r > right) || nums[l] < nums[r])) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}
// @lc code=end

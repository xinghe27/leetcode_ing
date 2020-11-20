/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * 解法、哈希定位元素
 * 思路：遍历一次数组，每个元素在遍历时查找map中是否有对应元素，有->返回结果，无->存入当前元素
 * 时间复杂度：O(n) 需要一次遍历
 * 空间复杂度：O(n) hashmap的空间开销
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
// @lc code=end


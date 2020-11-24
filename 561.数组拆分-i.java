import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import sun.tools.tree.WhileStatement;

/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */

// @lc code=start
/**
 * 解法一、因为是求数对中min值的最大和，所以要尽量将相差不大两个数凑在一起
 * 以防大数被浪费掉，因此会发现，在有序的情况下，相邻两数组合，
 * (a,a+1)对于大数的损耗最小。
 * 因此思路是数组排序后，将奇数位（小数）依次相加。
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int sum = 0;
        while(i<nums.length){
            sum += nums[i];
            i+=2;
        }
        return sum;
    }
}
/**
 * 解法二、因为数字有范围，是从-10^4 ~ 10^4，因此可以将这些数字
 * 对应到0-2*10^4的hash中去，每个hash值是数字的个数。
 * 如此用空间换时间，首先遍历一遍数组，存hash
 * 然后按照数字0-2*10^4遍历一遍，从Hash取值累加
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int slot = 0;
        int sum = 0;
        boolean f = true;
        for (int i = 0; i < nums.length; i++) {
            slot = nums[i]+10000;
            if(map.containsKey(slot)){
                map.put(slot, map.get(slot)+1);
            }else
                map.put(slot,1);
        }
        for (int i = 0; i < 20001; i++) {
            slot = i;
            if(map.containsKey(slot)){
                while(map.get(slot)>0){
                    if(f)
                        sum += i-10000;
                    map.put(slot, map.get(slot)-1);
                    f = !f;
                };
            }
        }
        return sum;
    }
}
// @lc code=end


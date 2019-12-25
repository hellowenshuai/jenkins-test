package com.leetcode.c1225;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test {
    /**
     * 这种方式时间复杂度是O（N*N）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 优化，使用hashmap进行优化O（N）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) throws IllegalAccessException {
        //1.将int类型数组放入hashmap里。
        //2.遍历数组，寻找target-nums[i] = y。
        //3.去map里面寻找是否存在这样的值。且这个值对应的索引不是i
        // 返回i和y的索引即可
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            //将值存在key上，索引存在value上
            map.put(nums[i], i);
        }
        for (int i = 0; i <nums.length ; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)&&map.get(value)!=i){
                return new int[]{i,map.get(value)};
            }
        }
     throw new IllegalAccessException("No two sum solution");
    }

    public static void main(String[] args) throws IllegalAccessException {
        int[] nums = {3, 3};
        int target = 6;
        Test test = new Test();
        int[] ints = test.twoSum2(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("ints:" + ints[i]);
        }
    }
}

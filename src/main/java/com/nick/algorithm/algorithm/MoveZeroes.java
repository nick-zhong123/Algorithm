package com.nick.algorithm.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author weizhong
 * @date 2020/4/4 11:00 AM
 * @package com.nick.algorithm.algorithm
 * @description
 *
 */
@Slf4j
public class MoveZeroes {


    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     *
     * @param nums
     *
     */
    public static void moveZeros(int[] nums) {
        if (ArrayUtils.isEmpty(nums)) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,3,0,0,12,15};
        log.info(ArrayUtils.toString(nums));
        moveZeros(nums);
        log.info(ArrayUtils.toString(nums));
    }

}

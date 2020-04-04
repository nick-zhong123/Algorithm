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

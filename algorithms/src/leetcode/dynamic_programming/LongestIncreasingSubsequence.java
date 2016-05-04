package leetcode.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	/**
	 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
	 */
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
	 */
	public static int lengthOfLISRecusion(int[] nums) {
		return lisRecursionHelper(nums, 0, 0);
	}

	public static int lisRecursionHelper(int[] nums, int currIndex, int maxLength) {
		if (currIndex == nums.length - 1) {
			return 1;
		}

		int maxLengthLocal = maxLength;
		for (int i = currIndex + 1; i < nums.length; i++) {
			if (nums[i] > nums[currIndex])
				maxLengthLocal = Math.max(maxLengthLocal, 1 + lisRecursionHelper(nums, i, maxLength));
			else
				maxLengthLocal = Math.max(maxLengthLocal, lisRecursionHelper(nums, i, maxLength));
		}

		return maxLengthLocal;
	}

	public static int lengthOfLISDp(int[] nums) 
	{
		int[] memory = new int[nums.length];

		// by default their increasing subsequence is 1
		Arrays.fill(memory, 1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// if its increasing then chose current max or 1 + previous max
				if (nums[i] >= nums[j]) {
					memory[i] = Math.max(memory[i], 1 + memory[j]);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < memory.length; i++) {
			if (memory[i] > result)
				result = memory[i];
		}
		return result;
	}

}

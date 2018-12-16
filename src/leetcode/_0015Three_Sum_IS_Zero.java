package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * 三个数和为0
 * 
 * @author cy
 *
 */
public class _0015Three_Sum_IS_Zero {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, 3, -2, -4};
		Arrays.sort(nums);
		int sum = 0;
		solution(nums, sum);
	}

	private static void solution(int[] nums, int sum) {
		// TODO Auto-generated method stub
		int i, j, k;
		for (k = 0; k < nums.length; k++) {
			i = 0;
			j = k - 1;
			if (i == k) {
				i++;
			}
			if (j == k) {
				j--;
			}
			int subsum = sum - nums[k];
			while (i < j) {
				int twoSum = nums[i] + nums[j];
				if (twoSum == subsum) {
					System.out.println(nums[i]+" " + nums[j] + " "+nums[k]);
					i++;
					j--;
				}else if (twoSum < subsum) {
					i++;
				}else {
					j--;
				}
				if (k==i) {
					i++;
				}
				if (j==k) {
					j--;
				}
			}
		}
		
	}

}

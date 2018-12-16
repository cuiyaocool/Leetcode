package leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * @author cuiyao
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class _0011Contain_With_Most_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,8,6,2,5,4,8,3,7};
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		// TODO Auto-generated method stub
		int maxArea = 0;
		int s = 0;
		int e = nums.length - 1;
		while (s<e) {
			maxArea = Math.max(maxArea, Math.min(nums[s],nums[e]) * (e - s));
			if (nums[s] < nums[e]) {
				s++;
			}else {
				e--;
			}
		}
		return maxArea;
	}

}

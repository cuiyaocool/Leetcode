package leetcode;

public class _0198_House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,6,7,4};
		System.out.println(robber(nums));
	}

	private static int robber(int[] nums) {
		// TODO Auto-generated method stub
		if (nums.length <= 0) {
			return 0;
		}
		int[] max = new int[nums.length];
		max[0] = nums[0];
		max[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < max.length; i++) {
			max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
		}
		return max[max.length - 1];
	}

}

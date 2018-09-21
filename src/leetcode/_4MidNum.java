package leetcode;

/*
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 * 
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 */
public class _4MidNum {

	public static double findMidInSortedArray(int[] a, int[] b) {
		int alen = a.length;
		int blen = b.length;
		
		if (alen > blen) {
			int[] temp = a;
			a = b;
			b = temp;
			int templen = alen;
			alen = blen;
			blen = templen;
		}
		int amin = 0, amax = alen, halfLen = (1 + alen + blen)/2;
		while (amin <= amax) {
			int i = (amax + amin) / 2;
			int j = halfLen - i;
			if (b[j - 1] > a[i] && i < amax) {
				amin = i + 1;
			}
			else if (a[i - 1] > b[j] && i > amin ) {
				amax = i - 1;
			}
			else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = b[j - 1];
				} else if (j == 0) {
					maxLeft = a[i - 1];
				} else {
					maxLeft = Math.max(a[i - 1], b[j - 1]);
				}
				if ((alen + blen) % 2 == 1) {
					return maxLeft;
				}
				
				int minRight = 0;
				if (i == alen) {
					minRight = b[j];
				} else if (j == blen) {
					minRight = a[j];
				} else {
					minRight = Math.min(a[i], b[j]);
				}
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,4,6};
		int[] b = {2,3,5,6};
		int[] c = {4,7,8};
		System.out.println(findMidInSortedArray(a, b));
		System.out.println(findMidInSortedArray(a, c));
	}

}

package leetcode;

/*
 * ����������СΪ m �� n ���������� nums1 �� nums2 ��
 * ���ҳ������������������λ����Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log (m+n)) ��
 * ����Լ��� nums1 �� nums2 ��ͬʱΪ�ա�
 * nums1 = [1, 3]
 * nums2 = [2]
 * ��λ���� 2.0
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * ��λ���� (2 + 3)/2 = 2.5
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

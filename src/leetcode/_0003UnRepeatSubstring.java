package leetcode;

/**
 *  ����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ��ȡ�
 *  ʾ����
 *  ���� "abcabcbb" ��û���ظ��ַ�����Ӵ��� "abc" ����ô���Ⱦ���3
 *  ���� "bbbbb" ������Ӵ����� "b" ��������1��
 *  ���� "pwwkew" ����Ӵ��� "wke" ��������3����ע��𰸱�����һ���Ӵ���"pwke" �� ������  �������Ӵ���
 */
import java.util.LinkedList;

public class _0003UnRepeatSubstring {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "abcabcbb";

		int length = CalLengthOfLongestSubstringWithoutRepeat(ss);

		System.out.println(length);
	}

	private static int CalLengthOfLongestSubstringWithoutRepeat(String ss) {
		// TODO Auto-generated method stub

		int max = 0;// ��¼��Ӵ�����

		int current = 0;// ��¼��ǰ�Ӵ�����

		char[] cs = ss.toCharArray();
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i = 0; i < cs.length; i++) {
			if (!list.contains(cs[i])) {
				list.add(cs[i]);
				current = list.size();
				max = max > current ? max : current;
			} else {
				list.add(cs[i]);
				for (int j = 0; j <= list.indexOf(cs[i]); j++) {
					list.remove();
				}
			}

		}
		return max;
	}

}

package leetcode;

import common.ListNode;

/**
 * ���������ǿ���������ʾ�����Ǹ�������λ����������ʽ�洢��
 * ���ǵ�ÿ���ڵ�ֻ�洢�������֡���������ӷ���һ���µ�����
 * ����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
 * 
 * @author cy
 *
 */
public class _0002AddTwoNumInList {
	
	public static ListNode addTwoNum(ListNode l1, ListNode l2) {
		ListNode resListNode = new ListNode();
		ListNode p = l1, q = l2, cur = resListNode;
		int carry = 0;//jin wei
		
		while (p != null || q != null) {
			int x = (p != null) ? p.value : 0;
			int y = (q != null) ? q.value : 0;
			
			int sum = carry + x + y;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		if (carry > 0) {
			cur.next = new ListNode(carry);
		}
		return resListNode.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode h12 = new ListNode(3);
		ListNode h11 = new ListNode(4, h12);
		ListNode h1 = new ListNode(2, h11);
		
		ListNode h22 = new ListNode(4);
		ListNode h21 = new ListNode(6, h22);
		ListNode h2 = new ListNode(5, h21);
		
		ListNode res = addTwoNum(h1, h2);
		while (res != null) {
			System.out.println(res.value);
			res = res.next;
		}
	}

}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache
 * /discuss/179740/Java-O(1)-solution-with
 * -HashMap-+-Double-LinkedList-beat-95-(80ms)
 * 
 * @author cy
 *
 */
public class _146_LRU_Cache {

	static ListNode head;
	static ListNode tail;

	static Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
	private static int capcity;

	public _146_LRU_Cache(int x) {
		capcity = x;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			moveNodeToHead(node);
			return head.val;
		} else {
			return -1;
		}
	}

	private void moveNodeToHead(ListNode node) {
		// TODO Auto-generated method stub
		if (node != head) {
			if (node != tail) {
				node.pre.next = node.next;
				node.next.pre = node.pre;
			} else {
				tail = tail.pre;
				tail.next = null;
			}

			head.pre = node;
			node.next = head;
			node.pre = null;
			head = node;
		}
	}

	public void put(int key, int val) {
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			node.val = val;
			moveNodeToHead(node);
		} else {
			if (map.size() < capcity) {
				if (head == null) {
					head = new ListNode(key, val);
					tail = head;
				} else {
					ListNode node = new ListNode(key, val);
					head.pre = node;
					node.next = head;
					head = node;
					head.pre = null;
				}
				map.put(key, head);
			} else {
				ListNode newHead = new ListNode(key, val);
				head.pre = newHead;
		        newHead.next = head;
		        head = newHead;
		        head.pre = null;

		        map.put(key, newHead);

		        map.remove(tail.key);
		        tail = tail.pre;
		        tail.next = null;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 _146_LRU_Cache cache = new  _146_LRU_Cache(2);
		 cache.put(1, 1);
		 cache.put(2, 2);
		 System.out.println(cache.get(1));       // returns 1
		 cache.put(3, 3);    // evicts key 2
		 System.out.println(cache.get(2));       // returns -1 (not found)
		 cache.put(4, 4);    // evicts key 1
		 System.out.println(cache.get(1));           // returns -1 (not found)
		 System.out.println(cache.get(3));           // returns 3
		 System.out.println(cache.get(4));           // returns 4
	}

}

class ListNode {
	public int val;
	public int key;
	public ListNode next;
	public ListNode pre;

	public ListNode(int x) {
		val = x;
	}

	public ListNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
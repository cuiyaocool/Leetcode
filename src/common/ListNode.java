package common;

public class ListNode {
	public int value;
	
	public ListNode next;
	
	public ListNode(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		next = null;
	}
	
	public ListNode(){
		value = 0;
		next = null;
	}
	
	public ListNode(int value, ListNode next){
		this.value = value;
		this.next = next;
	}
}

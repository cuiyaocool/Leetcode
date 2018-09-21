package leetcode;

public class _7ReverseInt {

	public static void reverseInt(int num) {
		
		int res = 0;
		while (num != 0) {
			int temp = num % 10;
			num = num / 10;
			if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE || 
					(res == Integer.MAX_VALUE / 10 && temp > 7) || 
					(res == Integer.MIN_VALUE && temp < -8)) {
				res = 0;
				return;
			}
			res = res  * 10 + temp;
		}
		System.out.println(res);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseInt(123);
		reverseInt(-987);
	}

}

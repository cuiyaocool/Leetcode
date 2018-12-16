package leetcode;

/**
 * https://leetcode.com/problems/integer-to-roman/description/
 * @author cy
 *
 */
public class _0012Integer_to_Roman {

	static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1994;
		System.out.println(solve(num));
	}

	private static String solve(int num) {
		int position = 0;
		StringBuilder sb = new StringBuilder();
		while (position < letters.length) {
			for (int i = 0; i < num/values[position]; i++) {
				sb.append(letters[position]);
			}
			num%=values[position++];
			
		}
		return sb.toString();
	}

}

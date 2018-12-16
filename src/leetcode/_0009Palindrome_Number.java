package leetcode;

/**
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.
 * 
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author cy
 *
 */
public class _0009Palindrome_Number {
	
	public static boolean isPalindrome(int x){
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int reverseNum = 0;
		while (x > reverseNum) {
			reverseNum = reverseNum * 10 + x % 10;
			x = x / 10;
		}
		
		// When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
		return x == reverseNum || x == reverseNum / 10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1221;
		System.out.println(isPalindrome(x));
		x = 1231;
		System.out.println(isPalindrome(x));
		x = -1221;
		System.out.println(isPalindrome(x));
		
	}

}

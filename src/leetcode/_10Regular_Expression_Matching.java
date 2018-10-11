package leetcode;

/**
 * Given an input string (s) and a pattern (p), 
 * implement regular expression matching with 
 * support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 
 * url:https://leetcode.com/problems/regular-expression-matching/description/
 * @author cuiyao
 *
 */
public class _10Regular_Expression_Matching {
	static boolean[][] nums = null;
	static boolean isMatch_Recursion(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		boolean flag = ((!s.isEmpty()) &&(s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.'));
		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch_Recursion(s, p.substring(2)) ||
					(flag && isMatch_Recursion(s.substring(1), p));
		}else {
			return flag && isMatch_Recursion(s.substring(1), p.substring(1));
		}
	}
	
	static boolean isMatch_dp(String s, String p, int ss, int ps) {
		if(ss == 0 && ps == 0){
			nums = new boolean[s.length() + 1][p.length() + 1];
		}
		boolean flag = true;
		
		if (ps == p.length()) {
			flag = ss == s.length();
		}else {
			boolean match =  (ss < s.length() &&(s.charAt(ss) == p.charAt(ps) || p.charAt(ps) == '.'));
			
			if (ps + 1 < p.length() && p.charAt(ps + 1) == '*') {
				flag = isMatch_dp(s, p, ss, ps+2) || (match && isMatch_dp(s, p, ss + 1, ps));
			}else {
				flag = match && isMatch_dp(s, p, ss + 1, ps + 1);
			}
			nums[ss][ps] = flag;
		}
		
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		String p = "a";
		System.out.println(s);
		System.out.println(p);
		System.out.println(isMatch_Recursion(s, p));
		System.out.println(isMatch_dp(s, p, 0, 0));
		System.out.println();
		
		s = "aa";
		p = "a*";
		System.out.println(s);
		System.out.println(p);
		System.out.println(isMatch_Recursion(s, p));
		System.out.println(isMatch_dp(s, p, 0, 0));
		System.out.println();
		
		s = "ab";
		p = ".*";
		System.out.println(s);
		System.out.println(p);
		System.out.println(isMatch_Recursion(s, p));
		System.out.println(isMatch_dp(s, p, 0, 0));
		System.out.println();
		
		s = "aab";
		p = "c*a*b";
		System.out.println(s);
		System.out.println(p);
		System.out.println(isMatch_Recursion(s, p));
		System.out.println(isMatch_dp(s, p, 0, 0));
		System.out.println();
		
		s = "mississippi";
		p = "mis*is*p*.";
		System.out.println(s);
		System.out.println(p);
		System.out.println(isMatch_Recursion(s, p));
		System.out.println(isMatch_dp(s, p, 0, 0));
		System.out.println();
	}

}

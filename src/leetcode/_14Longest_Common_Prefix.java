package leetcode;

public class _14Longest_Common_Prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"abed","abedc","abeddd","abe","ab"};
		System.out.println(longestCommonPrefix(strs));
	}

	private static String longestCommonPrefix(String[] strs) {
		if (strs.length<=0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 0; j < strs.length; j++) {
				if (i>=strs[j].length() || strs[j].charAt(i)!=strs[0].charAt(i)) {
					return sb.toString();
				}
			}
			sb.append(strs[0].charAt(i));
		}
		return sb.toString();
	}

}

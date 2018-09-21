package leetcode;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 * 
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * @author cy
 *
 */
public class _6ZCover {
	public static void zCover(String s, int numRows) {
		
		StringBuilder[] builders = new StringBuilder[numRows];
		for (int i = 0; i < builders.length; i++) {
			builders[i] = new StringBuilder();
		}
		
		boolean down = false;
		int curRow = 0;
		for (char c : s.toCharArray()) {
			builders[curRow].append(c);
			if (curRow == 0 || curRow == numRows-1) {
				down = !down;
			}
			curRow += down ? 1 : -1; 
		}
		
		for (int i = 0; i < builders.length; i++) {
			System.out.println(builders[i].toString());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rowNums = 3;
		String string = "PAYPALISHIRING";
		rowNums = Math.min(rowNums, string.length());
		
		zCover(string, rowNums);
		
	}

}

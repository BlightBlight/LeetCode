/*
给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
    
示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

示例 3:
输入: 701
输出: "ZY"
*/

public class Number168 {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			int c = n % 26;
			if(c == 0) {
				c = 26;
				n -= 1;
			}
			sb.insert(0, (char) ('A' + c - 1));
			n /= 26;
		}
		return sb.toString();
	}
    
	public static void main(String[] args) {
		int n1 = 701;
		
		Number168 n = new Number168();
		n.convertToTitle(n1);
	}
}

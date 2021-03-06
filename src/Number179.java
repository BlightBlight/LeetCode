import java.util.Arrays;
import java.util.Comparator;

/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:
输入: [10,2]
输出: 210

示例 2:
输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
*/

public class Number179 {
	public String largestNumber(int[] nums) {
		Integer[] n = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			n[i] = nums[i];
		}
		Arrays.sort(n, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				String s1 = n1 + "" + n2;
				String s2 = n2 + "" + n1;
				//compareTo 方法
				//如果参数是一个按字典顺序排列等于该字符串的字符串，则返回值为0;
				//如果参数是按字典顺序大于此字符串的字符串，则返回值小于0;
				//如果参数是按字典顺序小于此字符串的字符串，则返回值大于0。
				return s2.compareTo(s1);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nums.length; i++) {
			sb.append(n[i]);
		}
		String res = sb.toString();
		return res.charAt(0) == '0' ? "0" : res;
	}
    
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		
		Number179 n = new Number179();
		System.out.println(n.largestNumber(nums));
	}
}

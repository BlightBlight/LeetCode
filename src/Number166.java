import java.util.HashMap;
import java.util.Map;

/*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:
输入: numerator = 1, denominator = 2
输出: "0.5"

示例 2:
输入: numerator = 2, denominator = 1
输出: "2"

示例 3:
输入: numerator = 2, denominator = 3
输出: "0.(6)"
*/

public class Number166 {
	public String fractionToDecimal(int numerator, int denominator) {
	    if(numerator == 0) {
	        return "0";
	    }
	    
	    StringBuilder fraction = new StringBuilder();
	    //负^负得正
	    if(numerator < 0 ^ denominator < 0) {
	        fraction.append("-");
	    }
	    long dividend = Math.abs(Long.valueOf(numerator));
	    long divisor = Math.abs(Long.valueOf(denominator));
	    fraction.append(String.valueOf(dividend / divisor));
	    long remainder = dividend % divisor;
	    if(remainder == 0) {
	        return fraction.toString();
	    }
	    fraction.append(".");
	    Map<Long, Integer> map = new HashMap<>();
	    while(remainder != 0) {
	        if(map.containsKey(remainder)) {
	            fraction.insert(map.get(remainder), "(");
	            fraction.append(")");
	            break;
	        }
	        map.put(remainder, fraction.length());
	        remainder *= 10;
	        fraction.append(String.valueOf(remainder / divisor));
	        remainder %= divisor;
	    }
	    return fraction.toString();
	}
    
	public static void main(String[] args) {
		int numerator = 1, denominator = 2;
		
		Number166 n = new Number166();
		n.fractionToDecimal(numerator, denominator);
	}
}

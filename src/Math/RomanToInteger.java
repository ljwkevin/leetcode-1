package Math;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月26日
 * @Description
 * Roman转换为数字. <br/>
 */
public class RomanToInteger {
	/**
	1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

	10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

	100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

	1000~3000: {"M", "MM", "MMM"}.
	*/
	
	 public int romanToInt(String s) {
		 int sum = 0;
		 for(int i = 0;i<s.length();++i){
			 int num1 = getVal(s.charAt(i));
			 int num2 = 0;
			 if(i+1<s.length())
				 num2 = getVal(s.charAt(i+1));
			 if(num1>=num2)
				 sum+=num1;
			 else{
				 sum+=num2-num1;
				 i++;
			 }
		 }
		 return sum;
	 }
	 
	 
	 int getVal(char ch){
		 switch (ch) {
		 	case 'I':
		 		return 1;
			case 'V':
		 		return 5;
			case 'X':
		 		return 10;
			case 'L':
		 		return 50;
			case 'C':
		 		return 100;
			case 'D':
		 		return 500;
			case 'M':
		 		return 1000;
			default:
				return -1;
		 }
	 }
	 
	 
	 // "DCXXI" 621
	 @Test
	 public void main(){
		 System.out.println(romanToInt("DCXXI"));
	 }
}

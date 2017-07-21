package String;

import org.junit.Test;
/**
 * @author �ɴ�Ϊ
 * @date 2015��8��1��
 * @Description
 * ��Ŀ:https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int bg = -1;
		int  i;
		for(i=s.length()-1;i>=0;--i){
			if(s.charAt(i)==' '){
				if(bg!=-1)
					break;
			}else{
				if(bg==-1)
					bg=i;
			}
		}
		if(bg==-1)
			return 0;
		else
			return bg-i;
    }
	
	@Test
	public void main(){
		System.out.println(lengthOfLastWord(" HelloWorld "));
	}
}

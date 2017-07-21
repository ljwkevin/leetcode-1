package String;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年8月1日
 * @Description
 * 题目参考： https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
	public String countAndSay(int n) {
        String str = "1";
        if(n==1)
        	return str;
        for(int i=2;i<=n;++i){
        	StringBuffer buff = new StringBuffer();
        	char preCh = ' ';
        	int num = 0;
        	for(char ch : str.toCharArray()){
        		if(ch==preCh){
        			num++;
        		}else{
        			if(preCh==' '){
        				preCh=ch;
        				num=1;
        			}else{
        				buff.append(num);
        				buff.append(preCh);
        				preCh = ch;
        				num=1;
        			}
        		}
        	}
        	buff.append(num);
			buff.append(preCh);
			str = buff.toString();
        }
        return str;
    }
	
	@Test
	public void main(){
		for(int i=1;i<=5;++i)
			System.out.println(countAndSay(i));
	}
	
}

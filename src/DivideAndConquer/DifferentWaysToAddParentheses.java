package DivideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月28日
 * @Description
 * 以运算符为分分界符，具体参考：
 * https://leetcode.com/discuss/48490/java-recursive-solution-with-memorization <br/>
 * 
 */
public class DifferentWaysToAddParentheses {
	
	  // + - * 
	  // 0 1 2
	  int calNum(int num1,int operate ,int num2){
		  if(operate==0)
			  return num1+num2;
		  else if(operate==1)
			  return num1-num2;
		  else
			  return num1*num2;
	  }
	
	  int operate2int(char ch){
		  if(ch == '+')
			  return 0;
		  if(ch == '-')
			  return 1;
		  if(ch == '*')
			  return 2;
		  return -1;
	  }
	
	  boolean isOperate(char ch){
		  if(ch=='+'||ch=='-'||ch=='*')
			  return true;
		  return false;
	  }
	
	  void cal(List<Integer> ls,List<String> lsStr,List<Integer> result,List<String> resultStr){
		  
		  if(ls.size()==1){
			  if(!resultStr.contains(lsStr.get(0))){
				  //System.out.println(lsStr.get(0));
				  resultStr.add(lsStr.get(0));
				  result.add(ls.get(0));
			  }
			  return;
		  }
		  
		  for(int i=0;i+2<ls.size();i+=2){
			  int num1 = ls.get(i);
			  int operate = ls.get(i+1);
			  int num2 = ls.get(i+2);
			  int num = calNum(num1, operate, num2);
			  List<Integer> tls = new ArrayList<Integer>();
			  List<String> tlsStr = new ArrayList<String>();
			  
		
			  String str = "("+lsStr.get(i)+lsStr.get(i+1)+lsStr.get(i+2)+")";

			  for(int j = 0;j<ls.size();++j){
				  if(j==i){
					  tls.add(num);
					  tlsStr.add(str);
					  j=i+2;
				  }else{
					  tls.add(ls.get(j));
					  tlsStr.add(lsStr.get(j));
				  }
			  }
			  cal(tls,tlsStr,result,resultStr);
		  }
		  
	  }
	  
	  public List<Integer> diffWaysToCompute(String input) {
		  	List<Integer> ls = new LinkedList<Integer>();
		  	int num = 0;
		  	List<String> lsStr = new ArrayList<>();
		  	for(int i = 0;i<input.length();++i){
		  		
		  		lsStr.add(input.substring(i,i+1));
		  	
		  		if(isOperate(input.charAt(i))){
		  			ls.add(num);
		  			num=0;
		  			ls.add(operate2int(input.charAt(i)));
		  		}else{
		  			num=num*10+(input.charAt(i)-'0');
		  		}
		  	}
		  	ls.add(num);
		  	
		  	List<Integer> result = new ArrayList<Integer>();
		  	List<String> resultStr = new ArrayList<String>();
		  	cal(ls, lsStr,result,resultStr);
	        return result;
	  }
	  
	  @Test
	  public void main(){
		  String input = "2*3-4*5";
		  List<Integer> ls = diffWaysToCompute(input);
		  for(int i :ls)
			  System.out.print(i+" ");
		  System.out.println();
	  }
}

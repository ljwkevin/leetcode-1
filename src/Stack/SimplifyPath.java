package Stack;

import java.util.Stack;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月30日
 * @Description
 * 题目参考：https://leetcode.com/problems/simplify-path/ 
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		String strs[] = path.split("/");
		Stack<String> stack = new Stack<>();
		
		for(int i=1;i<strs.length;++i){
			if(strs[i].equals("")||strs[i].equals(".")){
				continue;
			}else if (strs[i].equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}else
				stack.push(strs[i]);
		}
		
		String rtStr ="";
		while(!stack.isEmpty()){
			rtStr = "/"+stack.pop()+rtStr;
		}
		if(rtStr.equals(""))
			rtStr="/";
		return rtStr;
    }
	
	@Test
	public void main(){
		
		String strs[] ={
				"/home/",
				"/a/./b/../../c/",
				"/../",
				"/home//foo/"
		};
		
		for(String str :strs)
			System.out.println(str+" "+simplifyPath(str));
	}
}

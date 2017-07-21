package Tree;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import Tree.TreeUtil.TreeNode;

/**
 * @author 闵大为
 * @date 2015年8月5日
 * @Description
 * 题目参考：https://leetcode.com/problems/unique-binary-search-trees-ii/ <br/>
 * 解题思路：递归参考 https://leetcode.com/discuss/39880/java-recursive-solution <br/>
 */

public class UniqueBinarySearchTreesII {
	
	  TreeNode copy(TreeNode root2,int val){
		  if(root2!=null){
			  TreeNode root = new TreeNode(root2.val+val);
			  root.left = copy(root2.left, val);
			  root.right = copy(root2.right, val);
			  return root;
		  }
		  return null;
	  }
	  
	  List<TreeNode> merge(int val,List<TreeNode> lsLeft,List<TreeNode> lsRight){
		  List<TreeNode> ls = new ArrayList<>();
		  for(int i=0;i<lsLeft.size();++i){
			  for(int j=0;j<lsRight.size();++j){
				  TreeNode root = new TreeNode(val);
				  root.left = lsLeft.get(i);
				  root.right = copy(lsRight.get(j),val);
				  ls.add(root);
			  }
		  }
		  return ls;
	  }
	  
	  public List<TreeNode> generateTrees(int n) {
		  	List<List<TreeNode>> lses = new ArrayList<List<TreeNode>>();
		  	List<TreeNode> ls0 = new ArrayList<>();
		    ls0.add(null);
		    lses.add(ls0);
		  
		    List<TreeNode> ls1 = new ArrayList<>();
		    ls1.add(new TreeNode(1));
		    lses.add(ls1);
		    
		    for(int i=2;i<=n;++i){
		    	List<TreeNode> tls = new ArrayList<>();
		    	for(int j=1;j<=i;++j){
		    		List<TreeNode> tls2 = merge(j, lses.get(j-1), lses.get(i-j));
		    		tls.addAll(tls2);
		    	}
		    	lses.add(tls);
		    }
	        return lses.get(n);
	  }
	  
	  @Test
	  public void main(){
		  List<TreeNode> ls = generateTrees(3);
		  for(TreeNode root :ls){
			  TreeUtil.print(root);
		  }
	  }
}

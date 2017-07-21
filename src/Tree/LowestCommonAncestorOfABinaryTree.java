package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import Tree.TreeUtil.TreeNode;

/**
 * @author 闵大为
 * @date 2015年8月6日
 * @Description
 * 解题思路：首先检查相互是否是父节点，如果不是则从根开始进行搜索。 <br/>
 * 经典参考：https://leetcode.com/discuss/46656/accepted-java-solution <br/>
 */
public class LowestCommonAncestorOfABinaryTree {
	 
	void visit(TreeNode root,List<TreeNode> ls,Map<TreeNode,List<TreeNode>> map,TreeNode p, TreeNode q){
		if(root!=null){
			ls.add(root);
			map.put(root, ls);
			if(map.containsKey(p)&&map.containsKey(q))
				return;
			if(root!=p&&root!=q){
				visit(root.left,new ArrayList<>(ls),map,p,q);
				visit(root.right,new ArrayList<>(ls),map,p,q);
			}
		}
	}
	
	boolean isHave(TreeNode  root,TreeNode obj){
		if(root!=null){
			if(root==obj)
				return true;
			else
				return isHave(root.left, obj)||isHave(root.right, obj);
		}
		return false;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
			if(isHave(p, q))
				return p;
			if(isHave(q, p))
				return q;
		
		 	Map<TreeNode,List<TreeNode>> map = new HashMap<>();
		 	List<TreeNode> ls = new ArrayList<>();
		 	visit(root, ls, map,p,q);
		 	List<TreeNode> lsp = map.get(p);
		 	List<TreeNode> lsq = map.get(q);
		 	TreeNode pre  = null;
		 	int len = Math.min(lsp.size(), lsq.size());
		 	for(int i=0;i<len;++i){
		 		if(lsp.get(i).equals(lsq.get(i)))
		 			pre = lsp.get(i);
		 	}
	        return pre;
	 }
	 
	 @Test
	   public void main(){
		    TreeNode t1 = new TreeNode(3);
			TreeNode t2 = new TreeNode(5);
			TreeNode t3 = new TreeNode(1);
			TreeNode t4 = new TreeNode(6);
			TreeNode t5 = new TreeNode(2);
			TreeNode t6 = new TreeNode(0);
			TreeNode t7 = new TreeNode(8);
			TreeNode t8 = new TreeNode(7);
			TreeNode t9 = new TreeNode(4);

			t1.left = t2;
			t1.right = t3;
			
			t2.left = t4;
			t2.right = t5;
			
			t3.left = t6;
			t3.right = t7;
			
			t5.left = t8;
			t5.right = t9;
		
			TreeUtil.print(t1); 
			
			System.out.println(lowestCommonAncestor(t1,t2,t3).val);
	   }
	 
}

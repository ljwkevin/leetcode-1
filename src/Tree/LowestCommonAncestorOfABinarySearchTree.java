package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Tree.TreeUtil.TreeNode;
/**
 * @author 闵大为
 * @date 2015年8月6日
 * @Description
 * 经典算法参考：https://leetcode.com/discuss/50436/my-java-recursive-solution
 */
public class LowestCommonAncestorOfABinarySearchTree {
	void visit(TreeNode root,List<TreeNode> ls,Map<TreeNode,List<TreeNode>> map,TreeNode p, TreeNode q){
		if(root!=null){
			ls.add(root);
			map.put(root, ls);
			if(map.containsKey(p)&&map.containsKey(q))
				return;
			if(root!=p&&root!=q){
				if((root.val>p.val&&!map.containsKey(p))
						||(root.val>q.val&&!map.containsKey(q)))
					visit(root.left,new ArrayList<>(ls),map,p,q);
				if((root.val<p.val&&!map.containsKey(p))
						||(root.val<q.val&&!map.containsKey(q)))
					visit(root.right,new ArrayList<>(ls),map,p,q);
			}
		}
	}
	
	boolean isHave(TreeNode  root,TreeNode obj){
		if(root!=null){
			if(root==obj)
				return true;
			else
				if(root.val>obj.val)
					return isHave(root.left, obj);
				else
					return isHave(root.right, obj);
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
}

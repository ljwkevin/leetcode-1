package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月29日
 * @Description
 * 参考：https://leetcode.com/discuss/44362/java-solution-using-two-stacks
 */
public class BinaryTreePostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
       	List<Integer> ls = new ArrayList<Integer>();
		if(root==null)
			return ls;
		
		Stack<TreeNode> stack  = new Stack<>();
		Stack<Integer>  visit  = new Stack<>();
		
		stack.push(root);
		visit.push(0);
		
		while(!visit.isEmpty()){
			if(visit.peek()==0){
				visit.pop();
				visit.push(1);
				TreeNode node = stack.peek();	
				if(node.right!=null){
					stack.push(node.right);
					visit.push(0);
				}
				if(node.left!=null){
					stack.push(node.left);
					visit.push(0);
				}
			}else{
				TreeNode node = stack.pop();	
				visit.pop();
				ls.add(node.val);
			}
		}
		return ls;
	}

	
	public List<Integer> postorderTraversal2(TreeNode root) {
		  List<Integer> res = new ArrayList<Integer>();

		  if (root == null)
		    return res;

		  Stack<TreeNode> s1 = new Stack<TreeNode>();
		  Stack<TreeNode> s2 = new Stack<TreeNode>();

		  s1.push(root);

		  while (!s1.isEmpty()) {
		    TreeNode node = s1.pop();
		    s2.push(node);

		    if (node.left != null)
		      s1.push(node.left);

		    if (node.right != null)
		      s1.push(node.right);
		  }

		  while (!s2.isEmpty())
		    res.add(s2.pop().val);

		  return res;
		}
	@Test
	public void main() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t1.left = t4;
		t1.right = t2;
		t2.left = t3;
		t2.right = t5;
		
		List<Integer> ls = postorderTraversal(t1);
		for(int i : ls)
			System.out.print(i+" ");
		System.out.println();
		
	}
}

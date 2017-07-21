package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {
	static class TreeNode{
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public static void _print(TreeNode root,List<String> ls,int h){
		if(root==null){
			if(h==ls.size()){
				ls.add("# ");
			}else
				ls.set(h, ls.get(h)+"# ");
		}else{
			if(h==ls.size())
				ls.add(""+root.val+" ");
			else
				ls.set(h, ls.get(h)+root.val+" ");
			_print(root.left, ls, h+1);
			_print(root.right, ls, h+1);
		}
	}
	
	public static void print(TreeNode root){
		List<String> ls = new ArrayList<String>();
		_print(root, ls, 0);
		for(String str:ls)
			System.out.print(str+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		
		
		TreeNode t6 = new TreeNode(5);
		TreeNode t7 = new TreeNode(2);

		t1.left = t2;
		t1.right = t3;
		t2.left = t6;
		t2.right = t7;
		t3.left = t4;
		t3.right = t5;
		
		print(t1);

	}
}

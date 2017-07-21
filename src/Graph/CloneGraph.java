package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author 闵大为
 * @date 2015年8月7日
 * @Description
 * 题目参考：https://leetcode.com/problems/clone-graph/ <br/>
 * 解题参考：https://leetcode.com/discuss/47667/my-java-solution-with-hashmap-and-recursive
 */
public class CloneGraph {
	class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { 
		    	  label = x; 
		    	  neighbors = new ArrayList<UndirectedGraphNode>(); }
	 };
	 
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		 if(node == null)
			 return null;
		 
		 UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		 Map<Integer,UndirectedGraphNode> map = new HashMap<>(); 
		 map.put(newNode.label, newNode);
		 
		 Set<Integer> visited = new HashSet<>();
		 visited.add(node.label);
		 
		 Queue<UndirectedGraphNode> que = new LinkedList<>();
		 que.offer(node);
		 while(!que.isEmpty()){
			 UndirectedGraphNode tNode = que.poll();
			 UndirectedGraphNode tNode2 = map.get(tNode.label);
			 
			 for(UndirectedGraphNode neighbor : tNode.neighbors){
				 if(!map.containsKey(neighbor.label))
					 map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
				 UndirectedGraphNode neighbor2 = map.get(neighbor.label);
				 tNode2.neighbors.add(neighbor2);
				 if(!visited.contains(neighbor.label)){
					 visited.add(neighbor.label);
					 que.add(neighbor);
				 }
			 }
		 }
		 return  newNode;
	 }
	 
}

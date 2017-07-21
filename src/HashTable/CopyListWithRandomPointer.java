package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
/**
 * @author 闵大为
 * @date 2015年7月23日
 * @Description
 * 建立一对一映射，然后遍历拷贝.<br/>
 */
public class CopyListWithRandomPointer {
	
	  class RandomListNode {
		  int label;
		  RandomListNode next, random;
		  RandomListNode(int x) { this.label = x; }
		@Override
		public String toString() {
			return "RandomListNode [label=" + label + ", next=" + (next==null?"null":""+next.label)
					+ ", random=" + (random==null?"null":""+random.label) + "]";
		}
		  
		  
	  };
	  
	  int idx = 1;
	  void vistRandomList(RandomListNode head,Map<RandomListNode,Integer> node2int){
		  if(head!=null){
			  if(!node2int.containsKey(head)){
				  node2int.put(head, idx);
				  idx++;
				  vistRandomList(head.next, node2int);
				  vistRandomList(head.random, node2int);
			  }
		  }
	  }
	  
	  void copyList( 
			  RandomListNode head,
			  Map<RandomListNode,Integer> node2int,
			  Set<RandomListNode> visited,
			  RandomListNode newHead,
			  Map<Integer,RandomListNode> int2node 
			  
			  ){
		  if(head!=null){
			  if(!visited.contains(head)){
				  visited.add(head);
				  
				  newHead = int2node.get(node2int.get(head));
				  
				  if(head.next!=null)
					  newHead.next = int2node.get(node2int.get(head.next));
				  
				  if(head.random!=null)
					  newHead.random = int2node.get(node2int.get(head.random));
					  
				  copyList(head.next, node2int,visited,newHead.next,int2node);
				  copyList(head.random, node2int,visited,newHead.random,int2node);
			  }
		  }
		  
	  }
	
	  public RandomListNode copyRandomList(RandomListNode head) {
		  Map<RandomListNode,Integer> node2int = new HashMap<>();
		  vistRandomList(head,node2int);
		  
		  Map<Integer,RandomListNode> int2node = new HashMap<>();
		  for(Map.Entry<RandomListNode, Integer> entry : node2int.entrySet()){
			  RandomListNode randomListNode = entry.getKey();
			  Integer integer = entry.getValue();
			  RandomListNode randomListNode2 = new RandomListNode(randomListNode.label);
			  int2node.put(integer, randomListNode2);
		  }
		  
		  RandomListNode newHead = int2node.get(node2int.get(head));
		  copyList(head, node2int,new HashSet(),newHead,int2node);
		 
		  return newHead;
	  }
	  
	  
	  void vistPrint(RandomListNode head,Set<RandomListNode> sets){
		  if(head!=null){
			  if(!sets.contains(head)){
				  System.out.println(head);
				  sets.add(head);
				  
				  if(head.next!=null)
					  vistPrint(head.next,sets);
				  if(head.random!=null)
					  vistPrint(head.random,sets);
			  }
		  }
	  }
	  
	  @Test
	  public void main(){
		  RandomListNode head = new RandomListNode(-1);
		  RandomListNode node1 = new RandomListNode(-2);
		  //RandomListNode node2 = new RandomListNode(789);
		  head.next= node1;
		  head.random=node1;
		  
		  node1.next = null;
		  node1.random = head;
		  
		 // node2.next = null;
		 // node2.random = null;
		  vistPrint(head,new HashSet<RandomListNode>());
		  
		  RandomListNode newHead = copyRandomList(head); 
		  
	
		  System.out.println("------------");
		  vistPrint(newHead,new HashSet<RandomListNode>());
	  }
	  
}

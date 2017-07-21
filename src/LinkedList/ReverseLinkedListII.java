package LinkedList;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月24日
 * @Description
 * 指定位置倒叙，交换值. <br/>
 */
public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		List<Integer> ls = new ArrayList<>();
		ListNode p = head;
		int idx = 1;
		while (p != null) {
			if (idx >= m) {
				if (idx <= n)
					ls.add(p.val);
				else
					break;
			}
			idx++;
			p = p.next;
		}

		p = head;
		idx = 1;
		while (idx < m) {
			idx++;
			p = p.next;
		}
		for (int i = ls.size() - 1; i >= 0; --i) {
			p.val = ls.get(i);
			p = p.next;
		}

		return head;
	}

	void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	@Test
	public void main() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		print(node1);

		ListNode node = reverseBetween(node1, 1, 5);

		print(node);

	}
}

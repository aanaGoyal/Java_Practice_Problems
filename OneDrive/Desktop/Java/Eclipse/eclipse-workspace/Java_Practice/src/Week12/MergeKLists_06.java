package Week12;

import java.util.PriorityQueue;

public class MergeKLists_06 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
	static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val, b.val)
        );

        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            tail.next = current;
            tail = tail.next;
            if(current.next != null){
                pq.offer(current.next);
            }
        }
        return dummy.next;
	}
	
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		
		ListNode head3 = new ListNode(2);
		head3.next = new ListNode(6);
		
		
		ListNode[] lists = new ListNode[3];
		lists[0] = head1;
		lists[1] = head2;
		lists[2] = head3;
		
		ListNode mergedList = mergeKLists(lists);
		while(mergedList != null) {
			System.out.print(mergedList.val + " ");
			mergedList = mergedList.next;
		}
	}
}

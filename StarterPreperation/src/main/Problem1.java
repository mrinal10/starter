
class LinkedListNode{
	int data;
	LinkedListNode next;
	public LinkedListNode(int v) {
		data = v;
		next = null;
	}
}

public class Problem1 {
	
	private static int getIntersectionPoint(LinkedListNode head1, LinkedListNode head2){
		int length1 = getLen(head1);
		int length2 = getLen(head2);
		int diff = 0;
		if(length1>length2){
			diff = length1 - length2;
			return diffVaue(diff, head1, head2);
		}else{
			diff = length2 - length1;
			return diffVaue(diff, head2, head1);
		}
	}
	
	private static int diffVaue(int diff, LinkedListNode node1, LinkedListNode node2){
		LinkedListNode cur1 = node1;
		while(diff-->0){
			cur1 = cur1.next;
		}
		LinkedListNode cur2 = node2;
		
		while(cur1.next!=cur2.next){
			cur1 = cur1.next;
			cur2 = cur2.next;
		}

		if(cur1.next!=null)
			return cur1.next.data;
		else
			return -1;
	}
	
	private static int getLen(LinkedListNode head){
		int cnt=0;
		LinkedListNode cur = head;
		while(cur.next!=null){
			cur = cur.next;
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		LinkedListNode midNode = new LinkedListNode(15);
		midNode.next = new LinkedListNode(30);
		
		LinkedListNode fNode = new LinkedListNode(3);
		LinkedListNode fNode2 = new LinkedListNode(6);
		fNode.next = fNode2;
		LinkedListNode fNode3 = new LinkedListNode(9);
		fNode2.next = fNode3;
		fNode3.next = midNode;
		
		LinkedListNode sNode = new LinkedListNode(10);
		sNode.next = midNode;
		System.out.println(getIntersectionPoint(fNode, sNode));
		
		
	}
}

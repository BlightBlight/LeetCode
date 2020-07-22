/*
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。

进阶：
你能用 O(1)（即，常量）内存解决此问题吗？
*/

public class Number141 {
    public boolean hasCycle(ListNode head) {
    	if(head == null) {
    		return false;
    	}
    	
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            if(fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            //到达相遇点
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode temp = head;
		ListNode l = new ListNode(2);
		temp.next = l;
		temp = temp.next;
		temp.next = new ListNode(0);
		temp = temp.next;
		temp.next = new ListNode(-4);
		temp = temp.next;
		temp.next = l;
		
		Number141 n = new Number141();
		n.hasCycle(head);
	}
}
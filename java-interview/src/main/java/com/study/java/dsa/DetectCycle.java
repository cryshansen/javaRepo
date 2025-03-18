package com.study.java.dsa;

class ListNodeCycle {
    int val;
    ListNodeCycle next;

    ListNodeCycle(int val) {
        this.val = val;
        this.next = null;
    }
}
//Detect a Cycle in a Linked List (Floyd’s Cycle Detection Algorithm)
public class DetectCycle {
    public static boolean hasCycle(ListNodeCycle head) {
        if (head == null) return false;

        ListNodeCycle slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; // Cycle detected
        }
        return false;
    }

    // ✅ Static method for Main.java
    public static void run() {
        ListNodeCycle head = new ListNodeCycle(1);
        head.next = new ListNodeCycle(2);
        head.next.next = new ListNodeCycle(3);
        head.next.next.next = new ListNodeCycle(4);
        head.next.next.next.next = head.next; // Creates a cycle

        System.out.println("Cycle detected? " + hasCycle(head));
    }
}

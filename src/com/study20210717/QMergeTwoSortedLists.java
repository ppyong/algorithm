package com.study20210717;

//https://leetcode.com/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode ret = new MergeTwoSortedLists().mergeTwoLists(new ListNode(1), new ListNode(2, new ListNode(3)));
        while(true) {
            System.out.println(ret.val);
            ret = ret.next;
            if(ret == null)
                break;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

package com.data.structure;

public class ListPartiton {
    public Node head;
    Node prev;
    Node small;

    public Node sort(Node head, int x) {
        int old;
        int present;
        Node temp1 = head;
        Node prev = head;

        while (head != null) {
            if(head.item>x)
                //prev=addItem(head.item);
            if (head.item == x) {
                while (head != null) {
                    Node current = head.next;
                    while (current != null) {
                        if (head.item> current.item) {
                            old=head.item;
                            present=current.item;
                            current.item=old;
                            head.item=present;
                            // break;

                        }
                        current=current.next;
                    }
                    if(head!=null)
                        head=head.next;

                }
                 break;
            }
            else{
                head=head.next;
            }
        }
        head = temp1;
        return head;
    }

    private  Node partition(Node head,int x){
        int temp;
        Node temp1=head;
        Node prev=head;
        int current;
        while(head!=null)
        {
            if(head.next!=null && head.item>head.next.item && head.next.item!=x)
            {
                current=head.item;
                temp =  head.next.item;
                head.next.item = current;
                head.item = temp;

            }
            head=head.next;
        }
        head=temp1;
        return head;
    }
    public void addItem(int item){
        Node temp = head;
        if(head == null){
            head = new Node(item);
        }
        else{
            while(true){
                if(head.next == null) {
                    head.next = new Node(item);
                    break;
                }
                head = head.next;
            }
            head = temp;
        }
    }
    private static class Node{
        int item;
        Node next;

        public Node(int item){
            this.item=item;
        }
    }
    public static void main(String ...args){
          ListPartiton l=new ListPartiton();
          l.addItem(1);
        l.addItem(6);
        l.addItem(4);

        l.addItem(3);
        l.addItem(2);
        l.addItem(5);
        l.addItem(2);

        l.addItem(-1);
        l.sort(l.head,3);
        l.partition(l.head,3);

    }
}

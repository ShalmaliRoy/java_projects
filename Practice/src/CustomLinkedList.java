public class CustomLinkedList {
public Node head;


   public void addToHead(int item){
       Node temp=head;
       Node current;
       if(head==null){
           head=new Node(item);
       }
       else {
           current=temp;
           head=new Node(item);
           head.next=current;

       }

   }

   public void printList(){
       Node temp=head;
       while(head!=null){
           if(head.next!=null)
            System.out.print(head.item+"->");
           else
            System.out.print(head.item);
           head=head.next;
       }
       head=temp;
   }

   public void delete(int item){
       Node entry=head;
       Node prev=null,current=entry;

           while(current!=null){
               if(item==current.item && current.next!=null){
                   if(prev!=null)
                    prev.next=current.next;
                   else
                       head=current.next;
                   break;
               }
               if(item==current.item && current.next==null){
                   prev.next=null;
                   break;
               }
               prev=current;
               current=current.next;
           }
       }

    public Node reverseLinkList(Node current){
        Node next =null;
        Node previous = null;
        while(current!=null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
    static class Node{
        int item;
        Node next;

        public Node(int item){
            this.item=item;
        }
    }


    public static void main(String ...args){
    CustomLinkedList customLinkedList=new CustomLinkedList();
    customLinkedList.addToHead(50);
    customLinkedList.addToHead(60);
    customLinkedList.addToHead(2);
    customLinkedList.addToHead(-10);
    customLinkedList.addToHead(32);
    customLinkedList.printList();
    customLinkedList.delete(2);
    System.out.println();
    customLinkedList.reverseLinkList(customLinkedList.head);
    customLinkedList.printList();

    }
}

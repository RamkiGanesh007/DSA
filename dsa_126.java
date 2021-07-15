//Reverse a Linked List

public class dsa_126 {
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            next=null;
        }
    }

    Node head=null;
    Node tail=null;
    int size=0;

    public void add(int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            head=tail=newnode;
        }
        else{
            tail.next=newnode;
            tail=newnode;
        }
        size++;
    }

    void reverseIterative()
    {
        Node next=head.next;
        Node prev=null;
        Node current=head;
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        tail=head;
        head=prev;
    }

    //Pending Recursion solution
    Node reverseRecursive(Node ptr)
    {
        if(ptr==null)
        {
            return null;  
        }
        if(ptr.next==null)
        {
            return ptr;
        }
        Node newnode=reverseRecursive(ptr.next);
        ptr.next.next=ptr;
        ptr.next=null;
        return newnode;
    }

    void display()
    {
        Node ptr=head;
        while(ptr!=null)
        {
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        dsa_126 k=new dsa_126();
        k.add(1);
        k.add(2);
        k.add(3);
        k.add(4);
        k.add(5);
        k.add(6);
        k.reverseIterative();
        k.display();
        k.head=k.reverseRecursive(k.head);
        k.display();
    }
}

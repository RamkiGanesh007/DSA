public class LinkedListkthElement
 {
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

    int kthelement(int k)
    {
        int data=0;
        Node ptr=head;
        Node crnt=head;

        for(int i=0;i<k;i++)
        crnt=crnt.next;

        while(crnt!=null)
        {
            ptr=ptr.next;
            crnt=crnt.next;
        }

        return ptr.data;
    }

    public static void main(String[] args) {
        LinkedListkthElement k=new LinkedListkthElement();
        k.add(1);
        k.add(2);
        k.add(3);
        k.add(4);
        k.add(5);
        k.add(6);
       System.out.println( k.kthelement(3));
    }
}

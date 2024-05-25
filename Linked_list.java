//singly linked list
public class Linked_list {
    public static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }
    }
    public static class singly_list {
        Node head =null;
        Node tail =null;
        int size=0;
        void appendAtFirst(int data)
        {
            Node newNode= new Node(data);
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                newNode.next=head;
                head=newNode;
            }
            size++;
        }
        void appendAtLast(int data)
        {
            Node newNode= new Node(data);
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                tail.next=newNode;
                tail=newNode;
            }
            size++;
        }
        void append(int data, int index)
        {
            Node trav=head;
            Node newNode=new Node(data);
            if(index<0 || index>size)
                throw new IndexOutOfBoundsException("Index out of bound");
            else if(index ==0)
                appendAtFirst(data);
            else if(index==size)
                appendAtLast(data);
            else
            {
                for(int i=1;i<index;i++)
                {
                    trav=trav.next;
                }
                newNode.next=trav.next;
                trav.next=newNode;
                size++;
            }
            
        }
        Node middleNode()
        {
            if (head == null) 
            {
                return null;
            }
            Node Fast=head;
            Node slow=head;
            while(Fast.next != null && Fast.next.next !=null)
            {
                Fast=Fast.next.next;
                slow=slow.next;
            }
            return slow;
        }
        void deleteFirst()
        {
            Node trav=head;
            if(head != null)
            {
                trav=head.next;
                head=trav;
                size--;
            }
        }
        void deleteLast()
        {
            Node trav=head;
            if(head != null)
            {
                if(head.next==null)
                {
                    head=null;
                    tail=null;
                }
                else 
                {
                    while(trav.next.next != null)
                    {
                        trav=trav.next;
                    }
                        trav.next=null;
                        tail=trav;
                }
                size--;
            }
        }
        void delete(int index)
        {
            Node trav=head;
            if(index<0 || index>=size)
            throw new IndexOutOfBoundsException("Index out of bound");
            else if(index ==0)
                deleteFirst();
            else if(index == size-1)
                deleteLast();
            else
            {
                for(int i=1;i<index;i++)
                {
                    trav=trav.next;
                }
                if(trav.next != null)
                {
                    trav.next=trav.next.next;
                    size--;
                }
            }
        }
        boolean isEmpty()
        {
            Node trav=head;
            if(head == null)
                return true;
            else
                return false;
        }
        Node reverse()
        {
           // Node trav=head;
            Node current=head;
            Node prev=null;
            Node after=null;
            while(current !=null)
            {
                after=current.next;
                current.next=prev;
                prev=current;
                current=after;
            }
            head=prev;
            return prev;
        }

        Node merge(Node headL1,Node headL2)
        {
            Node dummy = new Node(0);
            Node tail = dummy;
            while(headL1 != null && headL2 != null)
            {
                if(headL1.data<headL2.data)
                {
                    tail.next=headL1;
                    headL1=headL1.next;
                }
                else
                {
                    tail.next=headL2;
                    headL2=headL2.next;
                }
                tail=tail.next;
            }
            if(headL1 != null)
            {
                tail.next=headL1;
            }
            else
                tail.next=headL2;
            return dummy.next;
        }
        void rotate(int k) 
        {
            if (head == null || size == 0 || k % size == 0) 
            {
                return;
            }

            
            int actualRotationIndex = k % size;


            Node newTail = head;
            for (int i = 0; i < size - actualRotationIndex - 1; i++) 
            {
                newTail = newTail.next;
            }
            tail.next = head; 
            head = newTail.next; 
            newTail.next = null;
            tail = newTail; 
        }

        void display()
            {
                Node trav=head;
                while( trav != null)
                {
                    System.out.print(trav.data + " ");
                    trav=trav.next;
                }
                System.out.println();
            }
    }
    public static void main(String[] args)
    {


        singly_list s3=new singly_list();
        s3.append(0, 0);
        s3.append(1, 1);
        s3.append(2, 2);
        s3.append(3, 3);
        s3.append(4, 4);
        s3.append(5, 5);


        singly_list s4=new singly_list();
        s4.append(0, 0);
        s4.append(1, 1);
        s4.append(2, 2);
        s4.append(3, 3);

       singly_list s5= new singly_list();
       s5.head=s5.merge(s3.head, s4.head);
       s5.display();
       s5.rotate(3);
       s5.display();
      
    }
}
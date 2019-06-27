class Node{
    int data;
    Node next;
    
    Node(int d){
        data = d;
    }
}
    
class CircularSingle {
    Node head=null;
    public static void main(String []z)
    {   
        CircularSingle ob = new CircularSingle();
        ob.insertAtLast(1);
        ob.insertAtLast(2);
        ob.insertAtLast(3);
        ob.insertAtLast(4);
        ob.insertAtLast(5);
        ob.deleteAtLast();
        ob.printList();
    }
    
    void insertAtStart(int d)
    {
        Node node = new Node(d);
        Node n = head;
        if(n == null)
        {
            head = node;
            head.next = node;
        }
        else
        {
            node.next = head;
            while (n.next != head) 
                n = n.next; 
            n.next = node; 
            head = node;
        }
    }
    
    void insertAtLast(int d)
    {
        Node node = new Node(d);
        Node n = head;
        if(n == null)
        {
            head = node;
            head.next = node;
        }
        else
        {
            while (n.next != head) 
                n = n.next; 
            n.next = node;
            node.next = head;
        }
    }
    
    void deleteAtStart()
    {
        Node n = head;
        if(n == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            while (n.next != head) 
                n = n.next; 
            n.next = head.next;
            head = head.next;
        }
    }
    
    void deleteAtLast()
    {
        Node n = head;
        Node prev = null;
        if(n == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            while (n.next != head) 
            {
                prev = n;
                n = n.next; 
            }
            prev.next = n.next;
        }
    }
    
    void printList()
    {
        Node n= head;
        do{
            System.out.println(n+ " : " + n.data + " -> " + n.next);
            n = n.next;
        }while(n != head);
    }
    
}

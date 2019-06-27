class Node{
    int data;
    Node next;
    Node prev;
    Node(int d){
        data = d;
        next = null;
        prev = null;
    }
}
    
class CircularDouble {
    Node head=null;
    public static void main(String []z)
    {   
        CircularDouble ob = new CircularDouble();
        ob.insertAtLast(4);
        ob.insertAtLast(5);
        ob.insertAtLast(6);
        ob.insertAtLast(7);
        ob.insertAtLast(8);
        
        ob.deleteAtLast();
        ob.deleteAtLast();
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
            head.prev = node;
        }
        else
        {
            node.next = head;
            while (n.next != head) 
                n = n.next; 
            head.prev = node;
            n.next = node; 
            node.prev = n;
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
            node.prev = n;
            node.next = head;
            head.prev = node;
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
            head.next.prev = n;
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
                n = n.next; 
            head.prev = n.prev;
            n.prev.next = head;
        }
    }
    
    void printList()
    {
        Node n= head;
        do{
            System.out.println(n+ " : " + n.prev + " -> " + n.data + " -> " + n.next);
            n = n.next;
        }while(n != head);
    }
    
}

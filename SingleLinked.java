/*
    Functions present in the class:- 

    lastNode()
    printList()
    ReverseList()
    length()
    insertAtBegin()
    insertAtGiven()
    insertAtEnd()
    deleteStartNode()
    deleteAtGiven()
    deleteLastNode()
    searchNode()
*/

class Node
{
    int data;
    Node next;   
    Node(int d)
    {
        data = d;
        next = null;
    }
}

class SingleLinked {
    Node head;
    public static void main(String []z)
    {
        SingleLinked ob = new SingleLinked();
        ob.insertAtEnd(1);
        ob.insertAtEnd(2);
        ob.insertAtEnd(3);
        ob.insertAtEnd(4);
        ob.insertAtEnd(5);
        ob.printList();
        ob.ReverseList();
        ob.printList();
    }
    
    void ReverseList()
    {
        Node prev = null;
        Node n = head;
        Node next = null;
        while(n != null)
        {
            next = n.next;
            n.next = prev;
            
            prev = n;
            n = next;
        }
        head = prev;
        
    }
    
    void printList()
    {
        System.out.println("\nLinked list is : ");
        Node n = head;
        while(n!=null)
        {
            System.out.println(n.data +   "  ->  "+ n.next);
            n = n.next;
        }
        System.out.println();
    }
    
    int length()
    {
        int len=0;
        Node n = head;
        while(n!=null)
        {
            len++;
            n = n.next;
        } 
        return len;
    }
    
    Node lastNode()
    {
        Node n = head;
        Node k = null;
        while(n!=null)
        {
            if(n.next == null)
                k = n;
            n = n.next;
        }
        return k;
    }
    
    void insertAtBegin(int num)
    {
        Node n = head;
        head = new Node(num);
        head.next = n;
    }
    
    void insertAtGiven(int num, int pos)
    {
        Node prev = null;
        Node n = head;
        int len = length();
        
        if(pos == (len+1))
            insertAtEnd(num);  
        else if(pos ==  1)
            insertAtBegin(num);  
        else if(pos > len){
            System.out.println("Number can't be added.");
        }            
        else{
            while(pos > 1){
                prev = n;
                n = n.next;
                --pos;
            }
            Node node =  new Node(num);
            prev.next = node;
            node.next = n;
        }        
    }
    
    void insertAtEnd(int num)
    {
        Node n = head;
        if(n==null)
            head = new Node(num);
        else
        {
            Node node = lastNode();
            node.next = new Node(num);
        }
    }
    
    void deleteStartNode(){
        head = head.next;
    }
    
    void deleteLastNode()
    {
        Node node = lastNode();
        Node m = head;
        if(m == node){
            head = null;
        }else{
            while(m != null)
            {
                if(m.next == node)
                {
                    m.next = null;
                    break;
                }
                m = m.next;
            }           
        }
    }
    
    void deleteAtGiven(int pos)
    {
        Node grand = null;
        Node prev = null;
        Node n = head;
        int len = length();
        
        if(pos == len)  
            deleteLastNode();
        else if(pos ==  1)
            deleteStartNode();
        else if(pos > len){
            System.out.println("Number can't be deleted.");
        }
        else{
            while(pos > 0){
                grand = prev;
                prev = n;
                n = n.next;
                --pos;
            }
//            System.out.println("grand "+ grand.data + "  ->  "+ grand.next);
//            System.out.println("prev "+ prev.data + "  ->  "+ prev.next);
//            System.out.println("now "+ n.data + "  ->  "+ n.next);
            
            grand.next = n;
        }        
    }
    
    void searchNode(int num)
    {
        Node n = head;
        int count = 0,flag=0;
        while(n != null)
        {
            count++;
            if(n.data == num)
            {
                System.out.println(num + " found at " + count + " position.");
                flag++;
            }
            n = n.next;
        }
        if(flag == 0)
        {
            System.out.println(num+ " not found in list");
        }
    }
}

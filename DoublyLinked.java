/*
    Functions present in the class:- 

    nodeAtLast()
    print()
    length()
    insertAtStart()
    insertAtGiven()
    insertAtLast()
    deleteAtStart()
    deleteAtGiven()
    deleteAtLast()
    searhNode()
*/

class DblNode{
    int data;
    DblNode prev;
    DblNode next;
    
    DblNode(int d){
        data = d;
        prev = null;
        next = null;
    }
}

class DoublyLinked {
    DblNode head;
    public static void main(String []z)
    {
        DoublyLinked ob = new DoublyLinked();
        ob.insertAtStart(6);
        ob.insertAtStart(5);
        ob.insertAtStart(4);
        ob.insertAtStart(3);
        ob.insertAtStart(2);
        ob.print();
        ob.searchNode(4);
    }
    
    DblNode nodeAtLast(){
        DblNode last=null;
        DblNode n = head;
        while(n != null){
            if(n.next == null)
                last = n;
            n = n.next;
        }
        return last;
    }
    
    void print(){
        DblNode n = head;
        System.out.println();
        while( n != null){
           System.out.println(n + " : " + n.prev+ " <- " + n.data + " -> " + n.next);
           n = n.next;
        }
        System.out.println();
    }
    
    int length(){
        DblNode n = head;
        int count=0;
        while( n != null){
            count++;
            n = n.next;
        }
        return count;
    }
    
    void insertAtStart(int d){
        DblNode k = head;
        if(k == null)
            head = new DblNode(d);
        else{
           DblNode m = new DblNode(d);
           head = m;
           head.next = k; 
           k.prev = head;
        }
    }
    
    void insertAtGiven(int d, int pos){
        DblNode node = new DblNode(d);
                
        DblNode k = head;
        if(k == null)
            head = node;
        else{
            int len = length();
            
            if(pos > len)
              System.out.println(d + " can't be added.");
            else if(pos == 1)
                insertAtStart(d);
            else {  
                DblNode m = head;
                while(pos > 1){
                    m = m.next;
                    --pos;
                }                
                m.prev.next = node;
                node.prev = m.prev;
                node.next = m;
                m.prev = node;
            }
        }
    }
    
    void insertAtLast(int d){
        DblNode k = head;
        if(k == null)
            head = new DblNode(d);
        else{
            DblNode last = nodeAtLast();
            DblNode m = new DblNode(d);
            last.next = m;
            m.prev = last;
        }
    }
    
    void deleteAtStart(){
        DblNode k = head;
        head = head.next;
        head.prev = null;
    }
    
    void deleteAtLast(){
        DblNode last = nodeAtLast();        
        last.prev.next = null;
    }
    
    void deleteAtGiven(int pos){
        int len = length();
            
        if(pos > len)
            System.out.println("Number can't be added.");
        else if(pos == 1)
            deleteAtStart();
        else if(pos == len)
            deleteAtLast();
        else{  
            DblNode m = head;
            while(pos > 1){
                m = m.next;
                --pos;
            }
            
            m.prev.next = m.next;
            m.next.prev = m.prev;
            System.out.println(m + " : " + m.prev+ " <- " + m.data + " -> " + m.next);
           
        }
    }
    
    void searchNode(int d){
        DblNode m = head;
        int flag=0, count = 0;
        while(m != null){
            ++count;
            if(m.data == d){
                System.out.println(d + " found at "+ count);
                flag = 1;
            }
             m = m.next;
        }
        if(flag != 1)
            System.out.println(d + " not found");
           
    }
}

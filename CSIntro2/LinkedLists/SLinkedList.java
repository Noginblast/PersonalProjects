
public class SLinkedList {
    
    Node head;  
    
    public SLinkedList(){
        head=null;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public void insertAtBeginning(int new_data) {
    
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
  }
    
   public void insertAtEnd(int new_data) {
        
       Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
  }
   
   
    public void printList()
    {
       if (head == null)
            return;
       
        Node current = head;
        while (current.next != null)
        {
            System.out.print(current.key + ", ");
            current = current.next;
        
        }
       
        System.out.print(current.key + "\n");
   }
    
    public int contains(int data) {
    	//Returns -1 if list is empty
    	if(head == null)
    		return -1;
    	
    	//Creating Node type variable at the head of the linked list
    	Node current = head;
    	int index = 0;
    	
    	//While loop to return position of desired value
    	while(current.next != null) {
    		if(current.key == data)
    			return index;
    		
    		current = current.next;
    		index++;
    	}
    	
    	//Conditional statement to return position if key equals desired value to remove
    	if(current.key == data)
    		return index++;
    	
    	//Return -1 if value does not exist in list
    	return -1;
    }
   
   //complete this method 
    public void deleteAt(int position)
    {
    	//Returns function with no further action
        if (head == null)
            return;
        
        //Creating Node type variable at the head of the linked list
        Node current = head;
        
        //If the position given equals 0 then the fist node in the list is deleted
        if(position == 0) {
        	head = current.next;
        	return;
        }
        
        int index = 0;
        
        //While loop to iterate through the list to the node before the desired node
        while(index < position - 1) {
        	current = current.next;
        	index++;
        	
        	if(current.next == null) {
        		return;
        	}
        }
        
        //Removing the desired node by changing the pointers
        current.next = current.next.next;
                
   }
   
   //complete this method 
   public void deleteValue(int data)
   {
	   //Conditional Statement to determine if the key exists
       if(contains(data) > -1)
    	   deleteAt(contains(data));
        
   }
            
   
   
  

}

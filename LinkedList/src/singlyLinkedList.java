
public class singlyLinkedList {
	
	//head and tail
	public Node head;
	public Node tail;
	
	//size of the linked list
	public int size;
	
	//initial size is 0
	public singlyLinkedList() {
	}
	
	public void insertFirst(int val) {
		//create instance for Node with a given val(which is going to be the first val) 
		Node node=new Node(val);
		//Next will have the head (which is the previous first node)
		node.next=head;
		//head will become the new node
		head=node;
		//if there is no element tail point head (which represent there is only one node in Linked list)
		if(tail==null) tail=head;
		size++;
	}
	
	public void insertLast(int val) {
		//if there is no value we can just add at first
		if(tail==null) {
			insertFirst(val);
			return;
		}
		Node node=new Node(val);
		//tail.next doesn't have any value which is where we are going to add a val
		tail.next=node;
		//now the tail will denote the node
		tail=node; 
		size++;
	}
	
	public void insert(int val,int index) {
		if(index==0) {
			insertFirst(val);
			return;
		}
		if(index==size) {//no size-1 becz it will insert at size-1
			insertLast(val);
			return;
		}
		//if we need to insert an element at middle of the linked list
		Node temp=head;//it is the 0'th element
		//loop until the element we need to insert                                           
		for(int i=1;i<index;i++) {
			temp=temp.next;
			//temp=node of index-1
		}
		//creating a new node which is the given val with next which will be index+1
		Node node=new Node(val,temp.next);
		//so now finally index-1's next will be node
		temp.next=node;
		size++;
	}
	
	public int deleteFirst() {
		//val is to print it to know
		int val=head.val;
		//we just need to move the head to next node
		head=head.next;
		//if there is only one element then tail need to be null
		if(head==null) tail=null;
		size--;
		return val;
	}
	
	public Node get(int index) {
		Node node=head;
		for(int i=0;i<index;i++) {
			node=node.next;
		}
		return node;
	}
	
	public int deleteLast() {
		//we need to find the last before node in order to make it tail and it's next to null
		Node secondLast=get(size-2);
		int val=tail.val;
		tail=secondLast;
		tail.next=null;
		size--;
		return val;
	}
	
	public int delete(int index) {
		if(index==0) {
			return deleteFirst();
		}
		if(index==size-1) {
			return deleteLast();
		}
		//get the previous node
		Node prev=get(index-1);
		int val=prev.next.val;
		//5->100->4  to 5->4
		//node 5's next is node 100's next
		prev.next=prev.next.next;
		size--;
		return val;
	}
	
	public Node find(int val) {
		Node node=head;
		while(node!=null) {
			if(node.val==val) {
				return node;
			}
			node=node.next;
		}
		return null;
	}
	public void reverse() {
		Node node=head;
		Node prev=null;
		//while reversing tail changed to head
		tail=head;
		while(node!=null) {
			//save the next of cur becoz it will be changed in next step
			Node next=node.next;
			//now the reference will be reversed
			node.next=prev;
			//for next iteration 
			prev=node;
			node=next;
		}
		//now the last node is first node which will be the head
		head=prev;
	}
	//to display elements in Linked list
	public void display() {
		//head can't be moved so use a temp
		Node temp=head;
		
		//print the values until it goes to null
		while(temp!=null) {
			System.out.print(temp.val+"->");
			//it will move to next node
			temp=temp.next;
		}
		System.out.println("End");
	}
	
	//Creating node
	public class Node{
		//two inputs :val and next(reference) 
		public int val;
		public Node next;
		
		//just to store the val
		public Node(int val) {
			this.val=val;
		}
		//to store val and reference of next node
		public Node(int val,Node next) {
			this.val=val;
			this.next=next;
		}
	}
	
}

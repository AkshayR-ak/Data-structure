
public class main {

	public static void main(String[] args) {
		singlyLinkedList list=new singlyLinkedList();
		
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(5);
		list.insertFirst(6);
		list.insertFirst(7);
		
		list.insertLast(8);
		
		list.insert(100, 3);
		
		list.display();
		System.out.println(list.deleteFirst());
		
		list.display();
		System.out.println(list.deleteLast());
		
		list.display();
		System.out.println(list.delete(2));
		list.display();
		
		list.reverse();
		list.display();
	}

}

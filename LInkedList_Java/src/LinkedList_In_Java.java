import java.util.Scanner;

public class LinkedList_In_Java {
	
	int branch1entry;
	
	static Node head;
	static Node pre;

//Creating a Liked List with data field and address field as next.
	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	static int k = 0;

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		LinkedList_In_Java l = new LinkedList_In_Java();
		
// inserting 1 to 9 elements in the Linked List
		for (int i = 1; i < 10; i++) {
			l.put(i);
		}
		System.out.println("Initial elements in the Liked List are...");
		l.print();
		System.out.println();
		int st = 0;
		do {
			System.out.println();
			System.out.println("1. Insert an element in the Linked List");
			System.out.println("2. Delete a element in the Linked List ");
			System.out.println("3. Print Linked List");
			System.out.println("4. Search a element in Linked List");
			System.out.println();
			System.out.println("Select u r option");
			int cho = in.nextInt();
			switch (cho) {
			case 1: {
				System.out.println("Enter position to insert an element");
				int pos = in.nextInt();
				l.insert(pos);
				l.print();
				break;
			}
			case 2: {
				System.out.println("Enter position to insert an element");
				int pos = in.nextInt();
				l.delete(pos);
				l.print();
				break;
			}

			case 3:
				l.print();
				break;
			case 4:
				System.out.println();
				System.out.println("Enter an has to be find ");
				int da = in.nextInt();
				l.search(da);
				break;
			default:
				System.out.println("Enter a valid Option ");
				break;
			}
			System.out.println();
			System.out.println("Do u want to coninue....(1.Yes /0.No )");
			st = in.nextInt();
		} while (st == 1);
	}

	// Inserting an elements initially
	void put(int data) {

		Node new_Node = new Node(data);
		if (k == 0) {
			head = new_Node;
			pre = new_Node;
			k++;
		} else {
			pre.next = new_Node;
			pre = new_Node;
		}
		new_Node.next = null;

	}

	// For Printing the Linked List elements

	void print() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + "--> ");
			p = p.next;
		}
	}

	// Inserting an element at a position pos
	void insert(int pos) {
		if (pos == 1) {
			System.out.println("Enter Elelment to be inserted :");
			int da = in.nextInt();
			Node n = new Node(da);
			n.next = head;
			head = n;
		} else {
			int pre_position = 1, flag = 0;
			Node find_pos = head;
			while (find_pos != null) {
				if (pre_position + 1 == pos) {
					flag = 1;
					break;
				} else
					pre_position++;
				find_pos = find_pos.next;
			}
			if (flag == 1) {
				System.out.println("Enter Elelment to be inserted :");
				int da = in.nextInt();
				Node n = new Node(da);
				n.next = find_pos.next;
				find_pos.next = n;

			} else {
				System.out.println("Enter a Valid position");
			}
		}
	}

	// for Delete an element at position pos
	void delete(int pos) {
		Node find_position = head;
		int position = 1;
		if (pos == 1) {
			head = head.next;
		} else {
			int flag = 0; // To check a valid position or not
			while (find_position != null) {
				if (position + 1 == pos) {
					flag = 1; // Position was found in the Linked List
					break;
				} else
					position++;
				find_position = find_position.next;
			}

			if (flag == 0) { // If Position was not found
				System.out.println("Enter a Valid position");
			} else {
				find_position.next = find_position.next.next;
			}
		}
	}

	// Searching an element in the Liked List

	void search(int ele) {
		Node traversal = head;
		int pos = 1, flag = 0;
		while (traversal != null) {
			if (ele == traversal.data) {
				System.out.println("Element was found at position " + pos);
				flag = 1;
				return;
			}
			traversal = traversal.next;
			pos++;

		}
		if (flag == 0)
			System.out.println("Element was not found");
	}

}

//Name:
//ID: 
//Email:

// You can modify this class as you want
class LinkedList {
    Node head; // head of list

	//Node class
	//You are not allowed to modify this class
    class Node {
        int element;
        Node next;

        Node(int value) {
            element = value;
        }
    }

    // print linked list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }

        System.out.print("\n");
    }

	//############################################
	//## Implement functions belows
	//############################################
    // add new node and order the list
	// You can change the return values (from void to any) for each function as you want 
	// you can add functions as you want 
    void sortedAdd(int value) {
    }
	
	void remove(int idx) {
    }

    // find the maximum values in the list
	int findMax() {
		int max = 0; 
		return max;
	}
	
	// print linked list in a reversed order
    void printReversedList() {
    }

    public static void main(String args[])
    {
        LinkedList list = new LinkedList();

		//You will need to test your program thoughtfully. 
		//This is a testcase example.
        list.sortedAdd(5);
        list.sortedAdd(2);
        list.sortedAdd(9);
        list.sortedAdd(1);
        list.sortedAdd(7);
		System.out.println(list.findMax());
        list.printReversedList();
		///////////////////////////////
    }
}
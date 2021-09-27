package Lecture.Assignment1_template;

/**
 * 
 * @author Yixin Cao (September 11, 2021)
 *
 * A circularly and doubly linked list. 
 * 
 * The task is to split the original list into three circularly and doubly linked lists of equal length.
 * 
 * For simplicity, you can assume that the length of the input is a multiple of three. 
 * There are nine in the example in {@code main}.
 * 
 * You are not allowed to use the {@code insert} method or write a method that adding nodes to a list.
 * 
 */
public class CDList_12345678d_TangTszkei { // Please change! In Eclipse, press Alt-Shift-R on the class name. 
    class DNode {
        int element;
        DNode previous, next;

        DNode(int data) { this.element = data; }
    }

	private DNode head;

	// this method is provided for the purpose of test (in the main).
	// it's not for your use.
	public void insert(int e) {
		DNode newNode = new DNode(e);
		if (head == null) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			return;
		}
		newNode.next = head;
		newNode.previous = head.previous;
		head.previous = newNode;
		newNode.previous.next = newNode;
	}
	
    /**
     * VERY IMPORTANT.
     * 
     * I've discussed this question with the following students:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * I've sought help from the following Internet resources and books:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * Running time: O(   ).   
     */ 
	public CDList_12345678d_TangTszkei[] split() {
		CDList_12345678d_TangTszkei[] ans = new CDList_12345678d_TangTszkei[3];
        int n = this.size();
        System.out.println("Size: " + n);
        int reminder = n%3;
        System.out.println("Reminder: " + reminder);
        DNode pointer = head;
        System.out.println("Head: " + pointer.element);
        int size = n/3;
        System.out.println("Size: " + size);

        for (int i = 0; i < reminder; i++) {
            ans[i] = new CDList_12345678d_TangTszkei();
            for (int j = 0; j < size+1; j++) {
                ans[i].insert(pointer.element);
                pointer = pointer.next;
                System.out.println("List "+i+ ": "+ans[i].toString());
            }

        }

        for (int i = reminder; i < 3; i++) {
            ans[i] = new CDList_12345678d_TangTszkei();
            for (int j = 0; j < size; j++) {
                ans[i].insert(pointer.element);
                pointer = pointer.next;
                System.out.println("List "+i+ ": "+ans[i].toString());
            }

        }

		return ans;	
	}

	// Bonus question.
	public CDList_12345678d_TangTszkei[] split(int d) {
        CDList_12345678d_TangTszkei[] ans = new CDList_12345678d_TangTszkei[3];
        int n = this.size();
        System.out.println("Size: " + n);
        int reminder = n%3;
        System.out.println("Reminder: " + reminder);
        DNode pointer = head;
        System.out.println("Head: " + pointer.element);
        int size = n/3;
        System.out.println("Size: " + size);

        for (int i = 0; i < reminder; i++) {
            ans[i] = new CDList_12345678d_TangTszkei();
            for (int j = 0; j < size+1; j++) {
                ans[i].insert(pointer.element);
                pointer = pointer.next;
                System.out.println("List "+i+ ": "+ans[i].toString());
            }

        }

        for (int i = reminder; i < d; i++) {
            ans[i] = new CDList_12345678d_TangTszkei();
            for (int j = 0; j < size; j++) {
                ans[i].insert(pointer.element);
                pointer = pointer.next;
                System.out.println("List "+i+ ": "+ans[i].toString());
            }

        }

        return ans;
    }

    public int size() {
        if (head == null) return 0;
        int size;
        DNode cur = head;
        size = 1;
        cur = cur.next;
        while (cur != head) {
            size++;
            cur = cur.next;
        }
        return size;
    }

	public String toString() {
        if (head == null) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        DNode cur = head;
        sb.append(cur.element);
        cur = cur.next;
        while ( cur != head ) {
            sb.append(", " + cur.element);
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void printSplited(CDList_12345678d_TangTszkei[] ans) {
        for (CDList_12345678d_TangTszkei i: ans) System.out.println(i.toString());
    }

    public static void main(String[] args) {
        int[] a = {11, 12, 13, 55, 52, 58, 29, 26, 20};
        CDList_12345678d_TangTszkei l = new CDList_12345678d_TangTszkei();
        for (int i: a) l.insert(i);
        System.out.println(l);
        CDList_12345678d_TangTszkei[] lists = l.split();
        System.out.println(lists[0]);
        System.out.println(lists[1]);
        System.out.println(lists[2]);
    }
}

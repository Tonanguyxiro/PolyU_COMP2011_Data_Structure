package Assignment.Assignment1;

/**
 *
 * @author Tong Yuan (September 28, 2021)
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

public class CDList_21022673X_YuanTong {
     class DNode {
        int element;
        DNode previous, next;

        DNode(int data) { this.element = data; }
    }

    // Create a new CDList with an assigned DNode
    public CDList_21022673X_YuanTong(DNode n) {
        head = n;
    }

    // Create a new CDList with an empty DNode
    public CDList_21022673X_YuanTong() {

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
     * I did not discuss with any student this time
     * I've sought help from the following Internet resources and books:
     *     1. JAVA Official Documentation
     *
     * Running time: O( n ).
     */

    // Split the CDList into 3 CDList
    // The length of single CDList can vary
	public CDList_21022673X_YuanTong[] split() {
        CDList_21022673X_YuanTong[] ans = new CDList_21022673X_YuanTong[3];
        int n = this.size();
//        System.out.println("Size: " + n);
        int reminder = n%3;
//        System.out.println("Reminder: " + reminder);
        DNode pointer = head;
//        System.out.println("Head: " + pointer.element);
        int size = n/3;
//        System.out.println("Size: " + size);

        for (int i = 0; i < reminder; i++) {
            ans[i] = take(size+1);
        }
        for (int i = reminder; i < 3; i++) {
            ans[i] = take(size);
        }
		return ans;
	}

	// Bonus question.
    // Split the CDList into d CDList
    // The length of single CDList can vary
	public CDList_21022673X_YuanTong[] split(int d) {
        CDList_21022673X_YuanTong[] ans = new CDList_21022673X_YuanTong[d];
        int n = this.size();
//        System.out.println("Size: " + n);
        int reminder = n%d;
//        System.out.println("Reminder: " + reminder);
        DNode pointer = head;
//        System.out.println("Head: " + pointer.element);
        int size = n/d;
//        System.out.println("Size: " + size);

        for (int i = 0; i < reminder; i++) {
            ans[i] = take(size+1);
        }
        for (int i = reminder; i < d; i++) {
            ans[i] = take(size);
        }
        return ans;
    }

    // Take n DNode from a CDList and return a small CDList.
    public CDList_21022673X_YuanTong take(int n) {
        DNode tail;
        tail = head;
        for (int i = 1; i < n; i++) {
            tail = tail.next;
        }
        DNode newHead = tail.next;
        DNode ans = head;
        DNode newTail = head.previous;

        ans.previous = tail;
        tail.next = ans;

        head = newHead;

        head.previous = newTail;
        newTail.next = head;

        return new CDList_21022673X_YuanTong(ans);
    }

    // Count the size of the CDList
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

    // Print the splited CDList
    public static void printSplited(CDList_21022673X_YuanTong[] ans) {
        for (CDList_21022673X_YuanTong i: ans) System.out.println(i.toString());
    }

    public static void main(String[] args) {
        int[] a = {11, 12, 13, 55, 52, 58, 29, 26, 20, 21, 21, 21};
        CDList_21022673X_YuanTong l = new CDList_21022673X_YuanTong();
        for (int i: a) l.insert(i);
        System.out.println(l);
        System.out.println();
        printSplited(l.split());
        System.out.println();
//        printSplited(l.split(5));
    }
}

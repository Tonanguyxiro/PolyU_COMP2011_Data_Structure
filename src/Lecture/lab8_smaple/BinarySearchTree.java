package Lecture.lab8_smaple;


import Lecture.lec4_sample.Queue;

import java.util.Scanner;

/**
 * 
 * @author yixin cao (October 20, 2020)
 *
 * Binary search tree.
 * 
 * Elements in a binary search tree need to be comparable. The standard practice 
 * is to require the class T to implement the {@link Comparable} interface. Then we 
 * can call {@code e1.compareTo(e2)} to compare elements e1 and e2, both of type T.
 * See more at
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html
 * 
 * To simplify our demonstration, we add an explicit variable key and use it for comparisons.
 * This is a very bad practice, and please never use it for programming.
 * 
 */
class Student {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String toString() {return id + ", " + name;}
}

/*
 * Binary search trees
 */
public class BinarySearchTree<T> {
    @SuppressWarnings("hiding")
    private class Node<T> {
        int key;  // bad practice; see comment above.
        T data;
        public Node<T> leftChild, rightChild;

        public Node(int key, T data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }

    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    // the recursive version of insert and its wrapper.
    public void recInsert(int key, T data) {
        Node<T> newNode = insert(root, key, data);
        if (root == null) root = newNode; 
    }
    private Node<T> insert (Node<T> curRoot, int key, T data) {
        if (curRoot == null) {
            Node<T> newNode = new Node<T>(key, data);
            curRoot = newNode;
            return curRoot;
        }
        if (key <= curRoot.key) curRoot.leftChild = insert(curRoot.leftChild, key, data);
        else curRoot.rightChild = insert(curRoot.rightChild, key, data);        
        return curRoot;
    }

    // the recursive version of preorder traversal and its wrapper.
    public void preorder() { preorder(root); }
    public void preorder(Node<T> curRoot) {
        if (curRoot == null) return;
        System.out.println(curRoot.data);
        preorder(curRoot.leftChild);
        preorder(curRoot.rightChild);
    }

    // the recursive version of inorder traversal and its wrapper.
    public void inorder() { inorder(root); }
    private void inorder(Node<T> curRoot) {
        if (curRoot == null) return;
        inorder(curRoot.leftChild);
        System.out.println(curRoot);
        inorder(curRoot.rightChild);
    }
    
    // the recursive version of postorder traversal and its wrapper.
    public void postorder() { postorder(root); }
    public void postorder(Node<T> curRoot) {
        if (curRoot == null) return;
        postorder(curRoot.leftChild);
        postorder(curRoot.rightChild);
        System.out.println(curRoot.data);
    }

    public void display() { inorder(root); }

    public boolean isEmpty() {    return root == null;   }
    public void deleteMin() {
        if (isEmpty()) { System.out.println("Oops..."); return; }
        root = deleteMin(root);
    }
    private Node<T> deleteMin(Node<T> x) {
        if (x.leftChild == null) return x.rightChild;
        x.leftChild = deleteMin(x.leftChild);
        return x;
    }

    // the recursive version of deletion and its wrapper.
    public void recDelete(int key) {
        if (isEmpty()) { System.out.println("Oops..."); return; }
        root = delete(root, key);
    }
    // the trick is on the returned node.
    private Node<T> delete(Node<T> x, int key) {
        if (x == null) return null;
        if (key < x.key) x.leftChild  = delete(x.leftChild, key);
        else if (key > x.key) x.rightChild = delete(x.rightChild, key);
        else {                      // x is the node to be deleted.
          if (x.rightChild == null) return x.leftChild;
          if (x.leftChild  == null) return x.rightChild;
          Node<T> t = x;
          x = recFindMin(t.rightChild);
          x.rightChild = deleteMin(t.rightChild);
          x.leftChild = t.leftChild;
        }
        return x;
      } 

      public static void main(String[] args) {
        BinarySearchTree<Student> tree = new BinarySearchTree<Student>();
        int[] ids = {214, 562, 83, 115, 97, 722, 398, 798, 408, 199, 37};
        String[] names = { "Chan Eason", "Cheung Jacky", "Winnie", "Ho Denise", "Mickey", "Leung Gigi", "Joey Yung", "Teddy", "Peppa", "Tse Kay", "Andy Lau"};
        for (int i = 0; i < 11; i++)
            tree.insert(ids[i], new Student(ids[i], names[i]));

        
        System.out.println("tree built.");
        tree.levelDisplay();
       // tree.display();

        System.out.println("==========search=========");
        System.out.println("199: " + tree.search(199));
        System.out.println("336: " + tree.search(336));

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number to search");
        System.out.println(tree.search(keyboard.nextInt()));

        System.out.println("Press enter to start insertion");
        keyboard.nextLine();keyboard.nextLine();
        System.out.println("inserting a new students.");
        tree.insert(336, new Student(336, "Yung Joey"));
        System.out.println("==========after insertion=========");
        tree.levelDisplay();
        System.out.println("336: " + tree.search(336));
        System.out.println("377: " + tree.search(377));
        System.out.println("Press enter to start deletion");
        keyboard.nextLine();
        tree.delete(798);
        System.out.println("==========after deleting 798=========");
        tree.levelDisplay();
        tree.delete(722);
        System.out.println("==========after deleting 722=========");
        tree.levelDisplay();
        System.out.println("Enter a number to search");
        System.out.println(tree.search(keyboard.nextInt()));
        keyboard.close();
    }

    // tasks for lab 8
    // try to write both recursive and iterative versions.
    public Node<T> findMin() {return findMin(root);}
    public Node<T> findMin(Node<T> node) {
        if (node == null) return null;
        while (node.leftChild != null)
            node = node.leftChild;
        return node;
        // or using recursion:
        // return (node.leftChild == null) node:findMin(node.leftChild);
    }

    public int recFindMin() {
        if (isEmpty()) { System.out.println("Oops..."); return -1; }
        return recFindMin(root).key;
    } 
    private Node<T> recFindMin(Node<T> x) { 
      if (x.leftChild == null) return x; 
      return recFindMin(x.leftChild); 
    } 
    

    public Node<T> findMax() {return findMax(root);}
    public Node<T> findMax(Node<T> node) {
        if (node == null) return null;
        while (node.rightChild != null)
            node = node.rightChild;
        return node;
        // or using recursion:
        // return (node.rightChild == null) node:findMax(node.rightChild);
    }
      
    // how to rewrite this with recursion?
    public Node<T> search(int key) {
        Node<T> cur = root;
        while (cur.key != key) {
            cur = (key < cur.key) ? cur.leftChild : cur.rightChild;
            if (cur == null)
                return null;
        }
        return cur;
    }


    // A recursive version is given above. 
    // Here you are asked to write the iterative version.
    // you're suggested to finish search() before this.
    public void insert(int key, T data) {
        Node<T> newNode = new Node<T>(key, data);
        if (root == null) {root = newNode; return;}
        Node<T> cur = root, parent = null;
        while (cur != null) {
            parent = cur; 
            if (key <= cur.key) {cur = cur.leftChild;}
            else {cur = cur.rightChild;}
        }
        if (key <= parent.key) {parent.leftChild = newNode;}
        else {parent.rightChild = newNode;}
    }
    
//    
    
    public Node<T> predecessor(Node<T> x) { 
        Node<T> result = null;
        if(x.leftChild != null) {
            result = x.leftChild;
            while(result.rightChild != null)
                result = result.rightChild;
        }
        else {
            result = root;
            Node<T> cur = root;
            while(cur != null && cur.key != x.key) {
                if(cur.key > x.key) {
                    cur = cur.leftChild;
                }
                else if(cur.key < x.key) {
                    result = cur;
                    cur = cur.rightChild;
                }
            }
        }
        return result;
    }

    public Node<T> successor(Node<T> x) { 
        Node<T> result = null;
        if(x.rightChild != null) {
            result = x.rightChild;
            while(result.leftChild != null) {
                result = result.leftChild;
            }
        }
        else {
            result = root;
            Node<T> cur = root;
            while(cur != null && cur.key != x.key) {
                if(cur.key > x.key) {
                    result = cur;
                    cur = cur.leftChild;
                }
                else if(cur.key < x.key) {
                    cur = cur.rightChild;
                }
            }
        }
        return result; 
    }    

    // Optional tasks
    public void levelDisplay() {
        // using comp2011.lec4.Queue
        Queue<Node<T>> queue = new Queue<Node<T>>();
        if (root == null)
            return;
        queue.enqueue(root);
        int thisLevel = 1, nextLevel = 0;
        while (!queue.isEmpty()) {
            Node<T> node = queue.dequeue();
            System.out.print(node.key + " ");
            if (node.leftChild != null) {
                queue.enqueue(node.leftChild);
                nextLevel++;
            }
            if (node.rightChild != null) {
                queue.enqueue(node.rightChild);
                nextLevel++;
            }
            if (--thisLevel == 0) {
                thisLevel = nextLevel;
                nextLevel = 0;
                System.out.print('\n');
            }
        }
    }
    // non-recursive version: very very very difficult; too many cases to consider.
    public boolean delete(int key) { 
    	boolean flag=false;
    	Node<T> cur= search(key);
    	if (cur!=null){
    		if(cur.key==root.key){
    			if (cur.leftChild == null && cur.rightChild == null) {
                    root = null;
                } else if (cur.leftChild != null && cur.rightChild == null) {
                    
                    root = cur.leftChild;
                } else if (cur.leftChild == null && cur.rightChild != null) {
                 
                    root = cur.rightChild;
                } else {
                    Node<T> succ = successor(cur);
                    Node<T> parent=findParent(succ);
                    if(succ.rightChild!=null){
                    	parent.leftChild=succ.rightChild;
                        
                      }
                    else {parent.leftChild=null;}
                    
                    succ.leftChild=root.leftChild;
                    succ.rightChild=root.rightChild;
                    root = succ;
                    
                }
    		}
    		else {
    			if (cur.leftChild == null && cur.rightChild == null) {
    				Node<T> parent=findParent(cur);
    				if (parent.leftChild==cur) parent.leftChild=null;
    				if(parent.rightChild==cur) parent.rightChild=null;
    		}
    			else if (cur.leftChild != null && cur.rightChild == null){
    				Node<T> parent=findParent(cur);
    				if (parent.leftChild==cur) parent.leftChild=cur.leftChild;
    				if (parent.rightChild==cur) parent.rightChild=cur.leftChild;
    			}
    			else if (cur.leftChild == null && cur.rightChild != null){
    				Node<T> parent=findParent(cur);
    				if (parent.leftChild==cur) parent.leftChild=cur.rightChild;
    				if (parent.rightChild==cur) parent.rightChild=cur.rightChild;
    			}
    			else{
    				Node<T> succ = successor(cur);
                    Node<T> parent1=findParent(succ);
                    Node<T> parent=findParent(cur);
                    if(cur==parent1){
                    	if(cur==parent.leftChild){
                    		parent.leftChild=succ;
                    		succ.leftChild=cur.leftChild;
                    	}
                    	if(cur==parent.rightChild){
                    		parent.rightChild=succ;
                    		succ.leftChild=cur.leftChild;
                    	}
                    }
                    else if(succ.rightChild!=null){
                    	parent1.leftChild=succ.rightChild;
                    	succ.leftChild=cur.leftChild;
                        succ.rightChild=cur.rightChild;
                        if (parent.leftChild==cur) parent.leftChild=succ;
        				if (parent.rightChild==cur) parent.rightChild=succ;
                        
                      }
                    else {
                    	parent1.leftChild=null;
                    	succ.leftChild=cur.leftChild;
                        succ.rightChild=cur.rightChild;
                        if (parent.leftChild==cur) parent.leftChild=succ;
        				if (parent.rightChild==cur) parent.rightChild=succ;
                    }
                    
                    
                    
    			}
    			
    	}
    		flag=true;
    	}
    	return flag;
   }
    
    

public Node<T> findParent(Node<T> x) {
    
    Node<T> cur = root;
    Node<T> parent = cur;
    while (cur != null && cur.key!=x.key) {
        
        parent = cur;
        if (cur.key>x.key) {
            cur = cur.leftChild;
        } else {
            cur = cur.rightChild;
        }
    }
    return parent;
}


    // Other easy exercises
    // the largest distance from the root to a leaf.
    public int height() {return -1;}
    // the number nodes in the tree.
    public int size() {return -1;}
    // the number of nodes having two children.
    public int fullNodes() {return -1;}
}



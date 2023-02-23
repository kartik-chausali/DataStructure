import java.util.*;
public class BinaryTree {
    
    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Scanner sc = new Scanner(System.in);    
        static int nodedata;
	static int leftdata;
	static int rightdata;
	static Node buildFromLevelOrder(Node root) {
		
	  Queue<Node> q = new LinkedList<>();
	  System.out.println("Enter the data for root");
	  nodedata = sc.nextInt();
	  root = new Node(nodedata);
	  q.add(root);
	  
	  while(!q.isEmpty()) {
		  Node temp = q.peek();
		  q.remove();
		  System.out.println("Enter for left of "+ temp.data);
		  leftdata = sc.nextInt();
		 
		  if(leftdata != -1) {
			  temp.left = new Node(leftdata);
			  q.add(temp.left);
		  }
		  
		  System.out.println("Enter for right of "+temp.data);
		  rightdata = sc.nextInt();
		  if(rightdata!=-1) {
			  temp.right = new Node(rightdata);
			  q.add(temp.right);
		  }
	  }
	  return root;
	}

    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    
    public static void main(String[] args) {
        Node root = null;
        root = buildFromLevelOrder(root);
        inorder(root);
    }
    
}

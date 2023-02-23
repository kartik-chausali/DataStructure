import java.util.Scanner;
import java.util.*;

public class BinarySearchTree {
   static class Node {
        public
        int data;
        Node left;
        Node right;

        public Node(){

        }

        public Node(int data){
                this.data = data;
                this.left = null;
                this.right = null;
        }

    }
    
    static class BSTIterator{

        Stack<Node> st = new Stack<>();
        public BSTIterator(Node root){
            pushAll(root);
        }

        int next(){
            Node temp = st.pop();
            pushAll(temp.right);
            return temp.data;
        }

        boolean hasNext(){
            return !st.isEmpty();
        }
        
        void pushAll(Node node){
           while(node!=null){
                st.push(node);
                node = node.left;
            }
        }
    }

    public static Node insertInBST(Node root, int data){
        
        if(root== null){
            root = new Node(data);
           return root;
        }

        if(data<root.data){
           root.left =  insertInBST(root.left, data);
        }else{
           root.right = insertInBST(root.right, data);
        }
        return root;
    }


    public static Node takeInput(Node root){

        int data;
        Scanner sc= new Scanner(System.in);
        data = sc.nextInt();

        while(data !=-1){
           root = insertInBST(root, data);
            data = sc.nextInt();
        }
        return root;
    }

    public static void levelOrder(Node root){  //10 8 21 7 27 5 4 3 2 -1
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp == null){
                System.out.println();
                if(!q.isEmpty()) q.add(null);
            }else{
                System.out.print(temp.data + " ");
                if(temp.left!=null)q.add(temp.left);
            if(temp.right != null)q.add(temp.right);
            }

            
        }
    }

    public static void Inorder(Node root){
        if(root == null)return;
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }   
    
    public static boolean Search(Node root , int val){
        if(root == null)return false;
        if(root.data == val)return true;

        if(val<root.data)return Search(root.left, val);
        else return Search(root.right, val);
    }

    public static List<Integer> InorderIteratively(Node root){
        ArrayList<Integer> inorderlist = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            inorderlist.add(root.data);
            root = root.right;
        }
        return inorderlist;
    }


    public static Node inorderSuccessor(Node root, int targetNode){
        Node successor = null;
        while(root != null){
            if(targetNode >= root.data){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static Node inorderPredecessor(Node root, int targetNode){
        Node predecessor = null;
        while(root!=null){
            if(targetNode <= root.data){
                root = root.left;
            }else{
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public static Node minVal(Node root){
        Node temp = root;
        while(temp.left!=null)temp = temp.left;
        return temp;
    }

    public static Node maxVal(Node root){
        Node temp = root;
        while(temp.right!= null)temp = temp.right;
        return temp;
    }
    public static Node deleteInBST(Node root, int nodeToDel){

        if(root == null)return null;

        if(root.data == nodeToDel){

            //0 child
            if(root.left == null &&  root .right == null)return null;

            //1 child
            if(root.left !=null && root.right == null){
                Node temp = root.left;
                return temp;
            }else if(root.left == null && root.right != null){
                Node temp = root.right;
                return temp;
            }else{ // 2 child
                int min = minVal(root.right).data;
                root.data = min;
                root.right = deleteInBST(root.right, min);
                return root;
            }

        }else if(nodeToDel<root.data){
            root.left = deleteInBST(root.left, nodeToDel);
        }else{
            root.right = deleteInBST(root.right, nodeToDel);
        }
        return root;
    }

    static int pre;
    static int succ;
    public static void PreSucRecursively(Node root, int key ){
        if(root == null)return;

        if(root.data == key){

            if(root.left != null){
                pre = maxVal(root.left).data;
            }
            if(root.right != null){
                succ = minVal(root.right).data;
            }

        }
        if(root.data > key){
            succ = root.data;
            PreSucRecursively(root, key);
        }else{
            pre = root.data;
            PreSucRecursively(root, key);
        }
    }

    public static void PreSucIteratively(Node root, int key){
        int pre = -1;
        int succ = -1;
        Node temp = root;

        //find key
        while(temp.data != key){

            if(temp.data<key){
                pre = temp.data;
                temp = temp.right;
            }else{
                succ = temp.data;
                temp = temp.left;
            }
        }

        //predecessor
        Node leftTree = temp.left;  //predecesssor of a node will be max element in its left subtree
        while(leftTree !=null){
            pre = leftTree.data;
            leftTree = leftTree.right;
        }

        //succ 
        Node rightTree = temp.right;  //successor of a node will be min element in its right subtree
        while(rightTree != null){
            succ = rightTree.data;
            rightTree = rightTree.right;
        }


    }

     public static void main(String[] args) {
     
        Node root = null;
        System.out.println("Enter data to create BST");
      root =  takeInput(root);
        levelOrder(root);
        System.out.println("Printing inorder");
        Inorder(root);
        System.out.println("Searching in BST");
        System.out.println( Search(root, 27));
        
        System.out.println(inorderSuccessor(root, 8).data);
        System.out.println(inorderPredecessor(root, 8).data);
        deleteInBST(root, 8);
        Inorder(root);
        System.out.println();
        // PreSucRecursively(root, 10);
        // System.out.println(pre + " " + succ);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());


    }


}

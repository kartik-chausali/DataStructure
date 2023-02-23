import java.util.*;

public abstract class mergeBST extends BinarySearchTree{


    public static Node convertInSortedDLL(Node root, Node head){
        if(root == null)return null;

        convertInSortedDLL(root.right, head);
        root.right = head;
        if(head!=null){
            head.left = root;
        }
        head = root;
        convertInSortedDLL(root.left, head);
        return head;
    }


    public static Node mergeLL(Node head1, Node head2){

        Node head = null;
        Node tail = null;

        
        while(head1!= null && head2!= null){

            if(head1.data < head2.data){
               
                if(head == null){
                    head = head1;
                    tail = head1;
                    head1 = head1.right;  
                }else{
                    tail.right = head1;
                    head1.left = tail;
                    tail = head1;
                    head1 = head1.right;
                    
                }

            }else{

                if(head == null){
                    head = head2;
                    tail = head2;
                    head1 = head2.right;  
                }else{
                    
                    tail.right = head2;
                    head2.left = tail;
                    tail = head2;
                    head2 = head2.right;
                }
            }
        }

        while(head1!=null){

            tail.right = head1;
            head1.left = tail;
            tail = head1;
            head1 = head1.right;    
        
        }

        while(head2!=null){
            tail.right = head2;
            head2.left = tail;
            tail = head2;
            head2 = head2.right;
        }

        return head;
    }


    static int countNodes(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            temp = temp.right;
        }
        return cnt;
    }


    public static Node sortedDLLtoBST(Node head, int n){

        if(n<=0 || head == null)return null;

       Node Left =  sortedDLLtoBST(head, n/2);

       Node root = head;

       root.left = Left;

       head = head.right;

       Node Right = sortedDLLtoBST(head, n-n/2-1);
       root.right = Right;

       return root;

        
    }


    public static void main(String[] args) {
        
        Node root1 = null;
        System.out.println("Enter data for 1st BST");
        root1 = takeInput(root1);
        
        Node root2 = null;
        System.out.println("Enter data for 2nd BST");
        root2 = takeInput(root2);

        //Step 1 : convert BST to sorted Doubly Linked LIst in-place
        Node head1 = null;
       head1 = convertInSortedDLL(root1, head1);
        head1.left = null;
        

        Node head2 = null;
        head2 = convertInSortedDLL(root2, head2);
        head2.left = null;

        //Step 2: merge both sorted DLL

        Node head = mergeLL(head1, head2);

        //Step 3 : sorted LL to BST

        Node root = sortedDLLtoBST(head, countNodes(head));
        levelOrder(root);

    }
}

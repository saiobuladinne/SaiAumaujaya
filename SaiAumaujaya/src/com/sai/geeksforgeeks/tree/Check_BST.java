package com.sai.geeksforgeeks.tree;

import java.util.Scanner;
import java.lang.Integer;
import java.util.HashMap;
// A Binary Search Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Check_BST
{
	/*void printInorder(Node node)
    {
        if (node == null)
            return;
        /* first recur on left child */
        //printInorder(node.left);
        /* then print the data of node */
       // System.out.print(node.data + " ");
        /* now recur on right child */
        //printInorder(node.right);
    //}*/
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		Check_BST ob = new Check_BST();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
			
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
			GfG g = new GfG();
            System.out.println(g.isBST(root));
			//ob.printInorder(root);
            t--;
			
        }
    }
}

class GfG
{
    int MIN=Integer.MIN_VALUE;
    int MAX=Integer.MAX_VALUE;
    
    int isBST(Node root)  
    {
       boolean isBst = checkBST(root,MIN,MAX);
       if(isBst){
           return 1;
       }else{
           return 0;
       }
    }
    
    boolean checkBST(Node root, int MIN, int MAX){
        if(root ==null){
            return true;
        }
        if(root.data<MIN || root.data>MAX){
            return false;
        }
        return checkBST(root.left,MIN,root.data-1) && checkBST(root.right,root.data+1,MAX);
    }
    
}
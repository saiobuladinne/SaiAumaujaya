package com.sai.geeksforgeeks.tree;

import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Binary_Tree_Diameter
{
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
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
            Binary_Tree_Diam g = new Binary_Tree_Diam();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}

class Binary_Tree_Diam
{
   /* Complete the function to get diameter of a binary tree */
    int diameter(Node node)
    {
        if(node==null){
            return 0;
        }
        int rightHeight= getHeightOfBothSides(node.right);
        int leftHeight=  getHeightOfBothSides(node.left);
        return rightHeight + 1 + leftHeight;
    }
    
    int getHeightOfBothSides(Node root){
        int h=0;
        if(root==null)        {
            return 0;
        }
        int leftHeight=getHeightOfBothSides(root.left);
        int rightHeight=getHeightOfBothSides(root.right);
        if(leftHeight>rightHeight){
            h= 1+leftHeight;
        }else{
            h= 1+rightHeight;
        }
        return h;
    }
    
}


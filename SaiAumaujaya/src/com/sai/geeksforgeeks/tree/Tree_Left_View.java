package com.sai.geeksforgeeks.tree;

import java.util.Scanner;
import java.lang.Integer;
import java.util.HashMap;
//import java.lang.Math;
// A Binary Tree node
class Tree_Left_View
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
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
            TreeLeftView g = new TreeLeftView();
			g.leftView(root);
			System.out.println();
         t--;	
        }
    }
}

class TreeLeftView
{
    int maxLevel=0;
    void leftView(Node root)
    {
       getLeftView(root,maxLevel);
    }
    void getLeftView(Node node,int level){
        if(node==null){
            return;
        }
        if(level>= maxLevel){
            System.out.print(node.data+" ");
            maxLevel++;
        }
        getLeftView(node.left,level+1);
        getLeftView(node.right,level+1);
    }
}

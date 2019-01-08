package com.sai.geeksforgeeks.tree;

import java.util.HashMap;
import java.util.Scanner;
import com.sai.geeksforgeeks.tree.Node;

public class Determine_if_two_trees_are_identical {
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
				
				//sec tree
				
				 HashMap<Integer, Node> mm = new HashMap<Integer, Node> ();
	            int nn = sc.nextInt();
	            Node roott = null;
	            while (nn > 0)
	            {
	                int n1 = sc.nextInt();
	                int n2 = sc.nextInt();
	                char lr = sc.next().charAt(0);
	                
	                Node parent = mm.get(n1);
	                if (parent == null)
	                {
	                    parent = new Node(n1);
	                    mm.put(n1, parent);
	                    if (roott == null)
	                        roott = parent;
	                }
	                Node child = new Node(n2);
	                if (lr == 'L')
	                    parent.left = child;
	                else
	                    parent.right = child;
	                mm.put(n2, child);
	                nn--;
	            }
	            DetermineIfIdentical g = new DetermineIfIdentical();
	            //System.out.println(g.isIdentical(root,roott));
				
				boolean b = g.isIdentical(root,roott);
				if(b==true)
					System.out.println(1);
				else
					System.out.println(0);
	            t--;
	        }
	    }
	}

class DetermineIfIdentical {
	/*
	 * Should return true if trees with roots as root1 and root2 are identical else
	 * false
	 */
	boolean isIdentical(Node root1, Node root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if ((root1 == null && root2 != null) || root1 != null && root2 == null) {
			return false;
		}
		if(root1!=null && root2!=null && root1.data!=root2.data) {
			return false;
		}
		if (!isIdentical(root1.left, root2.left) || !isIdentical(root1.right, root2.right)) {
			return false;
		}
		return true;
	}

}

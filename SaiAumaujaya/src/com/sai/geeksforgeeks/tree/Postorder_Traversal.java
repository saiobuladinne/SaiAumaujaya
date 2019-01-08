package com.sai.geeksforgeeks.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Postorder_Traversal {
	 // driver function to test the above functions
    public static void main(String args[]) throws IOException
    {
        // Input the number of test cases you want to run
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int t = sc.nextInt();
        int t= Integer.parseInt(br.readLine());
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            //int n = sc.nextInt();
            int n = Integer.parseInt(br.readLine());
            //System.out.println(n);
            Node root = null;
            String nums[] = br.readLine().split(" ");
            //System.out.print(nums.length/3);
            int mm = n;
            for( int idx = 0; idx < mm; idx++)
            {
                //int n1 = sc.nextInt();
                //int n2 = sc.nextInt();
                //char lr = sc.next().charAt(0);
                int n1 = Integer.parseInt(nums[idx*3]);
                int n2 = Integer.parseInt(nums[idx*3+1]);
                //char lr = (char)nums[idx*3+2];
                String lr = nums[idx*3+2];
                //System.out.print(n1+" "+n2+" "+lr+ " ");
                
                
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
                if (lr.equals("L"))
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
            }
            //System.out.println();
            PostOrder g = new PostOrder();
            g.postOrder(root);
            System.out.print("");
            t--;
        }
    
    br.close();
    
    }
    
}
class PostOrder
{
    void postOrder(Node root)
    {
    	if(root==null) {
    		return;
    	}
    	postOrder(root.left);
    	postOrder(root.right);
    	System.out.print(root.data+" ");
    }
}

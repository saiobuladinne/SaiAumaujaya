package com.sai.geeksforgeeks.tree;

import java.util.HashMap;
import java.util.Scanner;
class NodeCount
{
    int data;
    NodeCount left,right;
    NodeCount(int d) {data = d; left =right= null; }
}
public class Count_Number_of_SubTrees_having_given_Sum
{
    public static NodeCount target;
    Count_Number_of_SubTrees_having_given_Sum(){
        target=null;
    }
	public static void inorder(NodeCount root,int key)
	{
	    if(root==null)
	    return;
	    inorder(root.left,key);
	    if(root.data==key)
	    target=root;
	    inorder(root.right,key);
	}
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-->0)
         {
			int n = sc.nextInt();
			Count_Number_of_SubTrees_having_given_Sum llist=new Count_Number_of_SubTrees_having_given_Sum();
			NodeCount root=null,parent=null;
			HashMap<Integer, NodeCount> m = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                char c=sc.next().charAt(0);
                if(m.containsKey(a)==false)
                {
                    parent=new NodeCount(a);
                    m.put(a,parent);
                    if(root==null)
                    root=parent;
                }
                else
                    parent=m.get(a);
                NodeCount child=new NodeCount(b);
                if(c=='L')
                parent.left=child;
                else
                parent.right=child;
                m.put(b,child);
            }
            int x=sc.nextInt();
            CountSubTrees obj = new CountSubTrees();
            System.out.println(obj.countSubtreesWithSumX(root,x));
		}
	}
}
class CountSubTrees
{
	int counter=0;
	int sum=0;
    int countSubtreesWithSumX(NodeCount root, int x)
    {
    	IsCountX(root,x);
		return counter;
    }

	private int IsCountX(NodeCount node, int x) {

		if(node==null) {
			return 0;
		}
		if(node.left==null && node.right==null && node.data==x) {
			counter++;
			return node.data;
		}
		
		int leftSum= IsCountX(node.left,x);
		int rightSum = IsCountX(node.right,x);
		sum = leftSum+rightSum+node.data;
		if(sum==x) {
			counter++;
			return sum;
		}
		return sum;
	}
}

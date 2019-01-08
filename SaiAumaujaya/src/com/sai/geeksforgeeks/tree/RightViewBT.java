package com.sai.geeksforgeeks.tree;

import java.util.Scanner;

class RightViewBT{
	public static void insert(TreeNode root,int n1,int n2,char lr){
		if(root==null)
			return;
		if(root.data==n1){
		switch(lr)
					{
						case 'L':
						root.left=new TreeNode(n2);
						break;
						case 'R':
						root.right=new TreeNode(n2);
						break;
					}
		}
		else{
			insert(root.left,n1,n2,lr);
			insert(root.right,n1,n2,lr);
		}
	}
	public static void main(String[] args)
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{	int n=Integer.parseInt(sc.next());
			TreeNode root=null;
			if(n==1)
			{
				int a=sc.nextInt();
				System.out.println(a);
				continue;
			}
			else
			{	
		while(n-->0){
				int n1=Integer.parseInt(sc.next());
				int n2=Integer.parseInt(sc.next());
				char lr=sc.next().charAt(0);
				if(root==null)
				{
					root=new TreeNode(n1);
					switch(lr)
					{
						case 'L':
						root.left=new TreeNode(n2);
						break;
						case 'R':
						root.right=new TreeNode(n2);
						break;
					}
				}
				else{
					insert(root,n1,n2,lr);
				}
			}
			}
			RightView tree = new RightView();
        tree.rightView(root);
		System.out.println();
			
    }
	}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete The Function Provided
Given Below is The Node Of Tree*/
class TreeNode
{
    int data;
    TreeNode left, right;
    public TreeNode(int data)
    {
        this.data = data;
         left = right = null;
    }
}
class RightView{
    int maxLevel=0;
    void rightView(TreeNode node) {
        
        getRightView(node, maxLevel);
    }
    void getRightView(TreeNode node,int level) {
        if(node==null){
            return;
        }
        if(level>=maxLevel){
            System.out.print(node.data+" ");
            maxLevel++;
        }
        getRightView(node.right,level+1);
        getRightView(node.left,level+1);
    }
}


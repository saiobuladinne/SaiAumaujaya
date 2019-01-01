package com.sai.codility;
class Tree {
	  public int x;
	  public Tree l;
	  public Tree r;
	}
public class HeightOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int solution(Tree node) {
		int h=0;
		if(node==null) {
			return -1;
		}
			int leftHeight = solution(node.l);
			int rightHeight = solution(node.r);
		if(leftHeight>rightHeight) {
			h=1+leftHeight;
		}else {
			h=1+rightHeight;
		}
		return h;
	}
}

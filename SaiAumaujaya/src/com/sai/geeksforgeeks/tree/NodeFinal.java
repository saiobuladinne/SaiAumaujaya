package com.sai.geeksforgeeks.tree;


public class NodeFinal {
	int key;
	String name;
	NodeFinal leftChild;
	NodeFinal rightChild;
	
	NodeFinal(int key, String name){
		this.key = key;
		this.name = name;
	}
	
	public String toString() {
		return name+" has key "+key;
	}
}

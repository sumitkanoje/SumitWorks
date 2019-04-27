package com.learn.ds;



public class BST {

	static class Node{
		Node left;
		Node right;
		int data;
		
		Node(int d){
			data = d;
		}
	}
	public static void insert(Node root, Node inserting) {
		if(root==null)
			root = inserting;
		else {
			if(root.data<inserting.data) {
				if(root.right==null)
					root.right = inserting;
				else
					insert(root.right,inserting);
			}
			if(root.data>inserting.data) {
				if(root.left==null)
					root.left = inserting;
				else
					insert(root.left,inserting);
			}
				
		}
	}
	static void printTree(Node root) {
		if(root!=null) {
			printTree(root.left);
			System.out.print(root.data+" ");
			printTree(root.right);
		}
	}
	private static Node minOfRightSubTree(Node root) {
		if(root.left==null && root.right==null)
			return root;
		if(root.left==null)
			return minOfRightSubTree(root.right);
		else
			return minOfRightSubTree(root.left);
			
	}
	private static Node delete(Node root, int value) {
		if(root==null)
			return null;
		if(value>root.data)
			root.right = delete(root.right, value);
		else if(value<root.data)
			root.left = delete(root.left, value);
		else {
			if(root.left==null && root.right==null)
				root = null;
			else if(root.left!=null && root.right==null)
				root = root.left;
			else if(root.right!=null && root.left==null)
				root = root.right;
			else{
				Node temp = root;
				Node minOfRightSubTree = minOfRightSubTree(temp.right);
				root.data = minOfRightSubTree.data;
				delete(root.right, minOfRightSubTree.data);
			}
			
		}
		return root;
	}
	public static void main(String[] args) {
		
		Node root  = createBST();
		
		printTree(root);
		
		delete(root,5);
		System.out.println();
		printTree(root);
		
		delete(root,35);
		System.out.println();
		printTree(root);
		
		delete(root,40);
		System.out.println();
		printTree(root);
		
	}
	private static Node createBST() {
		Node root = new Node(40);
		
		insert(null,new Node(40));
		insert(root,new Node(20));
		insert(root,new Node(10));
		insert(root,new Node(30));
		insert(root,new Node(60));
		insert(root,new Node(50));
		insert(root,new Node(70));
		insert(root,new Node(05));
		insert(root,new Node(13));
		insert(root,new Node(55));
		insert(root,new Node(35));
		
		return root;
	}
}

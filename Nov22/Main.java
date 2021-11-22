[23:45, 22/11/2021] Abu Yafoor: import java.util.*;

class Node
{
	int data;
	Node left,right;
	Node(int data)
	{
		this.data=data;
		left=null;right=null;
	}
}
class BinaryTree
{
	void printOnlyLeafNodes(Node root)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
		{

			System.out.print(root.data+" ");
			return;
		}
		printOnlyLeafNodes(root.left);
		printOnlyLeafNodes(root.right);
	}

	void preOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	void postOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		postOrder(root.left);
		System.out.print(root.data+" ");
		postOrder(root.right);
	}
	void inOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		inOrder(root.left);
		inOrder(root.right);
		System.out.print(root.data+" ");

	}
	int nodeCount(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		return 1+nodeCount(root.left)+nodeCount(root.right);
	}
	int sumOfAllNodes(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		
		return root.data+ sumOfAllNodes(root.left)+sumOfAllNodes(root.right);
		
		
	}
	int heightOfBinaryTree(Node root)
	{
		if(root==null)
		{
			return -1;
		}
		return 1+ Math.max( heightOfBinaryTree(root.left),
		heightOfBinaryTree(root.right));
		
	}
}
public class Main
{
	public static void main(String[] args)
	{
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(7);
		root.right.right=new Node(8);
       
		System.out.println("Binary Tree = 1,2,3,4,5,7,8");
		BinaryTree bT= new BinaryTree();
        System.out.print("preOrder= ");
		bT.preOrder(root);
		System.out.println();
		System.out.print("postOrder= ");
		bT.postOrder(root);
		System.out.println();
		System.out.print("Inorder= ");
		bT.inOrder(root);
		System.out.println();
		System.out.print("Nodes Count= ");
		System.out.println(bT.nodeCount(root));
		
		System.out.print("Only leaf nodes= ");
		bT.printOnlyLeafNodes(root);
		System.out.println();
		System.out.println("Sum Of All Nodes="+bT.sumOfAllNodes(root));
		System.out.println("Height of Binary Tree="+bT.heightOfBinaryTree(root));
	}
}

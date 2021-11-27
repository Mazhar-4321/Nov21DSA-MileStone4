import java.util.*;

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
    static int p=0,max_so_far=0;
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
    void leftView(Node root,int current_level)
    {
        if(root==null){return;}
        if(current_level>=max_so_far)
        {
            System.out.print(root.data+" ");
            max_so_far++;
        }
        leftView(root.left,current_level+1);
        leftView(root.right,current_level+1);
    }
    void rightView(Node root,int current_level) // 2 . RIGHT VIEW USING RECURSION
    {
        if(root==null){return;}
        if(current_level>=max_so_far)
        {
            System.out.print(root.data+" ");
            max_so_far++;
        }
        rightView(root.right,current_level+1);
        rightView(root.left,current_level+1);
    }

    void printKthLevelElements(Node root,int current_level) // 1. print kth Level
    {
        if(root==null)
        {
            return;
        }
        if(current_level==0)
        {
            System.out.print(root.data+" ");
            //max_so_far++;
        }
        printKthLevelElements(root.left,current_level-1);
        printKthLevelElements(root.right,current_level-1);
    }
    void levelOrderRecursive(Node root) // 3 . LEVEL ORDER RECURSION
    {
        int height=heightOfBinaryTree(root);
        for(int i=0;i<=height;i++)
        {
            printKthLevelElements(root,i);
            System.out.println();
        }
    }
    void levelOrderIterative(Node root)//3.LEVEL ORDER ITERATION
    {
        Queue<Node> queue= new LinkedList();

        ArrayList<Integer> aL= new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node front=queue.poll();
            System.out.print(front.data+" ");
            aL.add(front.data);
            if(front.left!=null)
            {
                queue.add(front.left);
            }
            if(front.right!=null)
            {
                queue.add(front.right);
            }
        }

    }
    double getAverageAtKthLevel(Node root,int current_level)
    {
        if(root==null)
        {
            return 0.0;
        }
        if(current_level==0)
        {
            return root.data;
            //max_so_far++;
        }
        return 	((getAverageAtKthLevel(root.left,current_level-1)+
                getAverageAtKthLevel(root.right,current_level-1))/2);

    }
    double[] averageAtEachLevel(Node root) //5. AVERAGE OF LEVELS
    {
        int height=heightOfBinaryTree(root);
        double average[]=new double[height+1];
        for(int i=0;i<=height;i++)
        {
            average[i]= getAverageAtKthLevel(root,i);
        }
        return average;
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
    boolean pathSum(Node root,int k)//4.PATH SUM
    {
        if(root==null)
        {
            return false;
        }
        if(root.data==k&&root.left==null&&root.right==null)
        {
            return true;
        }
        return pathSum(root.left,k-root.data)||pathSum(root.right,k-root.data);
    }
    String onlyLeafNodes(Node root)
    {
        if(root==null)
            return "";
        if(root.left==null&&root.right==null)
        {

            //System.out.print(root.data+" ");
            return root.data+"#";
        }
        return onlyLeafNodes(root.left)+
                onlyLeafNodes(root.right);

    }
    boolean leafSimiliarTrees(Node root1,Node root2) //6. LEAF SIMILIAR TREES
    {
        return (onlyLeafNodes(root1).equals(onlyLeafNodes(root2)));



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
        
        System.out.print("Path Sum=");
        System.out.println(bT.pathSum(root,142));
        System.out.println("Print Kth Level Elements=");
        bT.printKthLevelElements(root,2);
        //root.right.right.right=new Node(786);
        System.out.println("left View=");
        bT.leftView(root,0);
        System.out.println("Right View=");
        bT.max_so_far=0;
        bT.rightView(root,0);
        System.out.println("Level Order=");
        bT.levelOrderRecursive(root);
        System.out.println("Level Order Iterative=");
        bT.levelOrderIterative(root);
        System.out.println("Average At Each Level=");
        for(double x: bT.averageAtEachLevel(root))
        {
            System.out.print(x+" ");
        }
    }
}

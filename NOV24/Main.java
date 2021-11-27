

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
class BinarySearchTree
{
    Node root;
    Node lowestCommonAncestor(Node root,int e1,int e2) //2.lowest common ancestor
    {

            if (root == null) {
                return null;
            }
            Node leftNode = lowestCommonAncestor(root.left, e1, e2);
            Node rightNode = lowestCommonAncestor(root.right, e1, e2);

                if ((leftNode == null && rightNode == null) && (root.data == e1 || root.data == e2)) {
                    return root;
                }

                if ((leftNode!=null&&rightNode!=null)){
                        if((leftNode.data == e1 && rightNode.data == e2) || (rightNode.data == e1 && leftNode.data == e2))
                    return root;
                }
                    if ((leftNode!=null)) {
                        return leftNode;
                    }
                    if (rightNode!=null)
                        return rightNode;




            return null;



    }
    Node sortedArrayToBinarySearchTree(int arr[])//5.sorted binary search tree
    {
        int m=(arr.length-1)/2;
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(arr[m]);
        for(int i=0;i<arr.length;i++)
        {
            if(i==m)
                continue;
            bst.insert(arr[i]);
        }
        return bst.root;
    }
    int rangeSum(Node root,int low,int high) //1.range sum
    {
        if(root==null)
        {
            return 0;
        }
        if(root.data>=low&&root.data<=high)
        {
            //System.out.println(root.data);
            return root.data+rangeSum(root.left,low,high)+
                    rangeSum(root.right,low,high);
        }
        return rangeSum(root.left,low,high)+
                rangeSum(root.right,low,high);

    }
    Node searchBST(Node root,int val)//4.search in a bst
    {
        if(root==null)
        {
            return null;
        }
        if(val==root.data)
        {
            return root;
        }
        if(val>root.data)
        {
            return searchBST(root.right,val);
        }
        else
            return searchBST(root.left,val);
    }
    boolean twoSumBinaryTree(Node root,int k)//3.two sum
    {
        return preOrder(root,k);
    }
    boolean preOrder(Node root,int k)
    {
        if(root==null)
        {
            return false;
        }

        //checkSum(root,root,k-root.data);
        preOrder(root.left,k);
        preOrder(root.right,k);
        return checkSum(root,root,k-root.data);
    }
    boolean checkSum(Node root,Node left_right,int k)
    {
        if(root==null)
            return false;
        if(root.data==k&&root!=left_right)
        {
            return true;
        }

        return k>root.data? checkSum(root.right,left_right,k):
                checkSum(root.left,left_right,k);
    }
    void insert(int data)
    {
        Node newNode=new Node(data);
        if( root==null)
        {
            root=newNode;
            return;
        }
        insert(root,newNode);
    }
    void traverse(Node root)
    {
        if(root==null)
        {
            return;
        }
        traverse(root.left);
        System.out.print(root.data+" " );
        traverse(root.right);
    }
    void delete(Node root,int data)
    {
        if(root==null)
        {
            return;
        }
        if(root.data==data)
        {
            deleteRoot(root);
        }
        if(root.left!=null&& root.left.data==data)
        {
            deleteLeftLink(root);
        }
        if(root.right!=null&& root.right.data==data)
        {
            deleteRightLink(root);
        }
        delete(root.left,data);
        delete(root.right,data);

    }
    private void deleteRoot(Node root1)
    {
        Node rightNode=root1.right;
        Node leftNode=root1.left;
        root=rightNode;
        preOrderSuccessor(root).left=leftNode;
    }
    private void deleteLeftLink(Node root)
    {
        try
        {
            Node rightNode=root.left.right;
            root.left=root.left.left;
            //System.out.println("Inorder Successor of"+root.left+"is:");
            inOrderSuccessor(root.left).right=rightNode;
        }
        catch(Exception e)
        {

        }
    }
    private Node preOrderSuccessor(Node node)
    {
        if(node==null)
        {
            return null;
        }
        Node leftNode=preOrderSuccessor(node.left);
        Node rightNode=preOrderSuccessor(node.right);
        if((leftNode==null&&rightNode==null))
        {
            return node;
        }
        if(leftNode!=null&&rightNode!=null)
        {
            if(leftNode.data<rightNode.data&&leftNode.data<node.data)
            {
                return leftNode;
            }
            if(rightNode.data<leftNode.data&&rightNode.data<node.data)
            {
                return rightNode;
            }
            return node;
        }
        if(leftNode==null)
        {
            if(rightNode.data<node.data)
            {
                return rightNode ;
            }
            return node;
        }
        if(rightNode==null)
        {
            if(leftNode.data<node.data)
            {
                return leftNode;
            }
            return node;
        }
        return node;
    }
    private Node inOrderSuccessor(Node node)
    {
        if(node==null)
        {
            return null;
        }
        Node leftNode=inOrderSuccessor(node.left);
        Node rightNode=inOrderSuccessor(node.right);

        if((leftNode==null&&rightNode==null))
        {
            return node;
        }
        if(leftNode!=null&&rightNode!=null)
        {
            if(leftNode.data>rightNode.data&&leftNode.data>node.data)
            {
                return leftNode;
            }
            if(rightNode.data>leftNode.data&&rightNode.data>node.data)
            {
                return rightNode;
            }
            return node;
        }
        if(leftNode==null)
        {
            if(rightNode.data>node.data)
            {
                return rightNode ;
            }
            return node;
        }
        if(rightNode==null)
        {
            if(leftNode.data>node.data)
            {
                return leftNode;
            }
            return node;
        }
        return node;
    }
    private void deleteRightLink(Node root)
    {
        try
        {
            Node leftNode=root.right.left;
            root.right=root.right.right;
            preOrderSuccessor(root.right).left=leftNode;
        }
        catch(Exception e){}
    }
    private void insert(Node root,Node newNode)
    {
        if(root==null)
        {
            return;
        }
        if(newNode.data>root.data&&root.right==null)
        {
            root.right=newNode;
            return;
        }
        if(newNode.data<root.data&&root.left==null)
        {
            root.left=newNode;
            return;
        }

        if(newNode.data>root.data)
        {
            insert(root.right,newNode);
        }
        else
        {
            insert(root.left,newNode);
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        BinarySearchTree bst=new BinarySearchTree();
        int arr[]=new int[]{4,2,7,1,3};
        for(int x:arr)
        {
            bst.insert(x);
        }
        System.out.println(bst.rangeSum(bst.root,6,10));
        System.out.println(bst.twoSumBinaryTree(bst.root,9));
        System.out.println();
        bst.traverse(bst.searchBST(bst.root,2));
        System.out.println(bst.lowestCommonAncestor(bst.root,1,7).data);

    }

}

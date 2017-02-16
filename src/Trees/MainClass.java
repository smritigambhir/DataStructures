package Trees;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.right=new Node(6);
		int path[]=new int[1000];
		//Node root2=root;
		int[] inOrder=new int[]{4,2,5,1,6,3};
		int[] preOrder=new int[]{1,2,4,5,3,6};
		Node2 root2=new Node2(1);
		root2.left=new Node2(2);
		root2.right=new Node2(3);
		root2.left.left=new Node2(4);
		root2.left.right=new Node2(5);
		root2.right.right=new Node2(6);
		
		Traversals t=new Traversals();
		Problems p=new Problems();
		
		//t.levelOrderByLevel(root);
		//System.out.println(t.height(root));
		//t.levelOrder_rec(root);
		//t.inOrderIter(root);
		//System.out.println(p.size(root));
		//System.out.println(p.isIdentical(root, root2));
		//p.printPathsRootToLeaf(root, path, 0);
		//t.levelOrderByLevelSpiral(root);
		//System.out.println(p.diameter(root));
		//System.out.println(p.hasPathSum(root, 10));
		//System.out.println(p.hasPathSum(root, 100));
		//System.out.println(p.maxWidth(root));
		//Node temp=p.buildTreeFromInorderPreorder(inOrder, preOrder, 0, inOrder.length-1);
		//t.inOrderIter(temp);
		//p.buildDoubleTree(root);
		//t.inOrderIter(root);
		//p.mirror(root);
		//t.inOrderIter(root);
		//System.out.println(p.isFoldable(root));
		//p.printNodeLevel(root, 1, 2);
		//p.printAncestors(root, 5);
		//p.populateInorderSuccessor(root2);
		//System.out.println(p.maxSumRoot2Leaf(root, 0));
		//p.treeToSumTree(root);
		//t.inOrderIter(root);
		//p.verticalSum(root);
		int[] inOrder2=new int[]{5, 10, 40, 30, 28};
		Node x=p.buildSpecialTreeFromInorder(inOrder2, 0, 4);
		t.inOrderIter(x);
	}

}

package Trees;

import java.util.HashMap;
import java.util.LinkedList;

public class Problems {
	
	static int preIndex=0;
	
	public int size(Node root){
		if(root==null)
			return 0;
		return 1+size(root.left)+size(root.right);
	}
	
	public boolean isIdentical(Node node1,Node node2){
		if(node1==null && node2==null)
			return true;
		if(node1==null && node2!=null)
			return false;
		if(node2==null && node1!=null)
			return false;
		return ((node1.val==node2.val) && isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right)); 
	}
	
	public void printArray(int[] path,int pathlen){
		for(int i=0;i<pathlen;i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	
	public void printPathsRootToLeaf(Node root, int []path, int pathlen){
		if(root==null)
			return;
		path[pathlen]=root.val;
		pathlen++;
		if(root.left==null && root.right==null)
			printArray(path,pathlen);
		else{
			printPathsRootToLeaf(root.left,path,pathlen);
			printPathsRootToLeaf(root.right,path,pathlen);
		}
	}
	
	public int height(Node root){
		if(root==null)
			return 0;
		int lh=height(root.left);
		int rh=height(root.right);
		return 1+(lh>rh?lh:rh);
	}
	
	public int diameter(Node root){
		if(root==null)
				return 0;
		int lh=height(root.left);
		int rh=height(root.right);
		return Math.max(lh+rh+1, Math.max(diameter(root.left),diameter(root.right)));
	}
	
	public boolean hasPathSum(Node root,int sum){
		if(root==null)
			return (sum==0);
		if(sum<root.val)
			return false;
		if(sum==0 && root.left==null && root.right==null)
			return true;
		return (hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val));
	}
	
	public int maxWidth(Node root){
		LinkedList<Node> q=new LinkedList();
		q.addLast(root);
		q.addLast(null);
		int level=1;
		int maxwidth=-1;
		int width=0;
		while(!q.isEmpty()){
			Node temp=q.removeFirst();
			width++;
			if(temp==null){
				if(q.isEmpty())
					break;
				q.addLast(null);
				level++;
				if(width>maxwidth)
					maxwidth=width;
				width=0;
				continue;
			}
			if(temp.left!=null)
				q.addLast(temp.left);
			if(temp.right!=null)
				q.addLast(temp.right);
		}
		return maxwidth;
	}
	
	public void treeToChildSumTree(Node root){
		
	}
	
	public int search(int key,int[] arr,int start,int end){
		for(int i=start;i<=end;i++){
			if(arr[i]==key)
				return i;
		}
		return -1;
	}
	
	
	public Node buildTreeFromInorderPreorder(int[] inOrder,int[] preOrder,int inStart,int inEnd){
		if(inStart>inEnd)
			return null;
		Node root=new Node(preOrder[preIndex++]);
		if(inStart==inEnd)
			return root;
		int inIndex=search(root.val,inOrder,inStart,inEnd);
		root.left=buildTreeFromInorderPreorder(inOrder,preOrder,inStart,inIndex-1);
		root.right=buildTreeFromInorderPreorder(inOrder,preOrder,inIndex+1,inEnd);
		return root;
	}
	
	public void buildDoubleTree(Node root){
		if(root==null)
			return;
		Node left;
		buildDoubleTree(root.left);
		buildDoubleTree(root.right);
		left=root.left;
		root.left=new Node(root.val);
		root.left.left=left;
	}
	
	public void mirror(Node root){
		if(root==null)
			return;
		Node temp=root.left;
		root.left=root.right;
		root.right=temp;
		mirror(root.left);
		mirror(root.right);
	}
	
	public boolean isFoldableUtil(Node a,Node b){
		if(a==null && b==null)
			return true;
		if(a==null||b==null)
			return false;
		return (isFoldableUtil(a.left,b.right) && isFoldableUtil(a.right,b.left));
	}
	
	public boolean isFoldable(Node root){
		if(root==null)
			return true;
		return isFoldableUtil(root.left,root.right);
	}
	
	public void printNodeLevel(Node root,int level,int key){
		if(root==null)
			return;
		if(root.val==key)
			System.out.println(key+" is at level "+level);
		printNodeLevel(root.left,level+1,key);
		printNodeLevel(root.right,level+1,key);
	}
	
	public boolean printAncestors(Node root,int a){
		if(root==null)
			return false;
		if(root.val==a)
			return true;
		if(printAncestors(root.left,a)||printAncestors(root.right,a)){
			System.out.print(root.val+" ");
			return true;
		}
		return false;	
	}
	
	static Node2 next=null;
	public void populateInorderSuccessor(Node2 root){
		if(root==null)
			return;
		populateInorderSuccessor(root.right);
		root.nextInorder=next;
		next=root;
		populateInorderSuccessor(root.left);
	}
	
	static int maxSum=0;
	public int maxSumRoot2Leaf(Node root,int currSum){
		if(root==null)
			return 0;
		currSum=currSum+root.val;
		if(root.left==null && root.right==null)
			if(maxSum<currSum)
				maxSum=currSum;
		maxSumRoot2Leaf(root.left,currSum);
		maxSumRoot2Leaf(root.right,currSum);
		return maxSum;
	}
	
	public int sum(Node root){
		if(root==null)
			return 0;
		return root.val+sum(root.left)+sum(root.right);
	}
	
	//GOOD
	public int treeToSumTree(Node root){
		if(root==null)
			return 0;
		int oldVal=root.val;
		root.val=treeToSumTree(root.left)+treeToSumTree(root.right);
		return root.val+oldVal;
	}
	
	public void verticalSumUtil(Node root,HashMap<Integer,Integer> hm,int level){
		if(root==null)
			return;
		verticalSumUtil(root.left,hm,level-1);
		int sum= (hm.get(level)==null)? 0:hm.get(level);
		hm.put(level, sum+root.val);
		verticalSumUtil(root.right,hm,level+1);
	}
	//GOOD
	public void verticalSum(Node root){
		if(root==null)
			return;
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		verticalSumUtil(root,hm,0);
		if(hm!=null)
			System.out.println(hm.entrySet());
	}
	
	public int max(int[] arr,int start,int end){
		int max=-10000;
		for(int i=start;i<=end;i++){
			if(max<arr[i])
				max=i;
		}
		return max;
	}
	
	//GOOD
	public Node buildSpecialTreeFromInorder(int inOrder[],int start,int end){
		if(start>end)
			return null;
		int inIndex=max(inOrder,start,end);
		Node root=new Node(inOrder[inIndex]);
		if(start==end)
			return root;
		root.left=buildSpecialTreeFromInorder(inOrder,start,inIndex-1);
		root.right=buildSpecialTreeFromInorder(inOrder,inIndex+1,end);
		return root;
	}
}
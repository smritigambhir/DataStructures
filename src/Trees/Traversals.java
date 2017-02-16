package Trees;

import java.util.LinkedList;

public class Traversals {
	
	public int height(Node root){
		if(root==null)
			return 0;
		int lh=height(root.left);
		int rh=height(root.right);
		return 1+(lh>rh?lh:rh);
	}
	
	public void levelOrderByLevel(Node root){
		LinkedList<Node> q=new LinkedList();
		q.addLast(root);
		q.addLast(null);
		while(!q.isEmpty()){
			Node temp=q.removeFirst();
			if(temp==null){
				if(q.isEmpty())
					break;
				System.out.println();
				q.addLast(null);
				continue;
			}
			System.out.print(temp.val+" ");
			if(temp.left!=null)
				q.addLast(temp.left);
			if(temp.right!=null)
				q.addLast(temp.right);
		}
	}
	
	public void printGivenLevel(Node root,int level){
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.val+" ");
		printGivenLevel(root.left,level-1);
		printGivenLevel(root.right,level-1);
	}
	
	public void levelOrder_rec(Node root){
		int h=height(root);
		for(int i=1;i<=h;i++)
			printGivenLevel(root,i);
	}
	
	public void inOrderIter(Node root){
		LinkedList<Node> stack=new LinkedList();
		//stack.push(root);
		Node temp=root;
		while(true){
			while(temp!=null){
				stack.push(temp);
				temp=temp.left;
			}
			if(stack.isEmpty())
				break;
			temp=stack.pop();
			System.out.println(temp.val);
			temp = temp.right;	
		}
	}
}

package Tries;

public class TrieNode {	
	TrieNode children[]=new TrieNode[26];
	char c;
	int countPrefix; //count of words having prefix from root to current node
	boolean isLeaf; //complete words for current node	
}

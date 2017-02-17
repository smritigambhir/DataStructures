package Tries;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Sachin".substring(1));
		Trie trie=new Trie();
		TrieNode root=trie.initializeTrie();
		trie.insertWord(root, "hello");
		trie.insertWord(root, "how");
		trie.insertWord(root, "hell");
		//System.out.println(trie.searchWord(root, "he"));
		//System.out.println(trie.searchWord(root, "hello"));
		//System.out.println(trie.searchWord(root, "ask"));
		trie.insertWord(root, "ask");
		//System.out.println(trie.searchWord(root, "ask"));
	}

}

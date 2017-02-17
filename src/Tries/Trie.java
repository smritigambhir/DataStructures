package Tries;

public class Trie {
	
	public void insertWord(TrieNode tn,String word){
		//System.out.println(word);
		if(word==""){
			tn.isLeaf=true;
			return;
		}
		tn.countPrefix+=1;
		int first=(int)(word.charAt(0));
		first=first-'a';
		//System.out.println(first);
		if(first>=0 && first<=25 && tn.children[first]==null)
			tn.children[first]=new TrieNode();
		if(word.length()>1)
			insertWord(tn.children[first],word.substring(1));
		else
			insertWord(tn.children[first],"");
	}
	
	public TrieNode initializeTrie(){
		return new TrieNode();
	}

	public boolean searchWord(TrieNode tn,String word){
		if(word=="" && tn.isLeaf==true)
			return true;
		if(word=="" && tn.isLeaf==false)
			return false;
		int first=word.charAt(0)-'a';
		if(tn.children[first]==null)
			return false;
		if(word.length()>1)
			return searchWord(tn.children[first],word.substring(1));
		else
			return searchWord(tn.children[first],"");
	}
	
	
}

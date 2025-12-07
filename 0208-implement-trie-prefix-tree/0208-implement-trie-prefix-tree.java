class node{
    node[] trie = new node[26];
    boolean end = false;
    boolean containsKey(char a, node n){
        if(n.trie[a-'a'] == null){
            return false;
        }
        return true;
    }
}
class Trie {
    node root ;
    public Trie() {
        root = new node();
    }
    
    public void insert(String word) {
        node curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            if(!curr.containsKey(word.charAt(i), curr)){
                curr.trie[word.charAt(i)-'a'] = new node();

            }
            curr = curr.trie[word.charAt(i)-'a'];
        }
        curr.end= true;
    }
    
    public boolean search(String word) {
        node curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            if(!curr.containsKey(word.charAt(i), curr)){
                return false;
            }
            curr = curr.trie[word.charAt(i)-'a'];
        }
        return curr.end;
    }
    
    public boolean startsWith(String word) {
        node curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            if(!curr.containsKey(word.charAt(i), curr)){
                return false;
            }
            curr = curr.trie[word.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
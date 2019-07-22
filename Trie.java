import java.util.ArrayList;
import java.util.List;

public class Trie {
    
    private Node root;

    public Trie(){
        this.root = new Node("");
    }

    public void insert(String key, int value){

        Node tempNode = root;

        for (int i = 0; i < key.length(); i++) {

            char c = key.charAt(i);
            int asciiIndex = c-'a';

            if(tempNode.getChild(asciiIndex) == null){

                Node node = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex, node, value);
                tempNode = node;
            }
            else{
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        tempNode.setLeaf(true);
    }

    public boolean search(String key){
        
        Node trieNode = root;

        for (int i = 0; i < key.length(); i++) {
            
            char c = key.charAt(i);
            int ascii = c - 'a';

            if(trieNode.getChild(ascii) == null ) 
                return false;

            else 
                trieNode = trieNode.getChild(ascii);
        }

        // if(! trieNode.isLeaf() ) return false; // this is optional for a trie structure

        return true;
    }


    public Integer searchAsMap(String key){
        
        Node trieNode = root;

        for (int i = 0; i < key.length(); i++) {
            
            char c = key.charAt(i);
            int ascii = c - 'a';

            if(trieNode.getChild(ascii) != null ) 
                trieNode = trieNode.getChild(ascii);

            else 
                return null;
        }

        // if(! trieNode.isLeaf() ) return false; // this is optional for a trie structure

        return trieNode.getValue();
    }
    
    
    public List<String> allWordsWithPrefix(String prefix){

        Node trieNode = root;
        List<String> lalagyan = new ArrayList<>();

        for (int i = 0; i < prefix.length(); i++) {
            
            char c = prefix.charAt(i);
            int ascii = c - 'a';
            trieNode = trieNode.getChild(ascii);
        }

        collect(trieNode, prefix, lalagyan);

        return lalagyan;
    }


    private void collect(Node node, String prefix, List<String> lalagyan){

        if(node == null) return;

        if(node.isLeaf()){
            lalagyan.add(prefix);
        }
        
        for (Node childNode : node.getChildren()) {
            if(childNode == null ) continue; // skip
            String childChar = childNode.getCharacter();
            collect(childNode, prefix + childChar, lalagyan);
        }

    }


}

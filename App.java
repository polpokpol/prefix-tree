public class App{
    public static void main(String[] args) {
        
        Trie trie = new Trie();

        trie.insert("joe", 1);
        trie.insert("joell", 2);
        // trie.insert("adamovich");
        // trie.insert("helloworld");

        System.out.println(trie.searchAsMap("joel"));
    }
}
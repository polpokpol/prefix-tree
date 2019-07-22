public class Node {

    private String character;
    private int value;
    private Node[] children;
    private boolean leaf;
    private boolean visited;

    public Node(String character) {
        this.character = character;
        children = new Node[Constant.ALPHABET_SIZE]; // every Node has a list of Node.
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setChild(int index, Node node, int value) {
        node.setValue(value);
        this.children[index] = node;
    }

    public Node getChild(int index){
        return children[index];
    }






    public String getCharacter() {
        return character;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public void setCharacter(String character) {
        this.character = character;
    }



    @Override
    public String toString(){
        return this.character;
    }
}
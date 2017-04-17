import java.util.ArrayList;
import java.util.List;

/**
 * Created by Your Friend Jesus on 15.04.2017.
 */
class Node {
    private Long id;
    private List<Node> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChildren(Node ... nodes) {
        for(Node n  : nodes){
            children.add(n);
        }
    }
    public Node(Long id){
        this.id = id;
    }
}
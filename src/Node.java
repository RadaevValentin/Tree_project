import java.util.ArrayList;
import java.util.List;

/**
 * Created by Your Friend Jesus on 15.04.2017.
 */
class Node {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    private List<Node> children = new ArrayList<>();

    public Node(Long id){
        this.id = id;
    }
}
import java.util.*;

/**
 * Created by Your Friend Jesus on 15.04.2017.
 */
public class Tree {
    private Node root;
    public Tree(Node root){
        this.root = root;
    }

    public boolean rem_node(Long id){
        try{
            if(root.getId() ==id) {
                root.setChildren(null);
                root = null;
                System.out.println("Node with id " + id + " was removed from tree");
                return true;
            }
            else{
                Queue<Node> node_queue = new LinkedList<>();
                node_queue.add(root);
                while(!node_queue.isEmpty()){
                    if(node_queue.element().getChildren() != null) {
                        Iterator<Node> it = node_queue.element().getChildren().iterator();
                        while(it.hasNext()){
                            Node node = it.next();
                            if(node.getId() ==id){
                                node_queue.element().getChildren().remove(node);
                                System.out.println("Node with id " + id + " was removed from tree");
                                return true;
                            }
                            else {
                                node_queue.add(node);
                            }
                        }
                    }
                    node_queue.remove();
                }
                System.out.println("Node with id " + id + " is absent in this tree");
                return false;
            }
        }
        catch(NullPointerException ex){
            System.out.println("Node " + id + " or its parent node was already removed.");
            return false;
        }
    }
    public Node add_node(Node parent, Long id_node){
        Node node = new Node(id_node);
        if(parent.getChildren() == null){
            parent.setChildren(new ArrayList<>());
        }
        parent.getChildren().add(node);
        return node;    
    }




    public static void main(String[] args) {
        Node n1 = new Node(1L);
        Tree tree = new Tree(n1);
        Node n2 =  tree.add_node(n1, 2L);
        Node n3 =  tree.add_node(n1, 3L);
        Node n4 =  tree.add_node(n1, 4L);
        Node n5 =  tree.add_node(n2, 5L);
        Node n6 =  tree.add_node(n2, 6L);
        Node n7 =  tree.add_node(n3, 7L);
        Node n8 =  tree.add_node(n4, 8L);
        Node n9 =  tree.add_node(n4, 9L);
        Node n10 = tree.add_node(n4, 10L);
        Node n11 = tree.add_node(n6, 11L);
        Node n12 = tree.add_node(n6, 12L);
        Node n13 = tree.add_node(n12, 13L);
        Node n14 = tree.add_node(n7, 14L);
        Node n15 = tree.add_node(n7, 15L);
        Node n16 = tree.add_node(n15, 16L);


        tree.rem_node(16L);
        tree.rem_node(12L);
        tree.rem_node(11L);
        tree.rem_node(6L);
        tree.rem_node(2L);
        tree.rem_node(1L);
        tree.rem_node(15L);

    }
}

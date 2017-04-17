import java.util.*;

/**
 * Created by Your Friend Jesus on 15.04.2017.
 */
public class Tree {
    private List<Node> tree_c = new ArrayList<>();
    private Set<Node> rem_set = new HashSet<>();
    public List<Node> getTree_c() {
        return tree_c;
    }
    private List<Node> remList  = new ArrayList<>();

    private void del(Long id, List<Node> s){
        int count = 0;
        for(Node n : s){
            if(n.getId().compareTo(id)==0){
                count++;
                rem_set.add(n);
                rem_set.addAll(n.getChildren());
            }
        }
        if(count==0) {
            System.out.println("There is no node with this id in the tree.");
        }
    }
    public void rem_node(Long id){
        del(id, tree_c);
        if(rem_set.size()==1){
            System.out.println("Node is leaf");
        }
        int cnt = 1;
        while(!(cnt==0)){
            cnt=rem_set.size();
            remList.clear();
            remList.addAll(rem_set);
            for(Node r : remList){
                del(r.getId(), tree_c);
            }
            cnt = rem_set.size() - cnt;
        }
        for(Node n : rem_set){
            tree_c.remove(n);
        }
    }
    public void print_list( List<Node> l){
        int count = 0;
        for(Node n : l){
            System.out.print(n.getId() + " | ");
            count++;
        }
        System.out.println();
        System.out.println("Summary nodes: " + count);
    }
    public void add(Node n){
       tree_c.add(n);
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node n1 = new Node(1l);
        tree.add(n1);
        Node n2 = new Node(2l);
        tree.add(n2);
        Node n3 = new Node(3l);
        tree.add(n3);
        Node n4 = new Node(4l);
        tree.add(n4);
        Node n5 = new Node(5l);
        tree.add(n5);
        Node n6 = new Node(6l);
        tree.add(n6);
        Node n7 = new Node(7l);
        tree.add(n7);
        Node n8 = new Node(8l);
        tree.add(n8);
        Node n9 = new Node(9l);
        tree.add(n9);
        Node n10 = new Node(10l);
        tree.add(n10);
        Node n11 = new Node(11l);
        tree.add(n11);
        Node n12 = new Node(12l);
        tree.add(n12);
        Node n13 = new Node(13l);
        tree.add(n13);
        Node n14 = new Node(14l);
        tree.add(n14);
        Node n15 = new Node(15l);
        tree.add(n15);
        Node n16 = new Node(16l);
        tree.add(n16);
        n1.addChildren(n2, n3, n4);
        n2.addChildren(n5, n6);
        n3.addChildren(n7);
        n4.addChildren(n8, n9, n10);
        n6.addChildren(n11, n12);
        n7.addChildren(n14, n15);
        n12.addChildren(n13);
        n15.addChildren(n16);
        System.out.println("Entire tree");
        tree.print_list(tree.getTree_c());
        System.out.println("Changed tree");
        tree.rem_node(14l);


        tree.print_list(tree.getTree_c());
    }
}

import java.util.ArrayList;

public class LowestCommonAnscestor {

    Node root;
    private ArrayList<Integer> path1 = new ArrayList<>();
    private ArrayList<Integer> path2 = new ArrayList<>();

    public static void main(String args[]){
        LowestCommonAnscestor tree = new LowestCommonAnscestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.root.right.right.right.right = new Node(9);

        System.out.println("LCA(9, 2): " + tree.findLCA(2,9));
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));
        System.out.println("LCA(8, 9): " + tree.findLCA(8,9));
    }

    int findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {

            // System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    private boolean findPath(Node root, int n, ArrayList<Integer> path)
    {
        if (root == null) {
            return false;
        }
        path.add(root.value);

        if (root.value == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)
                || root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}

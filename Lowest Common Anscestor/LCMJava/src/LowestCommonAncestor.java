import java.util.ArrayList;

public class LowestCommonAncestor {

    Node root;
    private final ArrayList<Integer> path1 = new ArrayList<>();
    private final ArrayList<Integer> path2 = new ArrayList<>();

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

        if (findPath(root.left, n, path) || findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}

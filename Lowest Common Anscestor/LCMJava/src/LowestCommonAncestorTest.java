import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorTest {

    @org.junit.Test
    public void LowestCommonAnscestorTest() {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.root.right.right.right.right = new Node(9);

        assertEquals("LCA(9,2):", 1, tree.findLCA(2,9));
        assertEquals("LCA(4,6):", 1, tree.findLCA(4,6));
        assertEquals("LCA(3,4):", 1, tree.findLCA(3,4));
        assertEquals("LCA(1,2):", 1, tree.findLCA(1,2));
        assertEquals("LCA(6,3):", 3, tree.findLCA(6,3));
        assertEquals("LCA(5,7):", 1, tree.findLCA(5,7));
        assertEquals("LCA(7,8):", 7, tree.findLCA(7,8));
        assertEquals("LCA(4,9):", 1, tree.findLCA(4,9));
    }
}
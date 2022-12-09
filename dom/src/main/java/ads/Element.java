// Frans Spijkerman, Avans Hogeschool 2020
package ads;

import java.util.LinkedList;
import java.util.List;

class Element {

    private final String tag;
    private final List<Element> children;

    Element(String tag) {
        this.tag = tag;
        children = new LinkedList<>();
    }

    /**
     * Add a node to a (sub)tree
     * 
     * efficiency determined by isInTree()
     * 
     * @param node
     * @return
     */
    Element add(Element node) {
        if (node.isInTree(this)) {
            System.out.println("node '" + node + "' is already in tree");
            return this;
        }
        children.add(node);
        return this;
    }

    /**
     * check if this element is in a certain tree
     * it is in a tree if IS the tree or is is in one of the trees children
     * 
     * time efficiency: avarage number of nodes to visit grows linear with size: O(N)
     * memory efficiency: recursion implies stack usage
     *    - best case: balanced tree: recurse to tree depth: O(log(N))
     *    - worst case: tree is linked list: recurse to tree depth: O(N)

     * 
     * @param tree: the tree to check
     * @return true if element is a descendant of the tree
     */
    boolean isInTree(Element tree) {
        if (this == tree) {
            return true;
        }
        for (Element child : tree.children) {
            if (this.isInTree(child)) {
                return true;
            }
        }
        return false;
    }

    /**
     * calculate the depth of the node recursively
     * time efficiency: all elements will be visited once: O(n)
     * memory efficiency: recursion implies stack usage
     *    - best case: balanced tree: recurse to tree depth: O(log(N))
     *    - worst case: tree is linked list: recurse to tree depth: O(N)
     * 
     * @return the calculated depth
     */
    int getDepth() {
        int max = 0;
        for (Element child : children) {
            int d = child.getDepth();
            if (d > max) {
                max = d;
            }
        }
        return max + 1;
    }

    /**
     * print the tree
     */
    public void print() {
        System.out.println();
        print("", 0);
        System.out.println();
    }

    private void print(String prefix, int kind) {
        final String[] preA = { "", "├─── ", "└─── " };
        final String[] preB = { "", "│    ", "     " };
        System.out.println(prefix + preA[kind] + tag);
        int n = children.size();
        for (Element child : children) {
            child.print(prefix + preB[kind], --n == 0 ? 2 : 1);
        }
    }

    @Override
    public String toString() {
        return tag;
    }

}

// Frans Spijkerman, Avans Hogeschool 2020
package dummy;

import java.util.LinkedList;
import java.util.List;

class Element {

    private final String tag;
    private final List<Element> children;

    Element(String tag) {
        this.tag = tag;
        children = new LinkedList<>();
    }

    Element add(Element node) {
        if(node.isInTree(this)) {
            System.out.println("node '" + node + "' is already in tree");
            return this;
        }
        children.add(node);
        return this;
    }

    /**
     * check if this element is in a certain tree
     * @param tree: the tree to check
     * @return true if element is a descendant of the tree
     */
    boolean isInTree(Element tree) {
        return false;
    }

    /**
     * calculate the depth of the node recursively
     * @return the calculated depth
     */
    int getDepth() {
        return 0;
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
        final String[] preA = {"", "├─── ", "└─── "};
        final String[] preB = {"", "│    ", "     "};
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

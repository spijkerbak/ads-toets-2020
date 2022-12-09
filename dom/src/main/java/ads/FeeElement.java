// Frans Spijkerman, Avans Hogeschool 2020
package ads;

class FreeElement extends Element {

    public FreeElement(String tag) {
        super(tag);
    }
    
    @Override
    boolean isInTree(Element tree) {
        return false;
    }

}

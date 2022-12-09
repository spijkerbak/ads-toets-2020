// Frans Spijkerman, Avans Hogeschool 2020
package dummy;

class Dom {

    public static void main(String[] args) {
        new Dom().run();
    }

    void run() {
        // define the elements
        Element elemHtml = new Element("html");
        Element elemHead = new Element("head");
        Element elemBody = new Element("body");
        Element elemTitle = new Element("title");
        Element elemStyle = new Element("style");
        Element elemHeader = new Element("header");
        Element elemFooter = new Element("footer");
        Element elemMain = new Element("main");
        Element elemH1 = new FreeElement("h1");
        Element elemH2 = new FreeElement("h2");
        Element elemP = new FreeElement("p");

        // build the tree
        elemHtml.add(elemHead).add(elemBody);
        elemHead.add(elemTitle).add(elemStyle);
        elemBody.add(elemHeader);
        elemBody.add(elemMain);
        elemBody.add(elemFooter);
        elemMain.add(elemH1).add(elemH2).add(elemP);

        // try to add second title
        elemHead.add(elemTitle);

        // try to add extra headings and paragraph
        elemMain.add(elemH1).add(elemH2).add(elemP);

        // show the tree
        elemHtml.print();

        // print the depth
        System.out.println("tree depth = " + elemHtml.getDepth());

    }

}

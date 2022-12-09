// Frans Spijkerman, Avans Hogeschool 2020
package ads;

class Friends {

    public static void main(String[] args) {
        new Friends().run();
    }

    void run() {
        // define the list
        FriendList list = new FriendList();
        
        // fill the list
        list.add("Joan Jet", "guitar");
        list.add("Marty McFly", "guitar");
        list.add("Rick Sanchez");
        list.add("Goofy Geef", "snowboarding");
        list.add("Michelle Dekker", "snowboarding");
        
        // show the names, ordered alphabetically 
        list.printByName();

        // show the names, grouped by hobby, ordered alphabetically 
        System.out.println("\nInitaly:");
        list.printByHobby();
        
        // do some updates
        list.getByName("Rick Sanchez").addHobby("travelling");
        list.getByName("Marty McFly").addHobby("travelling");

        // show the names, grouped by hobby, ordered alphabetically 
        System.out.println("\nAfter updates:");
        list.printByHobby();
        
        
    }

}

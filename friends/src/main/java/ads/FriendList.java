// Frans Spijkerman, Avans Hogeschool 2020
package ads;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FriendList {

    // every friend must be in friendByName
    // a friend can be present more than once in friendsByHobby
    // a map of all friends, key = name
    private final Map<String, Friend> friendsByName;

    // a list of list
    // for every hobby there is a set of friends
    private final Map<String, Set<Friend>> friendsByHobby;

    public FriendList() {
        friendsByName = null;
        friendsByHobby = null;
    }

    void add(String name) {
        Friend friend = new Friend(name, this);
        friendsByName.put(name, friend);
    }

    void add(String name, String hobby) {
        Friend friend = new Friend(name, this);
        friendsByName.put(name, friend);
        friend.addHobby(hobby);
        this.addHobbyFriend(hobby, friend);
    }

    Friend getByName(String name) {
        return null;
    }

    /**
     * add a friend to the list of friends for that hobby
     *
     * @param hobby
     * @param friend
     */
    void addHobbyFriend(String hobby, Friend friend) {

    }

    void printByName() {
        System.out.println("\nMy friends:");
        for (Friend friend : friendsByName.values()) {
            System.out.println("   " + friend);
        }
    }
    void printByHobby() {
        Set<Friend> list;
        list = friendsByHobby.get("guitar");
        if (list != null) {
            System.out.println("\nMy guitar friends:");
            for (Friend friend : list) {
                System.out.println("   " + friend);
            }
        }
        list = friendsByHobby.get("snowboarding");
        if (list != null) {
            System.out.println("\nMy snowboarding friends:");
            for (Friend friend : list) {
                System.out.println("   " + friend);
            }
        }
        list = friendsByHobby.get("travelling");
        if (list != null) {
            System.out.println("\nMy travelling friends:");
            for (Friend friend : list) {
                System.out.println("   " + friend);
            }
        }
    }
}

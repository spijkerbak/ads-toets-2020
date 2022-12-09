// Frans Spijkerman, Avans Hogeschool 2020
package ads;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class FriendList {

    // every friend must be in friendByName
    // a friend can be present more than once in friendsByHobby
    // a map of all friends, key = name
    private final Map<String, Friend> friendsByName;

    // a list of list
    // for every hobby there is a set of friends
    private final Map<String, Set<Friend>> friendsByHobby;

    public FriendList() {
        friendsByName = new TreeMap<>();
        friendsByHobby = new TreeMap<>();
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
        return friendsByName.get(name);
    }

    /**
     * add a friend to the list of friends for that bobby
     *
     * @param hobby
     * @param friend
     */
    void addHobbyFriend(String hobby, Friend friend) {
        Set<Friend> set;
        if (friendsByHobby.containsKey(hobby)) {
            set = friendsByHobby.get(hobby);
        } else {
            set = new TreeSet<>();
            friendsByHobby.put(hobby, set);
        }
        set.add(friend);
    }

    void printByName() {
        System.out.println("\nMy friends:");

        for (Friend friend : friendsByName.values()) {
            System.out.println("   " + friend);
        }
    }

    void printByHobby() {
        for (Entry<String, Set<Friend>> list : friendsByHobby.entrySet()) {
            System.out.println("\nMy " + list.getKey() + " friends:");
            for (Friend friend : list.getValue()) {
                System.out.println("   " + friend);
            }
        }
    }

}

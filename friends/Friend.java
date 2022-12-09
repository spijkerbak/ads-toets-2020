// Frans Spijkerman, Avans Hogeschool 2020
package ads;

import java.util.Collection;
import java.util.HashSet;

class Friend {

    private final String name; // unique
    private final FriendList list;
    private final Collection<String> hobbies;

    Friend(String name, FriendList list) {
        this.name = name;
        this.list = list;
        this.hobbies = new HashSet<>();
    }

    /**
     * add a hobby to a friend make sure the friends list is updated by hobby
     *
     * @param hobby
     */
    void addHobby(String hobby) {
        hobbies.add(hobby);
        list.addHobbyFriend(hobby, this);
    }

    @Override
    public String toString() {
        return name;
    }

}

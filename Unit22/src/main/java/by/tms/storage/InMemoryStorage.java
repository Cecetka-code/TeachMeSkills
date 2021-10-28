package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private final static List<User> userList = new ArrayList<>();

    public void save(User user) {
        userList.add(user);
    }

    public User findByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user, String newName, String newPassword) {
        for (User temp : userList) {
            if (temp.getUsername().equals(user.getUsername())) {
                temp.setName(newName);
                temp.setPassword(newPassword);
                break;
            }
        }
    }

    public void deleteUser(User user) {
        userList.remove(user);
    }
}
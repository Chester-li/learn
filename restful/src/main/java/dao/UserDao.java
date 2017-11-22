package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import rest.model.User;

/**
 * Created by chaoshuai.li on 2017/11/21.
 */
public class UserDao {

    private static int id = 1;

    public List<User> getAllUsers() {

        List<User> userList = null;
        File file = new File("user.dat");
        if (!file.exists()) {
            User user = new User(id++, "charles", "student");
            userList = new ArrayList<>();
            userList.add(user);
            saveUserList(userList);
        } else {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                userList = (List<User>) objectInputStream.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return userList;
    }

    public User getUser(int id) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public int addUser(User targetUser) {
        List<User> userList = getAllUsers();
        boolean exist = userList.stream().anyMatch(user -> user.getId() == targetUser.getId());
        if (exist) {
            return 0;
        }
        userList.add(targetUser);
        saveUserList(userList);
        return 1;
    }

    public int deleteUser(User targetUser) {
        List<User> userList = getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == targetUser.getId()) {
                userList.remove(i);
                saveUserList(userList);
                return 1;
            }
        }
        return 0;
    }

    public int updateUser(User targetUser) {
        List<User> userList = getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == targetUser.getId()) {
                userList.set(i , targetUser);
                saveUserList(userList);
                return 1;
            }
        }
        return 0;
    }

    private void saveUserList(List<User> userList) {
        File file = new File("user.dat");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

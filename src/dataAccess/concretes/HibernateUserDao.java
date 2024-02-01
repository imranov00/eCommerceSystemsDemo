package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {
    private List<User> users = new ArrayList<User>();

    public HibernateUserDao(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        System.out.println("Kullanıcı Hibernate İle Eklendi: " + user.getFirstName() + " " + user.getLastName());
        users.add(user);

    }

    @Override
    public void updateUser(User user) {
        System.out.println("Kullanıcı Güncellendi:  " + user.getFirstName() + "  " + user.getLastName());


    }

    @Override
    public void deleteUser(User user) {
        System.out.println("Kullanıcı Silindi:  " + user.getFirstName() + "  " + user.getLastName());


    }

    @Override
    public User get(int id) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }


    @Override
    public boolean getEmail(String email) {
        for (User user : users) {
            if (user.getePosta() == email) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getPassword(String password) {
        for (User user : users) {
            if (user.getParola() == password) {
                return true;
            }
        }
        return false;
    }


}

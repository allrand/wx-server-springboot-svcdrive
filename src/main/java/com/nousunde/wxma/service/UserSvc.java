package com.nousunde.wxma.service;

import com.nousunde.wxma.dao.UserDAO;
import com.nousunde.wxma.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSvc {
    @Autowired
    private UserDAO userDAO;

    public List<User> getUsers(){
        return userDAO.getUsers();
    }

    public User getUserById(String userId){
        if (userId.isEmpty() || userId == null)
            return null;
        return userDAO.getUserByUserId(userId);
    }
    public User getUserByAccount(String account){
        if (account.isEmpty() || account == null)
            return null;
        return userDAO.getUserByAccount(account);
    }

    public void addUser(User user){
        if (user == null)
            return;
        userDAO.addUser(user);
    }

    public void updateUser(User user){
        if (user == null)
            return;
        userDAO.updateUser(user);
    }

    public void deleteUser(String userId){
        if (userId.isEmpty() || userId == null)
            return;
        userDAO.deleteUserById(userId);
    }
}

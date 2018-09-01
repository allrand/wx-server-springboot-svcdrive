package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.UserDataHandler;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDAO userDAO;

//    @Ignore
    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("a10");
        userDAO.addUser(user);

    }
    @Ignore
    @Test
    public void getUserByAccount() {
        User user = userDAO.getUserByAccount("nousunde");
        logger.debug("user's userId: {}", user.getUserId());
    }
    @Ignore
    @Test
    public void updateUser() {
        User user = null;
//        user = userDAO.getUserByAccount("nousunde");
        user = userDAO.getUserByAccount("a10");
        user.setDisplayName("快樂使者");
        user.setSignature("I want to keep happy forever!");
        userDAO.updateUser(user);

    }
}
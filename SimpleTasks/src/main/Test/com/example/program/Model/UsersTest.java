package com.example.program.Model;

import com.example.program.Controllers.HomeViewController;
import com.example.program.DAO.DAOFactory;
import de.saxsys.javafx.test.JfxRunner;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(JfxRunner.class)
class UsersTest {

    Users users;

    @BeforeEach
    public void setup(){
        users = new Users();
    }
    @Test
    void getId_User() {
        users.setId_User(10);
        Assert.assertEquals(users.getId_User(), 10);
    }



    @Test
    void getLogin() {
        users.setLogin("login");
        Assert.assertEquals(users.getLogin(), "login");
    }


    @Test
    void getPassword() {
        users.setPassword("Password");
        Assert.assertEquals(users.getPassword(), "Password");
    }


}
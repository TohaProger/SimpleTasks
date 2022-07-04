package com.example.program.Model;

import com.example.program.Controllers.HomeViewController;
import com.example.program.DAO.DAOFactory;
import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.layout.Pane;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(JfxRunner.class)
class ProjectTest {
    Project project;

    @BeforeEach
    public void setup() throws SQLException, URISyntaxException, IOException {
        HomeViewController.daoFactory= DAOFactory.getDAOFactory(2);
        project = new Project();
    }

    @Test
    void checkIdentically() {
        Requirements requirements = new Requirements();
        Assert.assertFalse(project.checkIdentically(requirements));
    }



    @Test
    void hasDuplicates() {
        Requirements requirements = new Requirements();
        project.AddRerequirementsCollection(requirements);
        Assert.assertFalse(project.hasDuplicates());
    }
}
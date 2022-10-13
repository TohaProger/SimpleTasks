package com.example.program.Model;

import com.example.program.Controllers.LoginController;
import com.example.program.DAO.DAOFactory;
import de.saxsys.javafx.test.JfxRunner;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

@RunWith(JfxRunner.class)
class ProjectTest {
    Project project;

    @BeforeEach
    public void setup() throws SQLException, URISyntaxException, IOException {
        LoginController.daoFactory= DAOFactory.getDAOFactory("quelquechosedetrescomplique");
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
        project.AddRequirementsCollection(requirements);
        Assert.assertFalse(project.hasDuplicates());
    }
}
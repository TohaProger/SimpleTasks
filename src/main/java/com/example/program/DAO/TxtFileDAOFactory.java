package com.example.program.DAO;

public class TxtFileDAOFactory extends DAOFactory {

    @Override
    public ProjectDAO getProjectDAO() {
        return new TxtFileProjectDAO();
    }

    @Override
    public RequirementsDAO getRequirementsDAO() {
        return new TxtFileReqiurementsDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new TxtFileUserDAO();
    }
}
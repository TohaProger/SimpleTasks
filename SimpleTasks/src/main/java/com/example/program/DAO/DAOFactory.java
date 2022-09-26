package com.example.program.DAO;

public abstract class DAOFactory {
    // List of DAO types supported by the factory
    public static final String TXT = "quelquechosedecomplique";
    public static final String SQLITE = "quelquechosedetrescomplique";

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract ProjectDAO getProjectDAO();
    public abstract RequirementsDAO getRequirementsDAO();
    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory(
            String whichFactory) {
        switch (whichFactory) {
            case TXT:
                return new TxtFileDAOFactory();
            case SQLITE:
                return new SQLiteDAOFactory();
            default           :
                return null;
        }
    }
}
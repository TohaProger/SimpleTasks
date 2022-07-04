package com.example.program.DAO;

public abstract class DAOFactory {
    // List of DAO types supported by the factory
    public static final int TXT = 1;
    public static final int SQLITE = 2;

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract ProjectDAO getProjectDAO();
    public abstract RequirementsDAO getRequirementsDAO();
    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {
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

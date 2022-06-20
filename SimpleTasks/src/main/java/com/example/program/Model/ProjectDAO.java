package com.example.program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс Dao для работы с БД
 */
public class ProjectDAO extends DAO {
    public ProjectDAO(){

    }

    /**
     *Функция получения всех записей
     * @return {@link  ObservableList} список требований
     * @throws IOException исключение потока для чтения данных
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public ObservableList<Project> getProject() throws SQLException, URISyntaxException {
        createConnection();
        ObservableList<Project> res = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("Select * from projects ");
        Project project = new Project();
        while (set.next()) {
            project = MappringProject(set);
            res.add(project);
        }
        return res;
    }



    /**
     * Маппинг результата апроса
     * @param result результирующий список
     * @return требование
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    public Project MappringProject(ResultSet result) throws SQLException, URISyntaxException {
        Project project = new Project();
        project.setID_project(result.getInt("ID_project"));
        project.setProject_name(result.getString("project_name"));
        project.setDescription(result.getString("Description"));
        return project;
    }

//    /**
//     * Функция добавления записи
//     * @param requirement
//     * @throws SQLException
//     */
//    public void addEntity(Entity requirement) throws SQLException {
//        Requirements requirements = (Requirements) requirement;
//        PreparedStatement insert  = connection.prepareStatement("insert into Requirements (Name,Priority,Status,Author,Complexity,Source,Reason,Description,RiskAssessment,Type,Requirements_ID)" +
//                "values(?,?,?,?,?,?,?,?,?,?,?)");
//        insert.setString(1,requirements.getName());
//        insert.setString(2,requirements.getPriority());
//        insert.setString(3,requirements.getStatus());
//        insert.setString(4,requirements.getAuthor());
//        insert.setString(5,requirements.getType());
//        insert.setString(6,requirements.getComplexity());
//        insert.setString(7,requirements.getSource());
//        insert.setString(8,requirements.getReason());
//        insert.setString(9,requirements.getDescription());
//        insert.setString(10,requirements.getRiskAssessment());
//        insert.setString(11, requirements.getId_Requirements());
//        insert.executeUpdate();
//    }
//
//    /**
//     * Функция удаления записи
//     * @param requirement сущность
//     * @throws SQLException исключение при работе с SQL-запросами
//     */
//    public void deleteEntity(Entity requirement) throws SQLException {
//        Requirements requirements=(Requirements) requirement;
//        PreparedStatement insert  = connection.prepareStatement("delete from Requirements where Requirements_ID = ?");
//        insert.setString(1, requirements.getId_Requirements());
//        insert.executeUpdate();
//    }
//
//    /**
//     * Функция обнавления записи
//     * @param requirement сущность
//     * @throws SQLException исключение при работе с SQL-запросами
//     */
//    public void updateEntitys(Entity requirement) throws SQLException {
//        Requirements requirements = (Requirements)requirement;
//        PreparedStatement insert  = connection.prepareStatement("update Requirements set Name = ?,Priority = ?, Status = ?, Author=?, Type=?," +
//                "Complexity=?, Source=?, Reason=?,Description=?,RiskAssessment=?  where Requirements_ID = ?");
//        insert.setString(1,requirements.getName());
//        insert.setString(2,requirements.getPriority());
//        insert.setString(3,requirements.getStatus());
//        insert.setString(4,requirements.getAuthor());
//        insert.setString(5,requirements.getType());
//        insert.setString(6,requirements.getComplexity());
//        insert.setString(7,requirements.getSource());
//        insert.setString(8,requirements.getReason());
//        insert.setString(9,requirements.getDescription());
//        insert.setString(10,requirements.getRiskAssessment());
//        insert.setString(11, requirements.getId_Requirements());
//        insert.executeUpdate();
//
//    }
}

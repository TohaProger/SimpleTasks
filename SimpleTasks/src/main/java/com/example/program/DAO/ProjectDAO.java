package com.example.program.DAO;

import com.example.program.Model.Project;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Класс Dao для работы с БД
 */
public interface  ProjectDAO {

    /**
     *Функция получения всех записей
     * @return {@link  ObservableList} список требований
     * @throws IOException исключение потока для чтения данных
     * @throws SQLException исключение при работе с SQL-запросами
     */
    ObservableList<Project> getProject() throws SQLException, URISyntaxException, IOException;
//    public ObservableList<Project> getProject() throws SQLException, URISyntaxException {
//        createConnection();
//        ObservableList<Project> res = FXCollections.observableArrayList();
//        Statement statement = connection.createStatement();
//        ResultSet set = statement.executeQuery("Select * from projects ");
//        Project project = new Project();
//        while (set.next()) {
//            project = MappringProject(set);
//            res.add(project);
//        }
//        return res;
//    }



    /**
     * Маппинг результата апроса
     * @param result результирующий список
     * @return требование
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    Project MappringProject(Object result) throws SQLException, URISyntaxException, IOException;
//    public Project MappringProject(ResultSet result) throws SQLException, URISyntaxException {
//        Project project = new Project();
//        project.setID_project(result.getInt("ID_project"));
//        project.setProject_name(result.getString("project_name"));
//        project.setDescription(result.getString("Description"));
//        return project;
//    }


}

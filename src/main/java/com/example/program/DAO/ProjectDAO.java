package com.example.program.DAO;

import com.example.program.Model.Project;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Класс Dao для работы с БД
 */
public interface ProjectDAO {

    /**
     * Функция получения всех записей
     *
     * @return {@link  ObservableList} список требований
     * @throws IOException  исключение потока для чтения данных
     * @throws SQLException исключение при работе с SQL - запросами
     */
    ObservableList<Project> getProject() throws SQLException, URISyntaxException, IOException;

    /**
     * Маппинг результата опроса
     *
     * @param result результирующий список
     * @return требование
     * @throws SQLException       исключение при работе с SQL - запросами
     * @throws URISyntaxException исключение при получении URL
     */
    Project MappingProject(Object result) throws SQLException, URISyntaxException, IOException;
}

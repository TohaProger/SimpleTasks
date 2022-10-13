package com.example.program.DAO;

import com.example.program.Model.Requirements;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Класс Dao для работы с БД
 */
public interface RequirementsDAO {
    /**
     * Функция получения всех записей
     *
     * @return {@link  ObservableList} список требований
     * @throws IOException  исключение потока для чтения данных
     * @throws SQLException исключение при работе с SQL - запросами
     */
    ObservableList<Requirements> getRequirements(int id_Project) throws SQLException, URISyntaxException, IOException;

    /**
     * Функция фильтрации
     *
     * @param type выбранный тип требований
     * @return {@link  ObservableList} список требований
     * @throws SQLException       исключение при работе с SQL - запросами
     * @throws URISyntaxException исключение при получении URL
     */
    ObservableList<Requirements> getRequirementsFilterType(String type) throws SQLException, URISyntaxException;

    /**
     * Маппинг результата апроса
     *
     * @param result1 результирующий список
     * @return требование
     * @throws SQLException       исключение при работе с SQL - запросами
     * @throws URISyntaxException исключение при получении URL
     */
    Requirements MappingRequirements(Object result1) throws SQLException, URISyntaxException;

    /**
     * Функция добавления записи
     */
    void addEntity(Requirements requirement) throws SQLException;

    /**
     * Функция удаления записи
     *
     * @param requirement сущность
     * @throws SQLException исключение при работе с SQL - запросами
     */
    void deleteEntity(Requirements requirement) throws SQLException;

    /**
     * Функция обновления записи
     *
     * @param requirement сущность
     * @throws SQLException исключение при работе с SQL - запросами
     */
    void updateEntity(Requirements requirement) throws SQLException;

    /**
     * Функция обновления записи
     *
     * @param requirement сущность
     * @throws SQLException исключение при работе с SQL - запросами
     */
    void updateTemplateEntity(Requirements requirement) throws SQLException;
}
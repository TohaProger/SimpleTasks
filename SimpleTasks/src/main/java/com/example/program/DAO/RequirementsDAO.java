package com.example.program.DAO;

import com.example.program.Model.Requirements;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Класс Dao для работы с БД
 */
public interface RequirementsDAO{


    /**
     *Функция получения всех записей
     * @return {@link  ObservableList} список требований
     * @throws IOException исключение потока для чтения данных
     * @throws SQLException исключение при работе с SQL-запросами
     */
     ObservableList<Requirements> getRequirements(int id_Project) throws SQLException, URISyntaxException, IOException;

//    public ObservableList<Requirements> getRequirements(int id_Project) throws SQLException, URISyntaxException {
//        createConnection();
//        ObservableList<Requirements> res = FXCollections.observableArrayList();
//        Statement statement = connection.createStatement();
//        ResultSet set = statement.executeQuery("Select * from Requirements where Project="+Integer.toString(id_Project));
//        Requirements requirements = new Requirements();
//        while (set.next()) {
//            requirements = MappringRequirements(set);
//            res.add(requirements);
//        }
//        return res;
//    }
    /**
     * Функция фильтрации
     * @param type выбранный тип  требований
     * @return {@link  ObservableList} список требований
     * @throws SQLException  исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    public ObservableList<Requirements> getRequirementsFilterType(String type) throws SQLException, URISyntaxException;
//    public ObservableList<Requirements> getRequirementsFilterType(String type) throws SQLException, URISyntaxException {
//        createConnection();
//        ObservableList<Requirements> res = FXCollections.observableArrayList();
//        Statement statement = connection.createStatement();
//        ResultSet set = statement.executeQuery("Select * from Requirements where Type='" + type+"'");
//        Requirements requirements = new Requirements();
//        while (set.next()) {
//            requirements = MappringRequirements(set);
//            res.add(requirements);
//        }
//        return res;
//    }
    /**
     * Маппинг результата апроса
     * @param result1 результирующий список
     * @return требование
     * @throws SQLException исключение при работе с SQL-запросами
     * @throws URISyntaxException исключение при получении URL
     */
    Requirements MappringRequirements(Object result1) throws SQLException, URISyntaxException ;
//    public Requirements MappringRequirements(ResultSet result) throws SQLException, URISyntaxException {
//        Requirements requirements = new Requirements();
//        requirements.setId_Requirements(result.getString("Requirements_ID"));
//        requirements.setName(result.getString("Name"));
//        requirements.setPriority(result.getString("Priority"));
//        requirements.setStatus(result.getString("Status"));
//        requirements.setAuthor(result.getString("Author").trim());
//        requirements.setComplexity(result.getString("Complexity"));
//        requirements.setType(result.getString("Type"));
//        requirements.setSource(result.getString("Source"));
//        requirements.setReason(result.getString("Reason"));
//        requirements.setDescription(result.getString("Description"));
//        requirements.setRiskAssessment(result.getString("RiskAssessment"));
//        requirements.setProject(result.getString("Project"));
//        requirements.setTemplate(result.getString("Template"));
//        return requirements;
//    }
    /**
     * Функция добавления записи
     * @param requirement
     * @throws SQLException
     */
//    public void addEntity(Entity requirement) throws SQLException {
//        Requirements requirements = (Requirements) requirement;
//        PreparedStatement insert  = connection.prepareStatement("insert into Requirements (Name,Priority,Status," +
//                "Author,Type,Complexity,Source,Reason,Description,RiskAssessment,Requirements_ID,Project)" +
//                "values(?,?,?,?,?,?,?,?,?,?,?,?)");
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
//        insert.setString(12, requirements.getProject());
//        insert.executeUpdate();
//    }
    void addEntity(Requirements requirement) throws SQLException ;
    /**
     * Функция удаления записи
     * @param requirement сущность
     * @throws SQLException исключение при работе с SQL-запросами
     */
     void deleteEntity(Requirements requirement) throws SQLException;
//    public void deleteEntity(Entity requirement) throws SQLException {
//        Requirements requirements=(Requirements) requirement;
//        PreparedStatement insert  = connection.prepareStatement("delete from Requirements where Requirements_ID = ?");
//        insert.setString(1, requirements.getId_Requirements());
//        insert.executeUpdate();
//    }
    /**
     * Функция обнавления записи
     * @param requirement сущность
     * @throws SQLException исключение при работе с SQL-запросами
     */
    void updateEntitys(Requirements requirement) throws SQLException;
//    public void updateEntitys(Entity requirement) throws SQLException {
//        Requirements requirements = (Requirements)requirement;
//        PreparedStatement insert  = connection.prepareStatement("update Requirements set Name = ?, Priority = ?, " +
//                "Status = ?, Author=?, Type=?, " +
//                "Complexity=?, Source=?, Reason=?, Description=?, RiskAssessment=?  where Requirements_ID = ?");
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
    /**
     * Функция обнавления записи
     * @param requirement сущность
     * @throws SQLException исключение при работе с SQL-запросами
     */
    void updateTemplateEntitys(Requirements requirement) throws SQLException;
//    public void updateTemplateEntitys(Entity requirement) throws SQLException {
//
//        Requirements requirements = (Requirements)requirement;
//        PreparedStatement insert  = connection.prepareStatement("update Requirements set Template = ? where Requirements_ID = ?");
//        insert.setString(1,requirements.getTemplate());
//        insert.setString(2, requirements.getId_Requirements());
//        insert.executeUpdate();
//
//    }
}

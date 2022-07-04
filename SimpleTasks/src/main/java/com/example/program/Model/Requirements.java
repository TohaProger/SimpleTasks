package com.example.program.Model;

import com.example.program.Controllers.HomeViewController;
import com.example.program.DAO.DAOFactory;
import com.example.program.DAO.UserDAO;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Класс требования
 */
public class Requirements implements Serializable {
    /**
     * Id Требования UUID
     */
    public UUID id_Requirements;
    public String Type;
    public URI Source;
    public String Reason;
    public String Description;
    public String Complexity;
    public String priority;
    public String Name;
    public String RiskAssessment;
    public String status;
    public Users author;
    public String Project;
    public String Template;
    @Override
    public  boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Requirements)) {
            return false;
        }
        return false;
    }
    public Requirements(){
        author = new Users();
    }
    /**
     * Функия возвращает id_Requirements
     * @return id_Requirements
     */
    public String getId_Requirements() {
        return id_Requirements.toString();
    }

    /**
     * функция создает новый id_Requirements
     */
    public void setNewId_Requirements() {
        id_Requirements=UUID.randomUUID();
    }

    /**
     * Функия задает значение id_Requirements
     * @param id_Requirements id_Requirements
     */
    public void setId_Requirements(String id_Requirements) {
        this.id_Requirements=UUID.fromString(id_Requirements);
        System.out.println("UUID="+id_Requirements.toString());
    }
    /**
     * Функия задает значение id_Requirements
     * @param id_Requirements id_Requirements
     */
    public void setId_Requirements(UUID id_Requirements) {
        this.id_Requirements=id_Requirements;
    }

    /**
     * Функия возвращает
     * @return
     */
    public String getPriority() {
        return priority;
    }
    /**
     * Функия задает значение приоритету требования
     * @param priority приоритет
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Функия возвращает название
     * @return название
     */
    public String getName() {
        return Name;
    }
    /**
     * Функия задает название  требования
     * @param name название
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * Функия возвращает название проекта
     * @return название проекта
     */
    public String getProject() {
        return Project;
    }
    /**
     * Функия задает название  требования проекта
     * @param project название проекта
     */
    public void setProject(String project) {
        Project = project;
    }

    /**
     * Функия возвращает
     * @return
     */
    public String getStatus() {
        return status;
    }
    /**
     * Функия задает статус  требования
     * @param status статус
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Функия возвращает логин автора требования
     * @return логин автора
     */
    public String getAuthor() {
        return author.getLogin();
    }

    /**
     *  Функия задает автора требования
     * @param author автор
     * @throws SQLException исключение при работе с SQL-запросами
     */
    public void setAuthor(String author) throws SQLException {
        this.author=HomeViewController.daoFactory.getUserDAO().findUser(author);
    }
    public void setAuthor(Users author) throws SQLException {
        this.author=author;
    }

    /**
     * Функия возвращает шаблон требования
     * @return
     */
    public String getTemplate() {
        return Template;
    }
    /**
     * Функия задает шаблон  требования
     * @param template статус
     */
    public void setTemplate(String template) {
        Template = template;
    }


    /**
     * Функия возвращает тип требования
     * @return
     */
    public String getType() {
        return Type;
    }

    /**
     * Функия задает значение типу требования
     * @param type
     */
    public void setType(String type) {
        Type = type;
    }

    /**
     * Функия возвращает ресурс требования
     * @return
     */
    public String getSource() {
        return Source.toString();
    }

    /**
     * Функия задает значение источнику требования
     * @param source
     * @throws URISyntaxException
     */
    public void setSource(String source) throws URISyntaxException {
        Source = new URI(source);
    }

    /**
     * Функия возвращает причину требования
     * @return причину требования
     */
    public String getReason() {
        return Reason;
    }

    /**
     * Функия задает причину требования
     * @param reason
     */
    public void setReason(String reason) {
        Reason = reason;
    }

    /**
     * Функия возвращает описание требования
     * @return описание требования
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Функия задает значение описанию требования
     * @param description
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * Функия возвращает сложность требования
     * @return сложность требования
     */
    public String getComplexity() {
        return Complexity;
    }

    /**
     * Функия задает значение сложности требования
     * @param complexity
     */
    public void setComplexity(String complexity) {
        Complexity = complexity;
    }

    /**
     * Функия возвращает оценку риска требования
     * @return  оценку риска
     */
    public String getRiskAssessment() {
        return RiskAssessment;
    }
    public void PrintEntity() {
        System.out.println(this.toString());
    }

    /**
     * функция проверки пустой ли требование
     * @return результат
     */
    public boolean isEmpty() {
        if(this.id_Requirements.toString()!=null || this.author.toString()!=null
            || this.Name!=null || this.Complexity!=null){
            return false;
        }
        return true;
    }

    public void setRiskAssessment(String riskAssessment) {
        RiskAssessment = riskAssessment;
    }
}

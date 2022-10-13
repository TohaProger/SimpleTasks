package com.example.program.Model;

import com.example.program.Controllers.LoginController;

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
    public boolean equals(Object obj) {
        return this == obj;
    }

    public Requirements() {
        author = new Users();
    }

    /**
     * Функция возвращает id_Requirements
     *
     * @return id_Requirements
     */
    public String getId_Requirements() {
        return id_Requirements.toString();
    }

    /**
     * функция создает новый id_Requirements
     */
    public void setNewId_Requirements() {
        id_Requirements = UUID.randomUUID();
    }

    /**
     * Функция задает значение id_Requirements
     *
     * @param id_Requirements id_Requirements
     */
    public void setId_Requirements(String id_Requirements) {
        this.id_Requirements = UUID.fromString(id_Requirements);
        System.out.println("UUID=" + id_Requirements);
    }
    /*
     * Функция задает значение id_Requirements
     * @param id_Requirements id_Requirements
     *
    public void setId_Requirements(UUID id_Requirements) {
        this.id_Requirements=id_Requirements;
    }*/


    /**
     * Функция возвращает
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Функция задает значение приоритету требования
     *
     * @param priority приоритет
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Функция возвращает название
     *
     * @return название
     */
    public String getName() {
        return Name;
    }

    /**
     * Функция задает название требования
     *
     * @param name название
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Функция возвращает название проекта
     *
     * @return название проекта
     */
    public String getProject() {
        return Project;
    }

    /**
     * Функция задает название требования проекта
     *
     * @param project название проекта
     */
    public void setProject(String project) {
        Project = project;
    }

    /**
     * Функция возвращает
     */
    public String getStatus() {
        return status;
    }

    /**
     * Функция задает статус требования
     *
     * @param status статус
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Функция возвращает логин автора требования
     *
     * @return логин автора
     */
    public String getAuthor() {
        return author.getLogin();
    }

    /**
     * Функция задает автора требования
     *
     * @param author автор
     * @throws SQLException исключение при работе с SQL - запросами
     */
    public void setAuthor(String author) throws SQLException {
        this.author = LoginController.daoFactory.getUserDAO().findUser(author);
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    /**
     * Функция возвращает шаблон требования
     */
    public String getTemplate() {
        return Template;
    }

    /**
     * Функция задает шаблон требования
     *
     * @param template статус
     */
    public void setTemplate(String template) {
        Template = template;
    }


    /**
     * Функция возвращает тип требования
     */
    public String getType() {
        return Type;
    }

    /**
     * Функция задает значение типу требования
     */
    public void setType(String type) {
        Type = type;
    }

    /**
     * Функция возвращает ресурс требования
     */
    public String getSource() {
        return Source.toString();
    }

    /**
     * Функция задает значение источнику требования
     */
    public void setSource(String source) throws URISyntaxException {
        Source = new URI(source);
    }

    /**
     * Функция возвращает причину требования
     *
     * @return причину требования
     */
    public String getReason() {
        return Reason;
    }

    /**
     * Функция задает причину требования
     */
    public void setReason(String reason) {
        Reason = reason;
    }

    /**
     * Функция возвращает описание требования
     *
     * @return описание требования
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Функция задает значение описанию требования
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * Функция возвращает сложность требования
     *
     * @return сложность требования
     */
    public String getComplexity() {
        return Complexity;
    }

    /**
     * Функция задает значение сложности требования
     */
    public void setComplexity(String complexity) {
        Complexity = complexity;
    }

    /**
     * Функция возвращает оценку риска требования
     *
     * @return оценку риска
     */
    public String getRiskAssessment() {
        return RiskAssessment;
    }

    public void PrintEntity() {
        System.out.println(this.toString());
    }

    /**
     * функция проверки пустой ли требование
     *
     * @return результат
     */
    public boolean isEmpty() {
        return this.id_Requirements.toString() == null && this.author.toString() == null
                && this.Name == null && this.Complexity == null;
    }

    public void setRiskAssessment(String riskAssessment) {
        RiskAssessment = riskAssessment;
    }
}
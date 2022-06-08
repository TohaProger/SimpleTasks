package com.example.program.Model;

public class Requirements implements Entity {
    public String id_Requirements;
    public String Type;
    public String Source;
    public String Reason;
    public String Description;
    public String Complexity;
    public String priority;
    public String Name;
    public String RiskAssessment;
    public String status;
    public String author;

    public String getId_Requirements() {
        return id_Requirements;
    }

    public void setId_Requirements(String id_Requirements) {
        this.id_Requirements = id_Requirements;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        UserDAO userDAO = new UserDAO();
        this.author = author;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getComplexity() {
        return Complexity;
    }

    public void setComplexity(String complexity) {
        Complexity = complexity;
    }

    public String getRiskAssessment() {
        return RiskAssessment;
    }

    public void setRiskAssessment(String riskAssessment) {
        RiskAssessment = riskAssessment;
    }
}

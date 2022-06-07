package com.example.program.Model;

public class Requirements implements Entity {
    public int id_Requirements;

    public int getId_Requirements() {
        return id_Requirements;
    }

    public void setId_Requirements(int id_Requirements) {
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

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
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

    public String priority;
    public String Name;
    public String Version;
    public String status;
    public String author;
}

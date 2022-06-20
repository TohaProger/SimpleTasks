package com.example.program.Model;

public class Project implements Entity{
    public int ID_project;
    public String project_name;
    public String Description;
    @Override
    public void PrintEntity() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public int getID_project() {
        return ID_project;
    }

    public void setID_project(int ID_project) {
        this.ID_project = ID_project;
    }
}

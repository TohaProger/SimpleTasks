package com.example.program.Model;

import com.example.program.Controllers.HomeViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Project{
    public int ID_project;
    public String project_name;
    public String Description;
    public  ObservableList<Requirements> RequirementsProject;
    public RequirementsCollection requirementsCollection;
    public Project() throws SQLException, URISyntaxException, IOException {
        requirementsCollection = new RequirementsCollection(HomeViewController.daoFactory.getRequirementsDAO()
                .getRequirements(ID_project));
    }
    public void Print(){
        System.out.println(requirementsCollection.requirementsCollection.size());
    }
    public boolean checkIdentically(Requirements requirements2){
        int count=requirementsCollection.requirementsCollection.size();
        for(int i=0;i<count;i++){
            return requirements2.equals(requirementsCollection.requirementsCollection.get(i));
        }
        return false;
    }
    public void AddRerequirementsCollection(Requirements requirements){
        requirementsCollection.AddRequariments(requirements);
    }
    public boolean hasDuplicates(){
        int count=requirementsCollection.requirementsCollection.size();
        Requirements t1,t2;
        for(int i=0;i<count;i++){
            t1 = (Requirements) requirementsCollection.requirementsCollection.get(i);
            for(int j=i+1;j<count;j++){
                t2 = (Requirements) requirementsCollection.requirementsCollection.get(j);
                if(t2.equals(t1)){
                    return true;
                }
            }
        }
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

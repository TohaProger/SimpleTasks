package com.example.program.DAO;

import com.example.program.Model.Project;
import com.example.program.Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtFileUserDAO implements UserDAO {
    final String FILEPATH = "src\\main\\resources\\com\\example\\program\\txtfile\\users.txt";

    @Override
    public List<Users> getAllEntity() throws SQLException, IOException {
        String fileContent = "";
        Users project = new Users();
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileContent = contentBuilder.toString();

        ObservableList<Users> res = FXCollections.observableArrayList();
        FileReader read = new FileReader(new File(FILEPATH));
        Scanner scan = new Scanner(read);
        while (scan.hasNextLine()) {
            project = Mapping(scan);
            res.add(project);
        }
        read.close();
        return res;
    }

    @Override
    public boolean Verification(String login, String password) throws SQLException, IOException {
        List<Users> list = this.getAllEntity();
        Users findUser = new Users();
        findUser.setLogin(login);
        findUser.setPassword(password);
        if (list.contains(findUser)) {
            return true;
        }
        return false;
    }

    @Override
    public int addUser(String login, String password) throws SQLException, IOException {
        try {
            List<Users> list = this.getAllEntity();
            FileWriter writer = new FileWriter(FILEPATH, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            Users user = new Users();
            Users newuser = new Users();
            newuser.setLogin(login);
            newuser.setLogin(login);
            user = list.get(list.size() - 1);
            int id = user.getId_User();
            id++;
            newuser.setId_User(id);
            String text = newuser.getId_User() + " " + newuser.getLogin() + " " + newuser.getPassword() + "\n";
            bufferWriter.write(text);
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public Users findUserByID(int id) throws SQLException {
        return null;
    }

    @Override
    public Users findUser(String login, String password) throws SQLException {
        return null;
    }

    @Override
    public Users findUser(String login) throws SQLException {
        return null;
    }

    @Override
    public Users Mapping(Object result) throws SQLException, IOException {
//        Scanner scan = (Scanner) result;
//
//        Users users = new Users();
//        users.setId_User(scan.nextInt());
//        System.out.println(users.getId_User());
//        users.setLogin(scan.next());
//        System.out.println(users.getLogin());
//        users.setPassword(scan.next());
//        System.out.println(users.getPassword());
        Users users = new Users();
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(new FileReader(new File(FILEPATH)));
        // считаем сначала первую строку
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
        
        return users;
    }
}

package com.example.program.DAO;

import com.example.program.Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class TxtFileUserDAO implements UserDAO {
    final String FILEPATH = "src\\main\\resources\\com\\example\\program\\txtfile\\users.txt";

    @Override
    public List<Users> getAllEntity() throws IOException {
        Users project;// = new Users();
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObservableList<Users> res = FXCollections.observableArrayList();
        FileReader read = new FileReader(FILEPATH);
        Scanner scan = new Scanner(read);
        while (scan.hasNextLine()) {
            project = Mapping(scan);
            res.add(project);
        }
        read.close();
        return res;
    }

    @Override
    public boolean Verification(String login, String password) throws IOException {
        List<Users> list = this.getAllEntity();
        Users findUser = new Users();
        findUser.setLogin(login);
        findUser.setPassword(password);
        return list.contains(findUser);
    }

    @Override
    public void addUser(String login, String password) {
        try {
            List<Users> list = this.getAllEntity();
            FileWriter writer = new FileWriter(FILEPATH, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            Users user;// = new Users();
            Users newUser = new Users();
            newUser.setLogin(login);
            newUser.setLogin(login);
            user = list.get(list.size() - 1);
            int id = user.getId_User();
            id++;
            newUser.setId_User(id);
            String text = newUser.getId_User() + " " + newUser.getLogin() + " " + newUser.getPassword() + "\n";
            bufferWriter.write(text);
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Users findUserByID(int id) {
        return null;
    }

    @Override
    public Users findUser(String login, String password) {
        return null;
    }

    @Override
    public Users findUser(String login) {
        return null;
    }

    @Override
    public Users Mapping(Object result) throws IOException {
        Users users = new Users();

        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));

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
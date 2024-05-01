package ua.com.foxminded;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.List;

import org.apache.ibatis.jdbc.ScriptRunner;

public class Main {
    public static void main(String[] args) {


        int $ = 0;
        String jdbcURL = "jdbc:postgresql://localhost:5432/schooldb";
        String username = "admin";
        String password = "admin";

        GroupBuilder groupBuilder = new GroupBuilder();
        List<Group> groupList =groupBuilder.generateGroupList(20);

 /*       try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL server");

            String sql = "select 1";
            ScriptRunner scriptRunner = new ScriptRunner(connection);

            Statement preparedStatement = connection.createStatement();

            Reader reader = new BufferedReader(new FileReader("src/main/resources/create_tables.sql"));
            scriptRunner.runScript(reader);

            connection.close();
        } catch (SQLException | FileNotFoundException e){
            System.out.println("Connection ERROR to PostgreSQL server");
            e.printStackTrace();
        }
*/
    }
}

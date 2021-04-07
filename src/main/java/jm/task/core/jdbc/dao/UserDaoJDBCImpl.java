package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//Нужно использовать объект типа статмент и резалт сет.

public class UserDaoJDBCImpl implements UserDao {
    private Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        //таблица должна содержать
        String createTable = "CREATE TABLE Users(id int not null, name VARCHAR(30), lastName VARCHAR(30), age int);";
        try{
            Statement stat = util.connectToDB().createStatement();
            stat.executeUpdate(createTable);
            System.out.println("запрос выполнился успешно");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String dropUser = "DROP TABLE Users";
        try {
            Statement stat = util.connectToDB().createStatement();
            stat.executeUpdate(dropUser);
            System.out.println("sql success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUsers = "INSERT INTO Users(name, lastName, age) " + "VALUES (?,?,?)";
        try {
            Statement stat = util.connectToDB().createStatement();
            stat.executeUpdate(saveUsers);
            System.out.println("запрос выполнился успешно");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void removeUserById(long id) {
        String removeUserId = "DELETE FROM Users " +
                "WHERE id ="+id;
        try{
            Statement stat = util.connectToDB().createStatement();
            stat.executeUpdate(removeUserId);
            System.out.println("запрос выполнился успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        //если нужно возвращать значение.
        //прочитать про резалт сет как работает
//        List<User> user = new ArrayList<>();
//        try {
//            Statement stat = util.connectToDB().createStatement();
//            ResultSet rs = stat.executeQuery("SELECT * FROM Users");
//            while(rs.next() {
//
//            }
//
//        } catch(SQLException e){}

       return null;
    }

    public void cleanUsersTable() {
       String cleanUsersTable = "DELETE FROM Users";

        try{
            Statement stat = util.connectToDB().createStatement();
            stat.executeUpdate(cleanUsersTable);
            System.out.println("запрос выполнился успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package main.java;

import java.sql.*;
import java.util.Scanner;


public class Methods {

    //Declarations
    int user_id_entry;

    //SQL operations
    public String insertUsersSQL = "INSERT INTO users (username, password, email, name)" + " VALUES (?, ?, ?, ?)";
    public String selectAllUsersSQL = "SELECT * FROM users";
    public String updateUsersSQL = "UPDATE users SET username = ?, password = ?, email = ?, name = ? WHERE user_id = ?";
    public String deleteUsersSQL = "DELETE FROM users WHERE user_id =?";

    //SQL DB credentials
    public String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
    public String usernameDB = "root";
    public String passwordDB = "password";

}











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


        public void MainMenuSelect() {

            //Main menu options
            System.out.println("Select from the options below:");
            System.out.println("Press 1 to add a customer to the system \n Press 2 to view all customers in the system \n " +
                    "Press 3 to update a customer in the system \n Press 4 to delete a customer in the system");
            Scanner menuSelect = new Scanner(System.in);
            String dataInput = menuSelect.nextLine();

            switch (dataInput) {
                //Create User
                case "1":
                    try {
                        //Connection to DB
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);

                        //Add customer options
                        Scanner user1 = new Scanner(System.in);
                        System.out.println("What is your username?");
                        String username = user1.nextLine();
                        System.out.println("What is your password?");
                        String password = user1.nextLine();
                        System.out.println("What is your email?");
                        String email = user1.nextLine();
                        System.out.println("What is your name?");
                        String name = user1.nextLine();

                        //Set SQL entries
                        PreparedStatement statement = connection.prepareStatement(insertUsersSQL);
                        statement.setString(1, username);
                        statement.setString(2, password);
                        statement.setString(3, email);
                        statement.setString(4, name);

                        //Update the SQL table
                        int rows = statement.executeUpdate();

                        //Confirmation of successful SQL entries
                        if (rows > 0) {
                            System.out.println("A new user has been added successfully");
                        }
                        connection.close();
                        break;

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }


            }
        }
    }










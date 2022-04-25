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
                    //View users
                case "2":
                    try {
                        //Connection to DB
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);

                        //Read SQL entries
                        PreparedStatement statement = connection.prepareStatement(selectAllUsersSQL);

                        //Execute the query
                        ResultSet rs = statement.executeQuery();

                        while (rs.next()) {
                            int user_id = rs.getInt("user_id");
                            String username = rs.getString("username");
                            String password = rs.getString("password");
                            String email = rs.getString("email");
                            String name = rs.getString("name");
                            System.out.println(user_id + " " + username + " " + password + " " + email + " " + name);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();

                    }
                    break;
                    
                //Update user
                case "3":
                    try {
                        //Connection to DB
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);

                        //Enter user_id to be updated
                        Scanner user1 = new Scanner(System.in);
                        System.out.println("What is the user_id");
                        int user_id_entry = user1.nextInt();
                        user1.nextLine();

                        //Update customer options
                        Scanner case3 = new Scanner(System.in);
                        System.out.println("Enter the new username");
                        String username = user1.nextLine();
                        System.out.println("Enter the new password");
                        String password = user1.nextLine();
                        System.out.println("Enter the new email");
                        String email = user1.nextLine();
                        System.out.println("Enter the new name");
                        String name = user1.nextLine();

                        //Update SQL entries
                        PreparedStatement statement = connection.prepareStatement(updateUsersSQL);
                        statement.setString(1, username);
                        statement.setString(2, password);
                        statement.setString(3, email);
                        statement.setString(4, name);
                        statement.setInt(5, user_id_entry);

                        //Execute the query
                        int rs = statement.executeUpdate();

                        if (rs > 0) {
                            System.out.println("Row successfully updated");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }










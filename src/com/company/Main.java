package com.company;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Secrets54321&"
            );
            ResultSet results;
            int rowsAffected;

            Statement statement = connection.createStatement();


            statement.executeUpdate("insert into java_programming values (55,'Carl Davis','61')");
            statement.executeUpdate("insert into java_programming values (66,'Dennis Fredrickson','88')");
            statement.executeUpdate("insert into java_programming values (77,'Jane Richards','78')");
            results = statement.executeQuery("select * from java_programming where grade between 60 and 80");


            while (results.next()) {
                System.out.println(results.getString("id") + ", " + results.getString("name") + ", " + results.getString("grade"));
            }

            rowsAffected = statement.executeUpdate("update java_programming set grade='65' where name ='Carl Davis' ");
            System.out.println("Query complete, rows affected= " + rowsAffected);
            rowsAffected = statement.executeUpdate("delete from java_programming where name = 'Dennis Fredrickson'");
            System.out.println("Query complete, rows affected= " + rowsAffected);
            rowsAffected = statement.executeUpdate("update java_programming set grade='80' where id > '55' ");
            System.out.println("Query complete, rows affected= " + rowsAffected);
            results.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

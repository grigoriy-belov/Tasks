package com.alevel.textboard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Censorship {
    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.connect()) {
            try (Statement findAllComments = connection.createStatement()) {
                ResultSet comments = findAllComments.executeQuery("SELECT text FROM comments;");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}

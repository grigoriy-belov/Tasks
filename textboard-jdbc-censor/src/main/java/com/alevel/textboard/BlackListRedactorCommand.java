package com.alevel.textboard;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class BlackListRedactorCommand {
    public static void execute(String filePath) {
        try (Connection connection = ConnectionFactory.connect()) {
            connection.setAutoCommit(false);
            String updateComments = "UPDATE comments SET text = ? WHERE id = ?;";
            String updateThreads = "UPDATE threads SET title = ?, text = ? WHERE id = ?;";

            try (Statement statement = connection.createStatement();
                 PreparedStatement psComments = connection.prepareStatement(updateComments);
                 PreparedStatement psThreads = connection.prepareStatement(updateThreads)) {

                FileLoader fileLoader = new FileLoader(filePath);
                List<String> blackList = fileLoader.getBlackList();
                ResultSet commentsSet = statement.executeQuery("SELECT * FROM comments;");

                while (commentsSet.next()) {
                    String comment = commentsSet.getString("text");
                    Long id = commentsSet.getLong("id");

                    for (String word : blackList) {
                        comment = comment.replaceAll("(?i)" + word, "*");
                    }
                    psComments.setString(1, comment);
                    psComments.setLong(2, id);
                    psComments.executeUpdate();
                }

                ResultSet threadsSet = statement.executeQuery("SELECT id, title, text FROM threads;");

                while (threadsSet.next()) {
                    String text = threadsSet.getString("text");
                    String title = threadsSet.getString("title");
                    Long id = threadsSet.getLong("id");

                    for (String word : blackList) {
                        text = text.replaceAll("(?i)" + word, "*");
                        title = title.replaceAll("(?i)" + word, "*");
                    }
                    psThreads.setString(1, title);
                    psThreads.setString(2, text);
                    psThreads.setLong(3, id);
                    psThreads.executeUpdate();
                }
                connection.commit();
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

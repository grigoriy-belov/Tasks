import dao.comment.CommentDAO;
import dao.comment.JDBCCommentDAO;
import dao.thread.JDBCThreadDAO;
import dao.thread.ThreadDAO;
import model.Comment;
import model.Persisted;
import model.Thread;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FindThreadsByNameRunner {
    public static void main(String[] args) throws IOException, SQLException {
        try (Connection c = ConnectionFactory.connect()) {
            ThreadDAO threadDAO = new JDBCThreadDAO(c);
            CommentDAO commentDAO = new JDBCCommentDAO(c);
            List<Persisted<Long, Thread>> threads = threadDAO.findByName("world");
            StringBuilder sb = new StringBuilder();

            for (Persisted<Long, Thread> thread : threads) {

                User user = thread.getValue().getUser();
                sb.append(thread.getValue().getTitle().toUpperCase())
                        .append(" (").append(user.getNickname()).append(")")
                        .append("\n").append(thread.getValue().getText())
                        .append("\n");

                List<Persisted<Long, Comment>> comments = commentDAO.findByThreadId(thread.getId());

                for (Persisted<Long, Comment> comment : comments) {
                    User author = comment.getValue().getAuthor().getValue();
                    String text = comment.getValue().getText();
                    if (comment.getValue().getParentComment() == null) {
                        sb.append(author.getNickname()).append(": ")
                                .append(text).append("\n");
                        for (Comment reply : comment.getValue().getReplies()) {
                            sb.append("--- ").append(reply.getAuthor())
                                    .append(": ").append(reply.getText());
                        }
                    }
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}

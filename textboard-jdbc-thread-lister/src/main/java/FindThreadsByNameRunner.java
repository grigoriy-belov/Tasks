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
            List<Persisted<Long, Thread>> threads = threadDAO.findByName("textboard");
            StringBuilder sb = new StringBuilder();

            for (Persisted<Long, Thread> thread : threads) {

                User user = thread.getValue().getUser();
                sb.append(thread.getValue().getTitle().toUpperCase());
                sb.append(" (").append(user.getNickname()).append(")");
                sb.append("\n").append(thread.getValue().getText());
                sb.append("\n");

                List<Persisted<Long, Comment>> comments = commentDAO.findByThreadId(thread.getId());

                for (Persisted<Long, Comment> comment : comments) {
                    User author = comment.getValue().getAuthor().getValue();
                    String text = comment.getValue().getText();
                    sb.append("\t");
                    sb.append(author.getNickname()).append(": ");
                    sb.append(text).append("\n");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}

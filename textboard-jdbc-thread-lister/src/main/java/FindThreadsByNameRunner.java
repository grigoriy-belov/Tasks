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
            System.out.println(getThreadsOutput(args[0], new JDBCThreadDAO(c), new JDBCCommentDAO(c)));
        }
    }

    private static String getThreadsOutput(String threadName, ThreadDAO threadDAO, CommentDAO commentDAO) {
        List<Persisted<Long, Thread>> threads = threadDAO.findByName(threadName);
        StringBuilder sb = new StringBuilder();

        for (Persisted<Long, Thread> thread : threads) {

            User user = thread.getValue().getUser();
            sb.append(thread.getValue().getTitle().toUpperCase())
                    .append(" (").append(user.getNickname()).append(")")
                    .append("\n").append(thread.getValue().getText())
                    .append("\n\n");

            List<Persisted<Long, Comment>> comments = commentDAO.findByThreadId(thread.getId());

            for (Persisted<Long, Comment> comment : comments) {
                User author = comment.getValue().getAuthor().getValue();
                String text = comment.getValue().getText();
                if (comment.getValue().getParentComment() == null) {
                    sb.append(author.getNickname()).append(": ")
                            .append(text).append("\n");
                    getRepliesOutput(sb, comment.getValue(), 1);
                }
            }
            sb.append("----------------------------------------------------------------------\n\n");
        }
        return sb.toString();
    }

    private static String getRepliesOutput(StringBuilder sb, Comment comment, int indent) {
        for (Comment reply : comment.getReplies()) {
            sb.append("--- ".repeat(Math.max(0, indent)));
            sb.append(reply.getAuthor().getValue().getNickname())
                    .append(": ").append(reply.getText()).append("\n");
            if (reply.getReplies() != null) {
                getRepliesOutput(sb, reply, indent + 1);
            }
        }
        return sb.toString();
    }
}

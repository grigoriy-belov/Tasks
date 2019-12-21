import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        try(Connection c = ConnectionFactory.connect()) {
            String sql = "SELECT * FROM users WHERE id = ?";
            Long id = 1L;

            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();

                resultSet.next();
                String name = resultSet.getString(2);
                System.out.println(name);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int countLikesForPhoto()

}

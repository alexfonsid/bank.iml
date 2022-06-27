import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config/jdbc.properties"));

        Class.forName(properties.getProperty("driver-class-name"));

        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, login, password);
        String sql = "select * from city";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + "\t " + name);

        }

        connection.close();
    }
}

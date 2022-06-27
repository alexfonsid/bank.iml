package reposity;

import model.City;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class CityRepository {
    public void create(City city) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config/jdbc.properties"));

        Class.forName(properties.getProperty("driver-class-name"));

        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, login, password);

        String sql = "INSERT INTO city (name) " +
                "VALUES " +
                "(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, city.name);

        statement.execute();
        connection.close();
    }

    public void read() {}

    public void update() {}

    public void delete() {}
}
